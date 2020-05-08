package cl.cc.powerbi.pbix;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cl.cc.powerbi.client.model.Column;
import cl.cc.powerbi.client.model.CreateDatasetRequest;
import cl.cc.powerbi.client.model.CreateDatasetRequest.DefaultModeEnum;
import cl.cc.powerbi.pbix.model.Relationship;
import cl.cc.powerbi.pbix.model.StructureDescription;
import cl.cc.powerbi.pbix.model.Table;

/**
 *
 * @author CyberCastle
 */
public class StructureProcessor {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private final String structureDescriptionFilePath;
    private final List<String> hiddenTables = new ArrayList<>();

    private StructureDescription structure;

    public StructureProcessor(String structureDescriptionFilePath) {
        this.structureDescriptionFilePath = structureDescriptionFilePath;
    }

    public void processFile() throws StructureProcessorException {
        try {
            JsonParser jsonParser = new JsonFactory().createParser(new File(this.structureDescriptionFilePath));
            jsonParser.setCodec(new ObjectMapper());
            this.structure = jsonParser.readValueAs(StructureDescription.class);
        } catch (IOException ex) {
            throw new StructureProcessorException(ex);
        }
    }

    public CreateDatasetRequest createDatasetRequest(String name) {
        CreateDatasetRequest dataset = new CreateDatasetRequest();
        dataset.setName(name);
        this.addTablesToDataset(dataset);
        this.addRelationshipsToDataset(dataset);
        dataset.defaultMode(DefaultModeEnum.PUSH);
        return dataset;
    }

    public void addTablesToDataset(CreateDatasetRequest dataset) {
        List<Table> tablesSource = this.structure.getCreate().getDatabase().getModel().getTables();

        tablesSource.forEach((tableSource) -> {

            // We only list the visible tables, these will be created in Power BI Service
            if (tableSource.getIsHidden() == null || tableSource.getIsHidden() == false) {
                log.debug(String.format("Processing table %s.", tableSource.getName()));
                cl.cc.powerbi.client.model.Table tableTarget = new cl.cc.powerbi.client.model.Table();
                tableTarget.setName(tableSource.getName());

                tableTarget.setColumns(this.copyColumns(tableSource));
                if (tableSource.getMeasures() != null && !tableSource.getMeasures().isEmpty()) {
                    tableTarget.setMeasures(this.copyMeasures(tableSource));
                }

                dataset.addTablesItem(tableTarget);
            } else {
                hiddenTables.add(tableSource.getName());
            }
        });
    }

    public void addRelationshipsToDataset(CreateDatasetRequest dataset) {
        List<Relationship> relationshipsSource = this.structure.getCreate().getDatabase().getModel().getRelationships();

        relationshipsSource.forEach((relationshipSource) -> {
            log.debug(String.format("Processing relationship %s.", relationshipSource.getName()));

            // We only list the active relationships, these will be created in Power BI
            // Service
            if (relationshipSource.getIsActive() == null || relationshipSource.getIsActive() == true) {

                cl.cc.powerbi.client.model.Relationship relationshipTarget = new cl.cc.powerbi.client.model.Relationship();
                relationshipTarget.setName(relationshipSource.getName());

                // Relationship with hidden tables references are ignored.
                if (!hiddenTables.contains(relationshipSource.getFromTable())
                        && !hiddenTables.contains(relationshipSource.getToTable())) {

                    relationshipTarget
                            .crossFilteringBehavior(cl.cc.powerbi.client.model.Relationship.CrossFilteringBehaviorEnum
                                    .fromValue(relationshipSource.getCrossFilteringBehavior()))
                            .fromTable(relationshipSource.getFromTable()).fromColumn(relationshipSource.getFromColumn())
                            .toTable(relationshipSource.getToTable()).toColumn(relationshipSource.getToColumn());

                    dataset.addRelationshipsItem(relationshipTarget);
                }
            }
        });
    }

    private List<cl.cc.powerbi.client.model.Column> copyColumns(Table tableSource) {
        List<cl.cc.powerbi.client.model.Column> columnsTarget = new LinkedList<>();
        tableSource.getColumns().forEach((columnSource) -> {
            log.debug(
                    String.format("Processing column %s of table %s.", columnSource.getName(), tableSource.getName()));
            columnsTarget.add(new Column().name(columnSource.getName()).dataType(columnSource.getDataType()));
        });
        return columnsTarget;
    }

    private List<cl.cc.powerbi.client.model.Measure> copyMeasures(Table tableSource) {
        List<cl.cc.powerbi.client.model.Measure> measuresTarget = new LinkedList<>();
        tableSource.getMeasures().forEach((measureSource) -> {
            log.debug(String.format("Processing measure %s of table %s.", measureSource.getName(),
                    tableSource.getName()));

            cl.cc.powerbi.client.model.Measure measureTarget = new cl.cc.powerbi.client.model.Measure();
            measureTarget.setName(measureSource.getName());
            measureTarget.setExpression(this.concatenateArrayStringList(measureSource.getExpression()));
            measuresTarget.add(measureTarget);
        });
        return measuresTarget;
    }

    private String concatenateArrayStringList(List<String> strings) {
        final StringBuilder builder = new StringBuilder();

        strings.forEach((s) -> {
            builder.append(s).append("\n");
        });

        return builder.toString();
    }
}

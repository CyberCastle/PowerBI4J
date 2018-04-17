package cl.cc.powerbi.loadmodel;

import cl.cc.powerbi.api.model.Column;
import cl.cc.powerbi.api.model.Dataset;
import cl.cc.powerbi.api.model.Measure;
import cl.cc.powerbi.datamodel.Relationship;
import cl.cc.powerbi.datamodel.StructureDescription;
import cl.cc.powerbi.datamodel.Table;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author CyberCastle
 */
public class StructureProcessor {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private final String structureDescriptionFilePath;
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

    public Dataset generateDataset(String name) {
        Dataset dataset = new Dataset(name);
        this.addTablesToDataset(dataset);
        this.addRelationshipsToDataset(dataset);
        return dataset;
    }

    public void addTablesToDataset(Dataset dataset) {
        List<Table> tablesSource = this.structure.getCreate().getDatabase().getModel().getTables();

        tablesSource.forEach((tableSource) -> {
            // We only list the visible tables, these will be created in Power BI Service
            if (tableSource.getIsHidden() == null || tableSource.getIsHidden() == false) {
                log.debug(String.format("Processing table %s.", tableSource.getName()));
                cl.cc.powerbi.api.model.Table tableTarget = new cl.cc.powerbi.api.model.Table(tableSource.getName());
                tableTarget.setColumns(this.copyColumns(tableSource));
                if (tableSource.getMeasures() != null &&  ! tableSource.getMeasures().isEmpty()) {
                    tableTarget.setMeasures(this.copyMeasures(tableSource));
                }
                dataset.addTablesItem(tableTarget);
            }
        });
    }

    public void addRelationshipsToDataset(Dataset dataset) {
        List<Relationship> relationshipsSource = this.structure.getCreate().getDatabase().getModel().getRelationships();

        relationshipsSource.forEach((relationshipSource) -> {
            log.debug(String.format("Processing relationship %s.", relationshipSource.getName()));
            cl.cc.powerbi.api.model.Relationship relationshipTarget = new cl.cc.powerbi.api.model.Relationship(relationshipSource.getName());
            relationshipTarget.crossFilteringBehavior(
                    cl.cc.powerbi.api.model.Relationship.CrossFilteringBehaviorEnum.fromValue(relationshipSource.getCrossFilteringBehavior())
            ).setReferences(relationshipSource.getFromTable(),
                    relationshipSource.getFromColumn(),
                    relationshipSource.getToTable(),
                    relationshipSource.getToColumn()
            );
        });
    }

    private List<cl.cc.powerbi.api.model.Column> copyColumns(Table tableSource) {
        List<cl.cc.powerbi.api.model.Column> columnsTarget = new LinkedList<>();
        tableSource.getColumns().forEach(
                (columnSource) -> {
                    log.debug(String.format("Processing column %s of table %s.", columnSource.getName(), tableSource.getName()));
                    columnsTarget.add(new Column(columnSource.getName(), Column.DataType.fromValue(columnSource.getDataType())));
                });
        return columnsTarget;
    }

    private List<cl.cc.powerbi.api.model.Measure> copyMeasures(Table tableSource) {
        List<cl.cc.powerbi.api.model.Measure> measuresTarget = new LinkedList<>();
        tableSource.getMeasures().forEach(
                (measureSource) -> {
                    log.debug(String.format("Processing measure %s of table %s.", measureSource.getName(), tableSource.getName()));
                    measuresTarget.add(
                            new Measure(
                                    measureSource.getName(),
                                    this.concatenateArrayStringList(measureSource.getExpression()),
                                    measureSource.getFormatString()
                            )
                    );
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

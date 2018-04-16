package cl.cc.powerbi.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * A dataset table
 *
 * @author CyberCastle
 */
@JsonPropertyOrder({
    "name",
    "columns",
    "rows"
})
public class Table {

    @JsonProperty("name")
    private String name = null;

    @JsonProperty("columns")
    private List<Column> columns = new ArrayList<Column>();

    @JsonProperty("measures")
    private List<Measure> measures = new ArrayList<Measure>();

    @JsonProperty("rows")
    private List<Row> rows = null;

    public Table() {

    }

    public Table(String name) {
        this.name = name;
    }

    public Table name(String name) {
        this.name = name;
        return this;
    }

    /**
     * The table name
     *
     * @return name
     *
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Table columns(List<Column> columns) {
        this.columns = columns;
        return this;
    }

    public Table addColumnsItem(Column columnsItem) {
        this.columns.add(columnsItem);
        return this;
    }

    /**
     * The column schema for this table
     *
     * @return columns
     *
     */
    public List<Column> getColumns() {
        return columns;
    }

    public void setColumns(List<Column> columns) {
        this.columns = columns;
    }

    public Table addMeasuresItem(Measure measuresItem) {
        if (this.measures == null) {
            this.measures = new ArrayList<>();
        }
        this.measures.add(measuresItem);
        return this;
    }

    /**
     * The measures within this table
     *
     * @return measures
     *
     */
    public List<Measure> getMeasures() {
        return measures;
    }

    public void setMeasures(List<Measure> measures) {
        this.measures = measures;
    }

    public Table rows(List<Row> rows) {
        this.rows = rows;
        return this;
    }

    public Table addRowsItem(Row rowsItem) {
        if (this.rows == null) {
            this.rows = new ArrayList<>();
        }
        this.rows.add(rowsItem);
        return this;
    }

    /**
     * The data rows within this table
     *
     * @return rows
     *
     */
    public List<Row> getRows() {
        return rows;
    }

    public void setRows(List<Row> rows) {
        this.rows = rows;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Table table = (Table) o;
        return Objects.equals(this.name, table.name)
                && Objects.equals(this.columns, table.columns)
                && Objects.equals(this.rows, table.rows);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, columns, rows);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Table {\n");

        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    columns: ").append(toIndentedString(columns)).append("\n");
        sb.append("    rows: ").append(toIndentedString(rows)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

}

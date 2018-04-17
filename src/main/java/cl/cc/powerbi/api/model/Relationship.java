package cl.cc.powerbi.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * A relationship between tables in a dataset
 *
 * @author CyberCastle
 */
public class Relationship {

    @JsonProperty("name")
    private String name;

    /**
     * The filter direction of the relationship
     */
    public enum CrossFilteringBehaviorEnum {
        ONEDIRECTION("OneDirection"),
        BOTHDIRECTIONS("BothDirections"),
        AUTOMATIC("Automatic");

        private final String value;

        CrossFilteringBehaviorEnum(String value) {
            this.value = value;
        }

        @JsonValue
        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        @JsonCreator
        public static CrossFilteringBehaviorEnum fromValue(String text) {
            for (CrossFilteringBehaviorEnum b : CrossFilteringBehaviorEnum.values()) {
                if (String.valueOf(b.value).equalsIgnoreCase(text)) {
                    return b;
                }
            }
            return null;
        }
    }

    @JsonProperty("crossFilteringBehavior")
    private CrossFilteringBehaviorEnum crossFilteringBehavior = CrossFilteringBehaviorEnum.ONEDIRECTION;

    @JsonProperty("fromTable")
    private String fromTable;

    @JsonProperty("fromColumn")
    private String fromColumn;

    @JsonProperty("toTable")
    private String toTable;

    @JsonProperty("toColumn")
    private String toColumn;

    public Relationship name(String name) {
        this.name = name;
        return this;
    }

    /**
     * The relationship name and identifier
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

    public Relationship crossFilteringBehavior(CrossFilteringBehaviorEnum crossFilteringBehavior) {
        this.crossFilteringBehavior = crossFilteringBehavior;
        return this;
    }

    /**
     * The filter direction of the relationship
     *
     * @return crossFilteringBehavior
     *
     */
    public CrossFilteringBehaviorEnum getCrossFilteringBehavior() {
        return crossFilteringBehavior;
    }

    public void setCrossFilteringBehavior(CrossFilteringBehaviorEnum crossFilteringBehavior) {
        this.crossFilteringBehavior = crossFilteringBehavior;
    }

    public Relationship fromTable(String fromTable) {
        this.fromTable = fromTable;
        return this;
    }

    /**
     * The name of the foreign key table
     *
     * @return fromTable
     *
     */
    public String getFromTable() {
        return fromTable;
    }

    public void setFromTable(String fromTable) {
        this.fromTable = fromTable;
    }

    public Relationship fromColumn(String fromColumn) {
        this.fromColumn = fromColumn;
        return this;
    }

    /**
     * The name of the foreign key column
     *
     * @return fromColumn
     *
     */
    public String getFromColumn() {
        return fromColumn;
    }

    public void setFromColumn(String fromColumn) {
        this.fromColumn = fromColumn;
    }

    public Relationship toTable(String toTable) {
        this.toTable = toTable;
        return this;
    }

    /**
     * The name of the primary key table
     *
     * @return toTable
     *
     */
    public String getToTable() {
        return toTable;
    }

    public void setToTable(String toTable) {
        this.toTable = toTable;
    }

    public Relationship toColumn(String toColumn) {
        this.toColumn = toColumn;
        return this;
    }

    /**
     * The name of the primary key column
     *
     * @return toColumn
     *
     */
    public String getToColumn() {
        return toColumn;
    }

    public void setToColumn(String toColumn) {
        this.toColumn = toColumn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Relationship relationship = (Relationship) o;
        return Objects.equals(this.name, relationship.name)
                && Objects.equals(this.crossFilteringBehavior, relationship.crossFilteringBehavior)
                && Objects.equals(this.fromTable, relationship.fromTable)
                && Objects.equals(this.fromColumn, relationship.fromColumn)
                && Objects.equals(this.toTable, relationship.toTable)
                && Objects.equals(this.toColumn, relationship.toColumn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, crossFilteringBehavior, fromTable, fromColumn, toTable, toColumn);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Relationship {\n");

        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    crossFilteringBehavior: ").append(toIndentedString(crossFilteringBehavior)).append("\n");
        sb.append("    fromTable: ").append(toIndentedString(fromTable)).append("\n");
        sb.append("    fromColumn: ").append(toIndentedString(fromColumn)).append("\n");
        sb.append("    toTable: ").append(toIndentedString(toTable)).append("\n");
        sb.append("    toColumn: ").append(toIndentedString(toColumn)).append("\n");
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

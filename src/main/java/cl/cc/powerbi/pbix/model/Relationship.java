
package cl.cc.powerbi.pbix.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "name", "fromTable", "fromColumn", "toTable", "toColumn", "joinOnDateBehavior", "isActive",
        "crossFilteringBehavior", "fromCardinality" })
public class Relationship implements Serializable {

    @JsonProperty("name")
    private String name;
    @JsonProperty("fromTable")
    private String fromTable;
    @JsonProperty("fromColumn")
    private String fromColumn;
    @JsonProperty("toTable")
    private String toTable;
    @JsonProperty("toColumn")
    private String toColumn;
    @JsonProperty("joinOnDateBehavior")
    private String joinOnDateBehavior;
    @JsonProperty("isActive")
    private Boolean isActive;
    @JsonProperty("crossFilteringBehavior")
    private String crossFilteringBehavior;
    @JsonProperty("fromCardinality")
    private String fromCardinality;
    private final static long serialVersionUID = -6024504843478585780L;

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("fromTable")
    public String getFromTable() {
        return fromTable;
    }

    @JsonProperty("fromTable")
    public void setFromTable(String fromTable) {
        this.fromTable = fromTable;
    }

    @JsonProperty("fromColumn")
    public String getFromColumn() {
        return fromColumn;
    }

    @JsonProperty("fromColumn")
    public void setFromColumn(String fromColumn) {
        this.fromColumn = fromColumn;
    }

    @JsonProperty("toTable")
    public String getToTable() {
        return toTable;
    }

    @JsonProperty("toTable")
    public void setToTable(String toTable) {
        this.toTable = toTable;
    }

    @JsonProperty("toColumn")
    public String getToColumn() {
        return toColumn;
    }

    @JsonProperty("toColumn")
    public void setToColumn(String toColumn) {
        this.toColumn = toColumn;
    }

    @JsonProperty("joinOnDateBehavior")
    public String getJoinOnDateBehavior() {
        return joinOnDateBehavior;
    }

    @JsonProperty("joinOnDateBehavior")
    public void setJoinOnDateBehavior(String joinOnDateBehavior) {
        this.joinOnDateBehavior = joinOnDateBehavior;
    }

    @JsonProperty("isActive")
    public Boolean getIsActive() {
        return isActive;
    }

    @JsonProperty("isActive")
    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    @JsonProperty("crossFilteringBehavior")
    public String getCrossFilteringBehavior() {
        return crossFilteringBehavior;
    }

    @JsonProperty("crossFilteringBehavior")
    public void setCrossFilteringBehavior(String crossFilteringBehavior) {
        this.crossFilteringBehavior = crossFilteringBehavior;
    }

    @JsonProperty("fromCardinality")
    public String getFromCardinality() {
        return fromCardinality;
    }

    @JsonProperty("fromCardinality")
    public void setFromCardinality(String fromCardinality) {
        this.fromCardinality = fromCardinality;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Relationship.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)))
                .append('[');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null) ? "<null>" : this.name));
        sb.append(',');
        sb.append("fromTable");
        sb.append('=');
        sb.append(((this.fromTable == null) ? "<null>" : this.fromTable));
        sb.append(',');
        sb.append("fromColumn");
        sb.append('=');
        sb.append(((this.fromColumn == null) ? "<null>" : this.fromColumn));
        sb.append(',');
        sb.append("toTable");
        sb.append('=');
        sb.append(((this.toTable == null) ? "<null>" : this.toTable));
        sb.append(',');
        sb.append("toColumn");
        sb.append('=');
        sb.append(((this.toColumn == null) ? "<null>" : this.toColumn));
        sb.append(',');
        sb.append("joinOnDateBehavior");
        sb.append('=');
        sb.append(((this.joinOnDateBehavior == null) ? "<null>" : this.joinOnDateBehavior));
        sb.append(',');
        sb.append("isActive");
        sb.append('=');
        sb.append(((this.isActive == null) ? "<null>" : this.isActive));
        sb.append(',');
        sb.append("crossFilteringBehavior");
        sb.append('=');
        sb.append(((this.crossFilteringBehavior == null) ? "<null>" : this.crossFilteringBehavior));
        sb.append(',');
        sb.append("fromCardinality");
        sb.append('=');
        sb.append(((this.fromCardinality == null) ? "<null>" : this.fromCardinality));
        sb.append(',');
        if (sb.charAt((sb.length() - 1)) == ',') {
            sb.setCharAt((sb.length() - 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result * 31) + ((this.name == null) ? 0 : this.name.hashCode()));
        result = ((result * 31) + ((this.crossFilteringBehavior == null) ? 0 : this.crossFilteringBehavior.hashCode()));
        result = ((result * 31) + ((this.fromColumn == null) ? 0 : this.fromColumn.hashCode()));
        result = ((result * 31) + ((this.toTable == null) ? 0 : this.toTable.hashCode()));
        result = ((result * 31) + ((this.joinOnDateBehavior == null) ? 0 : this.joinOnDateBehavior.hashCode()));
        result = ((result * 31) + ((this.fromCardinality == null) ? 0 : this.fromCardinality.hashCode()));
        result = ((result * 31) + ((this.isActive == null) ? 0 : this.isActive.hashCode()));
        result = ((result * 31) + ((this.toColumn == null) ? 0 : this.toColumn.hashCode()));
        result = ((result * 31) + ((this.fromTable == null) ? 0 : this.fromTable.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Relationship) == false) {
            return false;
        }
        Relationship rhs = ((Relationship) other);
        return ((((((((((this.name == rhs.name) || ((this.name != null) && this.name.equals(rhs.name)))
                && ((this.crossFilteringBehavior == rhs.crossFilteringBehavior)
                        || ((this.crossFilteringBehavior != null)
                                && this.crossFilteringBehavior.equals(rhs.crossFilteringBehavior))))
                && ((this.fromColumn == rhs.fromColumn)
                        || ((this.fromColumn != null) && this.fromColumn.equals(rhs.fromColumn))))
                && ((this.toTable == rhs.toTable) || ((this.toTable != null) && this.toTable.equals(rhs.toTable))))
                && ((this.joinOnDateBehavior == rhs.joinOnDateBehavior) || ((this.joinOnDateBehavior != null)
                        && this.joinOnDateBehavior.equals(rhs.joinOnDateBehavior))))
                && ((this.fromCardinality == rhs.fromCardinality)
                        || ((this.fromCardinality != null) && this.fromCardinality.equals(rhs.fromCardinality))))
                && ((this.isActive == rhs.isActive) || ((this.isActive != null) && this.isActive.equals(rhs.isActive))))
                && ((this.toColumn == rhs.toColumn) || ((this.toColumn != null) && this.toColumn.equals(rhs.toColumn))))
                && ((this.fromTable == rhs.fromTable)
                        || ((this.fromTable != null) && this.fromTable.equals(rhs.fromTable))));
    }

}

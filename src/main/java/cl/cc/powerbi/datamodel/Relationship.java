package cl.cc.powerbi.datamodel;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 *
 * @author CyberCastle
 */
@JsonPropertyOrder({
    "name",
    "fromTable",
    "fromColumn",
    "toTable",
    "toColumn",
    "joinOnDateBehavior",
    "isActive",
    "crossFilteringBehavior",
    "fromCardinality"
})
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
        return new ToStringBuilder(this).append("name", name).append("fromTable", fromTable).append("fromColumn", fromColumn).append("toTable", toTable).append("toColumn", toColumn).append("joinOnDateBehavior", joinOnDateBehavior).append("isActive", isActive).append("crossFilteringBehavior", crossFilteringBehavior).append("fromCardinality", fromCardinality).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(name).append(crossFilteringBehavior).append(fromColumn).append(toTable).append(joinOnDateBehavior).append(fromCardinality).append(isActive).append(toColumn).append(fromTable).toHashCode();
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
        return new EqualsBuilder().append(name, rhs.name).append(crossFilteringBehavior, rhs.crossFilteringBehavior).append(fromColumn, rhs.fromColumn).append(toTable, rhs.toTable).append(joinOnDateBehavior, rhs.joinOnDateBehavior).append(fromCardinality, rhs.fromCardinality).append(isActive, rhs.isActive).append(toColumn, rhs.toColumn).append(fromTable, rhs.fromTable).isEquals();
    }

}

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
    "table",
    "hierarchy"
})
public class DefaultHierarchy implements Serializable {

    @JsonProperty("table")
    private String table;
    @JsonProperty("hierarchy")
    private String hierarchy;
    private final static long serialVersionUID = -608445291373319380L;

    @JsonProperty("table")
    public String getTable() {
        return table;
    }

    @JsonProperty("table")
    public void setTable(String table) {
        this.table = table;
    }

    @JsonProperty("hierarchy")
    public String getHierarchy() {
        return hierarchy;
    }

    @JsonProperty("hierarchy")
    public void setHierarchy(String hierarchy) {
        this.hierarchy = hierarchy;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("table", table).append("hierarchy", hierarchy).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(table).append(hierarchy).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof DefaultHierarchy) == false) {
            return false;
        }
        DefaultHierarchy rhs = ((DefaultHierarchy) other);
        return new EqualsBuilder().append(table, rhs.table).append(hierarchy, rhs.hierarchy).isEquals();
    }

}


package cl.cc.powerbi.pbix.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "table", "hierarchy" })
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
        StringBuilder sb = new StringBuilder();
        sb.append(DefaultHierarchy.class.getName()).append('@')
                .append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("table");
        sb.append('=');
        sb.append(((this.table == null) ? "<null>" : this.table));
        sb.append(',');
        sb.append("hierarchy");
        sb.append('=');
        sb.append(((this.hierarchy == null) ? "<null>" : this.hierarchy));
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
        result = ((result * 31) + ((this.table == null) ? 0 : this.table.hashCode()));
        result = ((result * 31) + ((this.hierarchy == null) ? 0 : this.hierarchy.hashCode()));
        return result;
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
        return (((this.table == rhs.table) || ((this.table != null) && this.table.equals(rhs.table)))
                && ((this.hierarchy == rhs.hierarchy)
                        || ((this.hierarchy != null) && this.hierarchy.equals(rhs.hierarchy))));
    }

}

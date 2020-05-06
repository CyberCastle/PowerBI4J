
package cl.cc.powerbi.pbix.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "name", "ordinal", "column" })
public class Level implements Serializable {

    @JsonProperty("name")
    private String name;
    @JsonProperty("ordinal")
    private Integer ordinal;
    @JsonProperty("column")
    private String column;
    private final static long serialVersionUID = 1065460579303325801L;

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("ordinal")
    public Integer getOrdinal() {
        return ordinal;
    }

    @JsonProperty("ordinal")
    public void setOrdinal(Integer ordinal) {
        this.ordinal = ordinal;
    }

    @JsonProperty("column")
    public String getColumn() {
        return column;
    }

    @JsonProperty("column")
    public void setColumn(String column) {
        this.column = column;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Level.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)))
                .append('[');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null) ? "<null>" : this.name));
        sb.append(',');
        sb.append("ordinal");
        sb.append('=');
        sb.append(((this.ordinal == null) ? "<null>" : this.ordinal));
        sb.append(',');
        sb.append("column");
        sb.append('=');
        sb.append(((this.column == null) ? "<null>" : this.column));
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
        result = ((result * 31) + ((this.column == null) ? 0 : this.column.hashCode()));
        result = ((result * 31) + ((this.ordinal == null) ? 0 : this.ordinal.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Level) == false) {
            return false;
        }
        Level rhs = ((Level) other);
        return ((((this.name == rhs.name) || ((this.name != null) && this.name.equals(rhs.name)))
                && ((this.column == rhs.column) || ((this.column != null) && this.column.equals(rhs.column))))
                && ((this.ordinal == rhs.ordinal) || ((this.ordinal != null) && this.ordinal.equals(rhs.ordinal))));
    }

}

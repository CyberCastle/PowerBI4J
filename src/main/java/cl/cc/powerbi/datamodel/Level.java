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
        return new ToStringBuilder(this).append("name", name).append("ordinal", ordinal).append("column", column)
                .toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(name).append(column).append(ordinal).toHashCode();
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
        return new EqualsBuilder().append(name, rhs.name).append(column, rhs.column).append(ordinal, rhs.ordinal)
                .isEquals();
    }

}

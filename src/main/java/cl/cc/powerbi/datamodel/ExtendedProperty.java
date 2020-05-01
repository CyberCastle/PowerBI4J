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
@JsonPropertyOrder({ "type", "name", "value" })
public class ExtendedProperty implements Serializable {

    @JsonProperty("type")
    private String type;
    @JsonProperty("name")
    private String name;
    @JsonProperty("value")
    private Value value;
    private final static long serialVersionUID = 4244839909338158128L;

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("value")
    public Value getValue() {
        return value;
    }

    @JsonProperty("value")
    public void setValue(Value value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("type", type).append("name", name).append("value", value).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(name).append(type).append(value).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ExtendedProperty) == false) {
            return false;
        }
        ExtendedProperty rhs = ((ExtendedProperty) other);
        return new EqualsBuilder().append(name, rhs.name).append(type, rhs.type).append(value, rhs.value).isEquals();
    }

}

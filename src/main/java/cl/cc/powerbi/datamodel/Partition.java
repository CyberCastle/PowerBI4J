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
@JsonPropertyOrder({ "name", "mode", "source" })
public class Partition implements Serializable {

    @JsonProperty("name")
    private String name;
    @JsonProperty("mode")
    private String mode;
    @JsonProperty("source")
    private Source source;
    private final static long serialVersionUID = -1226871325606304544L;

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("mode")
    public String getMode() {
        return mode;
    }

    @JsonProperty("mode")
    public void setMode(String mode) {
        this.mode = mode;
    }

    @JsonProperty("source")
    public Source getSource() {
        return source;
    }

    @JsonProperty("source")
    public void setSource(Source source) {
        this.source = source;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("name", name).append("mode", mode).append("source", source).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(name).append(mode).append(source).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Partition) == false) {
            return false;
        }
        Partition rhs = ((Partition) other);
        return new EqualsBuilder().append(name, rhs.name).append(mode, rhs.mode).append(source, rhs.source).isEquals();
    }

}

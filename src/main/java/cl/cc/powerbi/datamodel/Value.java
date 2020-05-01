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
@JsonPropertyOrder({ "version", "daxTemplateName" })
public class Value implements Serializable {

    @JsonProperty("version")
    private Integer version;
    @JsonProperty("daxTemplateName")
    private String daxTemplateName;
    private final static long serialVersionUID = -914748847929692606L;

    @JsonProperty("version")
    public Integer getVersion() {
        return version;
    }

    @JsonProperty("version")
    public void setVersion(Integer version) {
        this.version = version;
    }

    @JsonProperty("daxTemplateName")
    public String getDaxTemplateName() {
        return daxTemplateName;
    }

    @JsonProperty("daxTemplateName")
    public void setDaxTemplateName(String daxTemplateName) {
        this.daxTemplateName = daxTemplateName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("version", version).append("daxTemplateName", daxTemplateName)
                .toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(version).append(daxTemplateName).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Value) == false) {
            return false;
        }
        Value rhs = ((Value) other);
        return new EqualsBuilder().append(version, rhs.version).append(daxTemplateName, rhs.daxTemplateName).isEquals();
    }

}


package cl.cc.powerbi.datamodel;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
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
        StringBuilder sb = new StringBuilder();
        sb.append(Value.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)))
                .append('[');
        sb.append("version");
        sb.append('=');
        sb.append(((this.version == null) ? "<null>" : this.version));
        sb.append(',');
        sb.append("daxTemplateName");
        sb.append('=');
        sb.append(((this.daxTemplateName == null) ? "<null>" : this.daxTemplateName));
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
        result = ((result * 31) + ((this.version == null) ? 0 : this.version.hashCode()));
        result = ((result * 31) + ((this.daxTemplateName == null) ? 0 : this.daxTemplateName.hashCode()));
        return result;
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
        return (((this.version == rhs.version) || ((this.version != null) && this.version.equals(rhs.version)))
                && ((this.daxTemplateName == rhs.daxTemplateName)
                        || ((this.daxTemplateName != null) && this.daxTemplateName.equals(rhs.daxTemplateName))));
    }

}

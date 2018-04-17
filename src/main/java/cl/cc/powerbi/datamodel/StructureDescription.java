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

 Code generated with follow command: jsonschema2pojo -s StructureDescription.json -t
 targetFolder -a JACKSON2 -p cl.cc.powerbi.datamodel -sl -T JSON -tv 1.8 -c3

 Instructions to obtain the data model here:
 http://blogs.adatis.co.uk/simonwhiteley/post/PowerBI-Optimisation-P3-Extracting-and-Source-Controlling-PowerBI-Data-Models
 */
@JsonPropertyOrder({
    "create"
})
public class StructureDescription implements Serializable {

    @JsonProperty("create")
    private Create create;
    private final static long serialVersionUID = 902245685706333983L;

    @JsonProperty("create")
    public Create getCreate() {
        return create;
    }

    @JsonProperty("create")
    public void setCreate(Create create) {
        this.create = create;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("create", create).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(create).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof StructureDescription) == false) {
            return false;
        }
        StructureDescription rhs = ((StructureDescription) other);
        return new EqualsBuilder().append(create, rhs.create).isEquals();
    }

}

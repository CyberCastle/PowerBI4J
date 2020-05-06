package cl.cc.powerbi.datamodel;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 *
 * @author CyberCastle
 * 
 *         Code generated with follow command:
 * 
 *         jsonschema2pojo -s StructureDescription.json -t targetFolder -a
 *         JACKSON2 -p cl.cc.powerbi.datamodel -sl -T JSON -tv 1.8 -c3
 * 
 *         jsonschema2pojo is obtained form here:
 *         https://github.com/joelittlejohn/jsonschema2pojo
 * 
 *         Instructions to obtain the data model here:
 *         http://blogs.adatis.co.uk/simonwhiteley/post/PowerBI-Optimisation-P3-Extracting-and-Source-Controlling-PowerBI-Data-Models
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "create" })
public class StructureDescription implements Serializable {

    @JsonProperty("create")
    private Create create;
    private final static long serialVersionUID = 2944055645417398816L;

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
        StringBuilder sb = new StringBuilder();
        sb.append(StructureDescription.class.getName()).append('@')
                .append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("create");
        sb.append('=');
        sb.append(((this.create == null) ? "<null>" : this.create));
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
        result = ((result * 31) + ((this.create == null) ? 0 : this.create.hashCode()));
        return result;
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
        return ((this.create == rhs.create) || ((this.create != null) && this.create.equals(rhs.create)));
    }

}

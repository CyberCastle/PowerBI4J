
package cl.cc.powerbi.pbix.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "name", "relationship", "defaultHierarchy", "isDefault" })
public class Variation implements Serializable {

    @JsonProperty("name")
    private String name;
    @JsonProperty("relationship")
    private String relationship;
    @JsonProperty("defaultHierarchy")
    private DefaultHierarchy defaultHierarchy;
    @JsonProperty("isDefault")
    private Boolean isDefault;
    private final static long serialVersionUID = -819451934748728840L;

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("relationship")
    public String getRelationship() {
        return relationship;
    }

    @JsonProperty("relationship")
    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    @JsonProperty("defaultHierarchy")
    public DefaultHierarchy getDefaultHierarchy() {
        return defaultHierarchy;
    }

    @JsonProperty("defaultHierarchy")
    public void setDefaultHierarchy(DefaultHierarchy defaultHierarchy) {
        this.defaultHierarchy = defaultHierarchy;
    }

    @JsonProperty("isDefault")
    public Boolean getIsDefault() {
        return isDefault;
    }

    @JsonProperty("isDefault")
    public void setIsDefault(Boolean isDefault) {
        this.isDefault = isDefault;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Variation.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)))
                .append('[');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null) ? "<null>" : this.name));
        sb.append(',');
        sb.append("relationship");
        sb.append('=');
        sb.append(((this.relationship == null) ? "<null>" : this.relationship));
        sb.append(',');
        sb.append("defaultHierarchy");
        sb.append('=');
        sb.append(((this.defaultHierarchy == null) ? "<null>" : this.defaultHierarchy));
        sb.append(',');
        sb.append("isDefault");
        sb.append('=');
        sb.append(((this.isDefault == null) ? "<null>" : this.isDefault));
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
        result = ((result * 31) + ((this.isDefault == null) ? 0 : this.isDefault.hashCode()));
        result = ((result * 31) + ((this.defaultHierarchy == null) ? 0 : this.defaultHierarchy.hashCode()));
        result = ((result * 31) + ((this.relationship == null) ? 0 : this.relationship.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Variation) == false) {
            return false;
        }
        Variation rhs = ((Variation) other);
        return (((((this.name == rhs.name) || ((this.name != null) && this.name.equals(rhs.name)))
                && ((this.isDefault == rhs.isDefault)
                        || ((this.isDefault != null) && this.isDefault.equals(rhs.isDefault))))
                && ((this.defaultHierarchy == rhs.defaultHierarchy)
                        || ((this.defaultHierarchy != null) && this.defaultHierarchy.equals(rhs.defaultHierarchy))))
                && ((this.relationship == rhs.relationship)
                        || ((this.relationship != null) && this.relationship.equals(rhs.relationship))));
    }

}

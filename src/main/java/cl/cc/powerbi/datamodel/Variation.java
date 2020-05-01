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
        return new ToStringBuilder(this).append("name", name).append("relationship", relationship)
                .append("defaultHierarchy", defaultHierarchy).append("isDefault", isDefault).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(name).append(isDefault).append(defaultHierarchy).append(relationship)
                .toHashCode();
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
        return new EqualsBuilder().append(name, rhs.name).append(isDefault, rhs.isDefault)
                .append(defaultHierarchy, rhs.defaultHierarchy).append(relationship, rhs.relationship).isEquals();
    }

}

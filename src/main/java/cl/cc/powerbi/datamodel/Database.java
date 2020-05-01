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
@JsonPropertyOrder({ "name", "compatibilityLevel", "model" })
public class Database implements Serializable {

    @JsonProperty("name")
    private String name;
    @JsonProperty("compatibilityLevel")
    private Integer compatibilityLevel;
    @JsonProperty("model")
    private Model model;
    private final static long serialVersionUID = 7029354589855954731L;

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("compatibilityLevel")
    public Integer getCompatibilityLevel() {
        return compatibilityLevel;
    }

    @JsonProperty("compatibilityLevel")
    public void setCompatibilityLevel(Integer compatibilityLevel) {
        this.compatibilityLevel = compatibilityLevel;
    }

    @JsonProperty("model")
    public Model getModel() {
        return model;
    }

    @JsonProperty("model")
    public void setModel(Model model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("name", name).append("compatibilityLevel", compatibilityLevel)
                .append("model", model).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(name).append(model).append(compatibilityLevel).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Database) == false) {
            return false;
        }
        Database rhs = ((Database) other);
        return new EqualsBuilder().append(name, rhs.name).append(model, rhs.model)
                .append(compatibilityLevel, rhs.compatibilityLevel).isEquals();
    }

}

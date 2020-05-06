
package cl.cc.powerbi.pbix.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
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
        StringBuilder sb = new StringBuilder();
        sb.append(Database.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)))
                .append('[');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null) ? "<null>" : this.name));
        sb.append(',');
        sb.append("compatibilityLevel");
        sb.append('=');
        sb.append(((this.compatibilityLevel == null) ? "<null>" : this.compatibilityLevel));
        sb.append(',');
        sb.append("model");
        sb.append('=');
        sb.append(((this.model == null) ? "<null>" : this.model));
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
        result = ((result * 31) + ((this.model == null) ? 0 : this.model.hashCode()));
        result = ((result * 31) + ((this.compatibilityLevel == null) ? 0 : this.compatibilityLevel.hashCode()));
        return result;
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
        return ((((this.name == rhs.name) || ((this.name != null) && this.name.equals(rhs.name)))
                && ((this.model == rhs.model) || ((this.model != null) && this.model.equals(rhs.model))))
                && ((this.compatibilityLevel == rhs.compatibilityLevel) || ((this.compatibilityLevel != null)
                        && this.compatibilityLevel.equals(rhs.compatibilityLevel))));
    }

}

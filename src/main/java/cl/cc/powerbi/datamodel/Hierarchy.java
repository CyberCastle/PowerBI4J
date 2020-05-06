
package cl.cc.powerbi.datamodel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "name", "levels", "annotations" })
public class Hierarchy implements Serializable {

    @JsonProperty("name")
    private String name;
    @JsonProperty("levels")
    private List<Level> levels = new ArrayList<Level>();
    @JsonProperty("annotations")
    private List<Annotation> annotations = new ArrayList<Annotation>();
    private final static long serialVersionUID = -4315758689762869986L;

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("levels")
    public List<Level> getLevels() {
        return levels;
    }

    @JsonProperty("levels")
    public void setLevels(List<Level> levels) {
        this.levels = levels;
    }

    @JsonProperty("annotations")
    public List<Annotation> getAnnotations() {
        return annotations;
    }

    @JsonProperty("annotations")
    public void setAnnotations(List<Annotation> annotations) {
        this.annotations = annotations;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Hierarchy.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)))
                .append('[');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null) ? "<null>" : this.name));
        sb.append(',');
        sb.append("levels");
        sb.append('=');
        sb.append(((this.levels == null) ? "<null>" : this.levels));
        sb.append(',');
        sb.append("annotations");
        sb.append('=');
        sb.append(((this.annotations == null) ? "<null>" : this.annotations));
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
        result = ((result * 31) + ((this.annotations == null) ? 0 : this.annotations.hashCode()));
        result = ((result * 31) + ((this.levels == null) ? 0 : this.levels.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Hierarchy) == false) {
            return false;
        }
        Hierarchy rhs = ((Hierarchy) other);
        return ((((this.name == rhs.name) || ((this.name != null) && this.name.equals(rhs.name)))
                && ((this.annotations == rhs.annotations)
                        || ((this.annotations != null) && this.annotations.equals(rhs.annotations))))
                && ((this.levels == rhs.levels) || ((this.levels != null) && this.levels.equals(rhs.levels))));
    }

}

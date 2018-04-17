package cl.cc.powerbi.datamodel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 *
 * @author CyberCastle
 */
@JsonPropertyOrder({
    "name",
    "levels",
    "annotations"
})
public class Hierarchy implements Serializable {

    @JsonProperty("name")
    private String name;
    @JsonProperty("levels")
    private List<Level> levels = new ArrayList<Level>();
    @JsonProperty("annotations")
    private List<Annotation> annotations = new ArrayList<Annotation>();
    private final static long serialVersionUID = -1429019723314850238L;

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
        return new ToStringBuilder(this).append("name", name).append("levels", levels).append("annotations", annotations).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(name).append(annotations).append(levels).toHashCode();
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
        return new EqualsBuilder().append(name, rhs.name).append(annotations, rhs.annotations).append(levels, rhs.levels).isEquals();
    }

}

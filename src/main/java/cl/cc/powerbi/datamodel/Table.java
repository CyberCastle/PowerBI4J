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
@JsonPropertyOrder({ "name", "columns", "partitions", "annotations", "isHidden", "isPrivate", "hierarchies",
        "showAsVariationsOnly", "measures" })
public class Table implements Serializable {

    @JsonProperty("name")
    private String name;
    @JsonProperty("columns")
    private List<Column> columns = new ArrayList<Column>();
    @JsonProperty("partitions")
    private List<Partition> partitions = new ArrayList<Partition>();
    @JsonProperty("annotations")
    private List<Annotation> annotations = new ArrayList<Annotation>();
    @JsonProperty("isHidden")
    private Boolean isHidden;
    @JsonProperty("isPrivate")
    private Boolean isPrivate;
    @JsonProperty("hierarchies")
    private List<Hierarchy> hierarchies = new ArrayList<Hierarchy>();
    @JsonProperty("showAsVariationsOnly")
    private Boolean showAsVariationsOnly;
    @JsonProperty("measures")
    private List<Measure> measures = new ArrayList<Measure>();
    private final static long serialVersionUID = 1005061397432380127L;

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("columns")
    public List<Column> getColumns() {
        return columns;
    }

    @JsonProperty("columns")
    public void setColumns(List<Column> columns) {
        this.columns = columns;
    }

    @JsonProperty("partitions")
    public List<Partition> getPartitions() {
        return partitions;
    }

    @JsonProperty("partitions")
    public void setPartitions(List<Partition> partitions) {
        this.partitions = partitions;
    }

    @JsonProperty("annotations")
    public List<Annotation> getAnnotations() {
        return annotations;
    }

    @JsonProperty("annotations")
    public void setAnnotations(List<Annotation> annotations) {
        this.annotations = annotations;
    }

    @JsonProperty("isHidden")
    public Boolean getIsHidden() {
        return isHidden;
    }

    @JsonProperty("isHidden")
    public void setIsHidden(Boolean isHidden) {
        this.isHidden = isHidden;
    }

    @JsonProperty("isPrivate")
    public Boolean getIsPrivate() {
        return isPrivate;
    }

    @JsonProperty("isPrivate")
    public void setIsPrivate(Boolean isPrivate) {
        this.isPrivate = isPrivate;
    }

    @JsonProperty("hierarchies")
    public List<Hierarchy> getHierarchies() {
        return hierarchies;
    }

    @JsonProperty("hierarchies")
    public void setHierarchies(List<Hierarchy> hierarchies) {
        this.hierarchies = hierarchies;
    }

    @JsonProperty("showAsVariationsOnly")
    public Boolean getShowAsVariationsOnly() {
        return showAsVariationsOnly;
    }

    @JsonProperty("showAsVariationsOnly")
    public void setShowAsVariationsOnly(Boolean showAsVariationsOnly) {
        this.showAsVariationsOnly = showAsVariationsOnly;
    }

    @JsonProperty("measures")
    public List<Measure> getMeasures() {
        return measures;
    }

    @JsonProperty("measures")
    public void setMeasures(List<Measure> measures) {
        this.measures = measures;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("name", name).append("columns", columns)
                .append("partitions", partitions).append("annotations", annotations).append("isHidden", isHidden)
                .append("isPrivate", isPrivate).append("hierarchies", hierarchies)
                .append("showAsVariationsOnly", showAsVariationsOnly).append("measures", measures).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(partitions).append(measures).append(hierarchies).append(columns)
                .append(name).append(annotations).append(isPrivate).append(showAsVariationsOnly).append(isHidden)
                .toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Table) == false) {
            return false;
        }
        Table rhs = ((Table) other);
        return new EqualsBuilder().append(partitions, rhs.partitions).append(measures, rhs.measures)
                .append(hierarchies, rhs.hierarchies).append(columns, rhs.columns).append(name, rhs.name)
                .append(annotations, rhs.annotations).append(isPrivate, rhs.isPrivate)
                .append(showAsVariationsOnly, rhs.showAsVariationsOnly).append(isHidden, rhs.isHidden).isEquals();
    }

}

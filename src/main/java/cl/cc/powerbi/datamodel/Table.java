
package cl.cc.powerbi.datamodel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "name", "columns", "partitions", "annotations", "isHidden", "isPrivate", "hierarchies",
        "showAsVariationsOnly", "measures", "excludeFromModelRefresh" })
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
    @JsonProperty("excludeFromModelRefresh")
    private Boolean excludeFromModelRefresh;
    private final static long serialVersionUID = 7964146338808055436L;

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

    @JsonProperty("excludeFromModelRefresh")
    public Boolean getExcludeFromModelRefresh() {
        return excludeFromModelRefresh;
    }

    @JsonProperty("excludeFromModelRefresh")
    public void setExcludeFromModelRefresh(Boolean excludeFromModelRefresh) {
        this.excludeFromModelRefresh = excludeFromModelRefresh;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Table.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)))
                .append('[');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null) ? "<null>" : this.name));
        sb.append(',');
        sb.append("columns");
        sb.append('=');
        sb.append(((this.columns == null) ? "<null>" : this.columns));
        sb.append(',');
        sb.append("partitions");
        sb.append('=');
        sb.append(((this.partitions == null) ? "<null>" : this.partitions));
        sb.append(',');
        sb.append("annotations");
        sb.append('=');
        sb.append(((this.annotations == null) ? "<null>" : this.annotations));
        sb.append(',');
        sb.append("isHidden");
        sb.append('=');
        sb.append(((this.isHidden == null) ? "<null>" : this.isHidden));
        sb.append(',');
        sb.append("isPrivate");
        sb.append('=');
        sb.append(((this.isPrivate == null) ? "<null>" : this.isPrivate));
        sb.append(',');
        sb.append("hierarchies");
        sb.append('=');
        sb.append(((this.hierarchies == null) ? "<null>" : this.hierarchies));
        sb.append(',');
        sb.append("showAsVariationsOnly");
        sb.append('=');
        sb.append(((this.showAsVariationsOnly == null) ? "<null>" : this.showAsVariationsOnly));
        sb.append(',');
        sb.append("measures");
        sb.append('=');
        sb.append(((this.measures == null) ? "<null>" : this.measures));
        sb.append(',');
        sb.append("excludeFromModelRefresh");
        sb.append('=');
        sb.append(((this.excludeFromModelRefresh == null) ? "<null>" : this.excludeFromModelRefresh));
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
        result = ((result * 31) + ((this.partitions == null) ? 0 : this.partitions.hashCode()));
        result = ((result * 31) + ((this.measures == null) ? 0 : this.measures.hashCode()));
        result = ((result * 31) + ((this.hierarchies == null) ? 0 : this.hierarchies.hashCode()));
        result = ((result * 31) + ((this.columns == null) ? 0 : this.columns.hashCode()));
        result = ((result * 31) + ((this.name == null) ? 0 : this.name.hashCode()));
        result = ((result * 31) + ((this.annotations == null) ? 0 : this.annotations.hashCode()));
        result = ((result * 31)
                + ((this.excludeFromModelRefresh == null) ? 0 : this.excludeFromModelRefresh.hashCode()));
        result = ((result * 31) + ((this.isPrivate == null) ? 0 : this.isPrivate.hashCode()));
        result = ((result * 31) + ((this.showAsVariationsOnly == null) ? 0 : this.showAsVariationsOnly.hashCode()));
        result = ((result * 31) + ((this.isHidden == null) ? 0 : this.isHidden.hashCode()));
        return result;
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
        return (((((((((((this.partitions == rhs.partitions)
                || ((this.partitions != null) && this.partitions.equals(rhs.partitions)))
                && ((this.measures == rhs.measures) || ((this.measures != null) && this.measures.equals(rhs.measures))))
                && ((this.hierarchies == rhs.hierarchies)
                        || ((this.hierarchies != null) && this.hierarchies.equals(rhs.hierarchies))))
                && ((this.columns == rhs.columns) || ((this.columns != null) && this.columns.equals(rhs.columns))))
                && ((this.name == rhs.name) || ((this.name != null) && this.name.equals(rhs.name))))
                && ((this.annotations == rhs.annotations)
                        || ((this.annotations != null) && this.annotations.equals(rhs.annotations))))
                && ((this.excludeFromModelRefresh == rhs.excludeFromModelRefresh)
                        || ((this.excludeFromModelRefresh != null)
                                && this.excludeFromModelRefresh.equals(rhs.excludeFromModelRefresh))))
                && ((this.isPrivate == rhs.isPrivate)
                        || ((this.isPrivate != null) && this.isPrivate.equals(rhs.isPrivate))))
                && ((this.showAsVariationsOnly == rhs.showAsVariationsOnly) || ((this.showAsVariationsOnly != null)
                        && this.showAsVariationsOnly.equals(rhs.showAsVariationsOnly))))
                && ((this.isHidden == rhs.isHidden)
                        || ((this.isHidden != null) && this.isHidden.equals(rhs.isHidden))));
    }

}

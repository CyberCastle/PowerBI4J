
package cl.cc.powerbi.datamodel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "name", "dataType", "sourceColumn", "summarizeBy", "annotations", "type", "isNameInferred",
        "isDataTypeInferred", "isHidden", "dataCategory", "expression", "sortByColumn", "formatString", "variations" })
public class Column implements Serializable {

    @JsonProperty("name")
    private String name;
    @JsonProperty("dataType")
    private String dataType;
    @JsonProperty("sourceColumn")
    private String sourceColumn;
    @JsonProperty("summarizeBy")
    private String summarizeBy;
    @JsonProperty("annotations")
    private List<Annotation> annotations = new ArrayList<Annotation>();
    @JsonProperty("type")
    private String type;
    @JsonProperty("isNameInferred")
    private Boolean isNameInferred;
    @JsonProperty("isDataTypeInferred")
    private Boolean isDataTypeInferred;
    @JsonProperty("isHidden")
    private Boolean isHidden;
    @JsonProperty("dataCategory")
    private String dataCategory;
    @JsonProperty("expression")
    private String expression;
    @JsonProperty("sortByColumn")
    private String sortByColumn;
    @JsonProperty("formatString")
    private String formatString;
    @JsonProperty("variations")
    private List<Variation> variations = new ArrayList<Variation>();
    private final static long serialVersionUID = 2862615911768392886L;

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("dataType")
    public String getDataType() {
        return dataType;
    }

    @JsonProperty("dataType")
    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    @JsonProperty("sourceColumn")
    public String getSourceColumn() {
        return sourceColumn;
    }

    @JsonProperty("sourceColumn")
    public void setSourceColumn(String sourceColumn) {
        this.sourceColumn = sourceColumn;
    }

    @JsonProperty("summarizeBy")
    public String getSummarizeBy() {
        return summarizeBy;
    }

    @JsonProperty("summarizeBy")
    public void setSummarizeBy(String summarizeBy) {
        this.summarizeBy = summarizeBy;
    }

    @JsonProperty("annotations")
    public List<Annotation> getAnnotations() {
        return annotations;
    }

    @JsonProperty("annotations")
    public void setAnnotations(List<Annotation> annotations) {
        this.annotations = annotations;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("isNameInferred")
    public Boolean getIsNameInferred() {
        return isNameInferred;
    }

    @JsonProperty("isNameInferred")
    public void setIsNameInferred(Boolean isNameInferred) {
        this.isNameInferred = isNameInferred;
    }

    @JsonProperty("isDataTypeInferred")
    public Boolean getIsDataTypeInferred() {
        return isDataTypeInferred;
    }

    @JsonProperty("isDataTypeInferred")
    public void setIsDataTypeInferred(Boolean isDataTypeInferred) {
        this.isDataTypeInferred = isDataTypeInferred;
    }

    @JsonProperty("isHidden")
    public Boolean getIsHidden() {
        return isHidden;
    }

    @JsonProperty("isHidden")
    public void setIsHidden(Boolean isHidden) {
        this.isHidden = isHidden;
    }

    @JsonProperty("dataCategory")
    public String getDataCategory() {
        return dataCategory;
    }

    @JsonProperty("dataCategory")
    public void setDataCategory(String dataCategory) {
        this.dataCategory = dataCategory;
    }

    @JsonProperty("expression")
    public String getExpression() {
        return expression;
    }

    @JsonProperty("expression")
    public void setExpression(String expression) {
        this.expression = expression;
    }

    @JsonProperty("sortByColumn")
    public String getSortByColumn() {
        return sortByColumn;
    }

    @JsonProperty("sortByColumn")
    public void setSortByColumn(String sortByColumn) {
        this.sortByColumn = sortByColumn;
    }

    @JsonProperty("formatString")
    public String getFormatString() {
        return formatString;
    }

    @JsonProperty("formatString")
    public void setFormatString(String formatString) {
        this.formatString = formatString;
    }

    @JsonProperty("variations")
    public List<Variation> getVariations() {
        return variations;
    }

    @JsonProperty("variations")
    public void setVariations(List<Variation> variations) {
        this.variations = variations;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Column.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)))
                .append('[');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null) ? "<null>" : this.name));
        sb.append(',');
        sb.append("dataType");
        sb.append('=');
        sb.append(((this.dataType == null) ? "<null>" : this.dataType));
        sb.append(',');
        sb.append("sourceColumn");
        sb.append('=');
        sb.append(((this.sourceColumn == null) ? "<null>" : this.sourceColumn));
        sb.append(',');
        sb.append("summarizeBy");
        sb.append('=');
        sb.append(((this.summarizeBy == null) ? "<null>" : this.summarizeBy));
        sb.append(',');
        sb.append("annotations");
        sb.append('=');
        sb.append(((this.annotations == null) ? "<null>" : this.annotations));
        sb.append(',');
        sb.append("type");
        sb.append('=');
        sb.append(((this.type == null) ? "<null>" : this.type));
        sb.append(',');
        sb.append("isNameInferred");
        sb.append('=');
        sb.append(((this.isNameInferred == null) ? "<null>" : this.isNameInferred));
        sb.append(',');
        sb.append("isDataTypeInferred");
        sb.append('=');
        sb.append(((this.isDataTypeInferred == null) ? "<null>" : this.isDataTypeInferred));
        sb.append(',');
        sb.append("isHidden");
        sb.append('=');
        sb.append(((this.isHidden == null) ? "<null>" : this.isHidden));
        sb.append(',');
        sb.append("dataCategory");
        sb.append('=');
        sb.append(((this.dataCategory == null) ? "<null>" : this.dataCategory));
        sb.append(',');
        sb.append("expression");
        sb.append('=');
        sb.append(((this.expression == null) ? "<null>" : this.expression));
        sb.append(',');
        sb.append("sortByColumn");
        sb.append('=');
        sb.append(((this.sortByColumn == null) ? "<null>" : this.sortByColumn));
        sb.append(',');
        sb.append("formatString");
        sb.append('=');
        sb.append(((this.formatString == null) ? "<null>" : this.formatString));
        sb.append(',');
        sb.append("variations");
        sb.append('=');
        sb.append(((this.variations == null) ? "<null>" : this.variations));
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
        result = ((result * 31) + ((this.formatString == null) ? 0 : this.formatString.hashCode()));
        result = ((result * 31) + ((this.expression == null) ? 0 : this.expression.hashCode()));
        result = ((result * 31) + ((this.dataType == null) ? 0 : this.dataType.hashCode()));
        result = ((result * 31) + ((this.annotations == null) ? 0 : this.annotations.hashCode()));
        result = ((result * 31) + ((this.type == null) ? 0 : this.type.hashCode()));
        result = ((result * 31) + ((this.summarizeBy == null) ? 0 : this.summarizeBy.hashCode()));
        result = ((result * 31) + ((this.isNameInferred == null) ? 0 : this.isNameInferred.hashCode()));
        result = ((result * 31) + ((this.isHidden == null) ? 0 : this.isHidden.hashCode()));
        result = ((result * 31) + ((this.isDataTypeInferred == null) ? 0 : this.isDataTypeInferred.hashCode()));
        result = ((result * 31) + ((this.dataCategory == null) ? 0 : this.dataCategory.hashCode()));
        result = ((result * 31) + ((this.variations == null) ? 0 : this.variations.hashCode()));
        result = ((result * 31) + ((this.name == null) ? 0 : this.name.hashCode()));
        result = ((result * 31) + ((this.sortByColumn == null) ? 0 : this.sortByColumn.hashCode()));
        result = ((result * 31) + ((this.sourceColumn == null) ? 0 : this.sourceColumn.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Column) == false) {
            return false;
        }
        Column rhs = ((Column) other);
        return (((((((((((((((this.formatString == rhs.formatString)
                || ((this.formatString != null) && this.formatString.equals(rhs.formatString)))
                && ((this.expression == rhs.expression)
                        || ((this.expression != null) && this.expression.equals(rhs.expression))))
                && ((this.dataType == rhs.dataType) || ((this.dataType != null) && this.dataType.equals(rhs.dataType))))
                && ((this.annotations == rhs.annotations)
                        || ((this.annotations != null) && this.annotations.equals(rhs.annotations))))
                && ((this.type == rhs.type) || ((this.type != null) && this.type.equals(rhs.type))))
                && ((this.summarizeBy == rhs.summarizeBy)
                        || ((this.summarizeBy != null) && this.summarizeBy.equals(rhs.summarizeBy))))
                && ((this.isNameInferred == rhs.isNameInferred)
                        || ((this.isNameInferred != null) && this.isNameInferred.equals(rhs.isNameInferred))))
                && ((this.isHidden == rhs.isHidden) || ((this.isHidden != null) && this.isHidden.equals(rhs.isHidden))))
                && ((this.isDataTypeInferred == rhs.isDataTypeInferred) || ((this.isDataTypeInferred != null)
                        && this.isDataTypeInferred.equals(rhs.isDataTypeInferred))))
                && ((this.dataCategory == rhs.dataCategory)
                        || ((this.dataCategory != null) && this.dataCategory.equals(rhs.dataCategory))))
                && ((this.variations == rhs.variations)
                        || ((this.variations != null) && this.variations.equals(rhs.variations))))
                && ((this.name == rhs.name) || ((this.name != null) && this.name.equals(rhs.name))))
                && ((this.sortByColumn == rhs.sortByColumn)
                        || ((this.sortByColumn != null) && this.sortByColumn.equals(rhs.sortByColumn))))
                && ((this.sourceColumn == rhs.sourceColumn)
                        || ((this.sourceColumn != null) && this.sourceColumn.equals(rhs.sourceColumn))));
    }

}

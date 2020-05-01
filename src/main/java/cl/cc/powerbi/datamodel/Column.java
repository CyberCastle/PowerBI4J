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
@JsonPropertyOrder({ "name", "dataType", "sourceColumn", "formatString", "summarizeBy", "annotations", "type",
        "isNameInferred", "isDataTypeInferred", "isHidden", "dataCategory", "expression", "sortByColumn",
        "variations" })
public class Column implements Serializable {

    @JsonProperty("name")
    private String name;
    @JsonProperty("dataType")
    private String dataType;
    @JsonProperty("sourceColumn")
    private String sourceColumn;
    @JsonProperty("formatString")
    private String formatString;
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

    @JsonProperty("formatString")
    public String getFormatString() {
        return formatString;
    }

    @JsonProperty("formatString")
    public void setFormatString(String formatString) {
        this.formatString = formatString;
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
        return new ToStringBuilder(this).append("name", name).append("dataType", dataType)
                .append("sourceColumn", sourceColumn).append("formatString", formatString)
                .append("summarizeBy", summarizeBy).append("annotations", annotations).append("type", type)
                .append("isNameInferred", isNameInferred).append("isDataTypeInferred", isDataTypeInferred)
                .append("isHidden", isHidden).append("dataCategory", dataCategory).append("expression", expression)
                .append("sortByColumn", sortByColumn).append("variations", variations).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(formatString).append(expression).append(dataType).append(annotations)
                .append(type).append(summarizeBy).append(isNameInferred).append(isHidden).append(isDataTypeInferred)
                .append(dataCategory).append(variations).append(name).append(sortByColumn).append(sourceColumn)
                .toHashCode();
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
        return new EqualsBuilder().append(formatString, rhs.formatString).append(expression, rhs.expression)
                .append(dataType, rhs.dataType).append(annotations, rhs.annotations).append(type, rhs.type)
                .append(summarizeBy, rhs.summarizeBy).append(isNameInferred, rhs.isNameInferred)
                .append(isHidden, rhs.isHidden).append(isDataTypeInferred, rhs.isDataTypeInferred)
                .append(dataCategory, rhs.dataCategory).append(variations, rhs.variations).append(name, rhs.name)
                .append(sortByColumn, rhs.sortByColumn).append(sourceColumn, rhs.sourceColumn).isEquals();
    }

}

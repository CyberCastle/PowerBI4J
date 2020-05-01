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
@JsonPropertyOrder({ "name", "expression", "extendedProperties", "annotations", "formatString" })
public class Measure implements Serializable {

    @JsonProperty("name")
    private String name;
    @JsonProperty("expression")
    private List<String> expression = new ArrayList<String>();
    @JsonProperty("extendedProperties")
    private List<ExtendedProperty> extendedProperties = new ArrayList<ExtendedProperty>();
    @JsonProperty("annotations")
    private List<Annotation> annotations = new ArrayList<Annotation>();
    @JsonProperty("formatString")
    private String formatString;
    private final static long serialVersionUID = -1724761679251003307L;

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("expression")
    public List<String> getExpression() {
        return expression;
    }

    @JsonProperty("expression")
    public void setExpression(List<String> expression) {
        this.expression = expression;
    }

    @JsonProperty("extendedProperties")
    public List<ExtendedProperty> getExtendedProperties() {
        return extendedProperties;
    }

    @JsonProperty("extendedProperties")
    public void setExtendedProperties(List<ExtendedProperty> extendedProperties) {
        this.extendedProperties = extendedProperties;
    }

    @JsonProperty("annotations")
    public List<Annotation> getAnnotations() {
        return annotations;
    }

    @JsonProperty("annotations")
    public void setAnnotations(List<Annotation> annotations) {
        this.annotations = annotations;
    }

    @JsonProperty("formatString")
    public String getFormatString() {
        return formatString;
    }

    @JsonProperty("formatString")
    public void setFormatString(String formatString) {
        this.formatString = formatString;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("name", name).append("expression", expression)
                .append("extendedProperties", extendedProperties).append("annotations", annotations)
                .append("formatString", formatString).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(name).append(formatString).append(annotations).append(extendedProperties)
                .append(expression).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Measure) == false) {
            return false;
        }
        Measure rhs = ((Measure) other);
        return new EqualsBuilder().append(name, rhs.name).append(formatString, rhs.formatString)
                .append(annotations, rhs.annotations).append(extendedProperties, rhs.extendedProperties)
                .append(expression, rhs.expression).isEquals();
    }

}

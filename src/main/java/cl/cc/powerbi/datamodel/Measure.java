
package cl.cc.powerbi.datamodel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
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
    private final static long serialVersionUID = 7862524654710248422L;

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
        StringBuilder sb = new StringBuilder();
        sb.append(Measure.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)))
                .append('[');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null) ? "<null>" : this.name));
        sb.append(',');
        sb.append("expression");
        sb.append('=');
        sb.append(((this.expression == null) ? "<null>" : this.expression));
        sb.append(',');
        sb.append("extendedProperties");
        sb.append('=');
        sb.append(((this.extendedProperties == null) ? "<null>" : this.extendedProperties));
        sb.append(',');
        sb.append("annotations");
        sb.append('=');
        sb.append(((this.annotations == null) ? "<null>" : this.annotations));
        sb.append(',');
        sb.append("formatString");
        sb.append('=');
        sb.append(((this.formatString == null) ? "<null>" : this.formatString));
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
        result = ((result * 31) + ((this.formatString == null) ? 0 : this.formatString.hashCode()));
        result = ((result * 31) + ((this.annotations == null) ? 0 : this.annotations.hashCode()));
        result = ((result * 31) + ((this.extendedProperties == null) ? 0 : this.extendedProperties.hashCode()));
        result = ((result * 31) + ((this.expression == null) ? 0 : this.expression.hashCode()));
        return result;
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
        return ((((((this.name == rhs.name) || ((this.name != null) && this.name.equals(rhs.name)))
                && ((this.formatString == rhs.formatString)
                        || ((this.formatString != null) && this.formatString.equals(rhs.formatString))))
                && ((this.annotations == rhs.annotations)
                        || ((this.annotations != null) && this.annotations.equals(rhs.annotations))))
                && ((this.extendedProperties == rhs.extendedProperties) || ((this.extendedProperties != null)
                        && this.extendedProperties.equals(rhs.extendedProperties))))
                && ((this.expression == rhs.expression)
                        || ((this.expression != null) && this.expression.equals(rhs.expression))));
    }

}

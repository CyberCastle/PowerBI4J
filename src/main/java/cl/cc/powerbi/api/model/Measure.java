package cl.cc.powerbi.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * A measure in a table
 *
 * @author CyberCastle
 */
public class Measure {

    @JsonProperty("name")
    private String name = null;

    @JsonProperty("expression")
    private String expression = null;

    @JsonProperty("formatString")
    private String formatString = null;

    @JsonProperty("isHidden")
    private Boolean isHidden = null;

    public Measure() {

    }

    public Measure(String name, String expression) {
        this.name = name;
        this.expression = expression;
    }

    /**
     * User defined name of the measure.
     *
     * @return name
     *
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * A valid DAX expression.
     *
     * @return expression
     *
     */
    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    /**
     * A string describing how the value should be formatted when it is
     * displayed.
     *
     * @return formatString
     *
     */
    public String getFormatString() {
        return formatString;
    }

    public void setFormatString(String formatString) {
        this.formatString = formatString;
    }

    /**
     * If true, table will be hidden from client tools.
     *
     * @return isHidden
     *
     */
    public Boolean getIsHidden() {
        return isHidden;
    }

    public void setIsHidden(Boolean isHidden) {
        this.isHidden = isHidden;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Measure measure = (Measure) o;
        return Objects.equals(this.name, measure.name)
                && Objects.equals(this.expression, measure.expression)
                && Objects.equals(this.formatString, measure.formatString)
                && Objects.equals(this.isHidden, measure.isHidden);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, expression, formatString, isHidden);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Relationship {\n");

        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    expression: ").append(toIndentedString(expression)).append("\n");
        sb.append("    formatString: ").append(toIndentedString(formatString)).append("\n");
        sb.append("    isHidden: ").append(toIndentedString(isHidden)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}

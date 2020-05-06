
package cl.cc.powerbi.pbix.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "type", "expression" })
public class Source implements Serializable {

    @JsonProperty("type")
    private String type;
    @JsonProperty("expression")
    private String expression;
    private final static long serialVersionUID = -304310875974551088L;

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("expression")
    public String getExpression() {
        return expression;
    }

    @JsonProperty("expression")
    public void setExpression(String expression) {
        this.expression = expression;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Source.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)))
                .append('[');
        sb.append("type");
        sb.append('=');
        sb.append(((this.type == null) ? "<null>" : this.type));
        sb.append(',');
        sb.append("expression");
        sb.append('=');
        sb.append(((this.expression == null) ? "<null>" : this.expression));
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
        result = ((result * 31) + ((this.type == null) ? 0 : this.type.hashCode()));
        result = ((result * 31) + ((this.expression == null) ? 0 : this.expression.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Source) == false) {
            return false;
        }
        Source rhs = ((Source) other);
        return (((this.type == rhs.type) || ((this.type != null) && this.type.equals(rhs.type)))
                && ((this.expression == rhs.expression)
                        || ((this.expression != null) && this.expression.equals(rhs.expression))));
    }

}

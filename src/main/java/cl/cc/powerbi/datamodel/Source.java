package cl.cc.powerbi.datamodel;

import java.io.Serializable;
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
    "query",
    "dataSource",
    "type",
    "expression"
})
public class Source implements Serializable {

    @JsonProperty("query")
    private String query;
    @JsonProperty("dataSource")
    private String dataSource;
    @JsonProperty("type")
    private String type;
    @JsonProperty("expression")
    private String expression;
    private final static long serialVersionUID = -2468489052980052128L;

    @JsonProperty("query")
    public String getQuery() {
        return query;
    }

    @JsonProperty("query")
    public void setQuery(String query) {
        this.query = query;
    }

    @JsonProperty("dataSource")
    public String getDataSource() {
        return dataSource;
    }

    @JsonProperty("dataSource")
    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }

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
        return new ToStringBuilder(this).append("query", query).append("dataSource", dataSource).append("type", type).append("expression", expression).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(expression).append(type).append(dataSource).append(query).toHashCode();
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
        return new EqualsBuilder().append(expression, rhs.expression).append(type, rhs.type).append(dataSource, rhs.dataSource).append(query, rhs.query).isEquals();
    }

}

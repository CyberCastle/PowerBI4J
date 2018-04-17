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
    "name",
    "connectionString",
    "impersonationMode"
})
public class DataSource implements Serializable {

    @JsonProperty("name")
    private String name;
    @JsonProperty("connectionString")
    private String connectionString;
    @JsonProperty("impersonationMode")
    private String impersonationMode;
    private final static long serialVersionUID = 8218951512283970934L;

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("connectionString")
    public String getConnectionString() {
        return connectionString;
    }

    @JsonProperty("connectionString")
    public void setConnectionString(String connectionString) {
        this.connectionString = connectionString;
    }

    @JsonProperty("impersonationMode")
    public String getImpersonationMode() {
        return impersonationMode;
    }

    @JsonProperty("impersonationMode")
    public void setImpersonationMode(String impersonationMode) {
        this.impersonationMode = impersonationMode;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("name", name).append("connectionString", connectionString).append("impersonationMode", impersonationMode).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(name).append(connectionString).append(impersonationMode).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof DataSource) == false) {
            return false;
        }
        DataSource rhs = ((DataSource) other);
        return new EqualsBuilder().append(name, rhs.name).append(connectionString, rhs.connectionString).append(impersonationMode, rhs.impersonationMode).isEquals();
    }

}

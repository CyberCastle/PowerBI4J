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
@JsonPropertyOrder({ "database" })
public class Create implements Serializable {

    @JsonProperty("database")
    private Database database;
    private final static long serialVersionUID = 6992306136687069872L;

    @JsonProperty("database")
    public Database getDatabase() {
        return database;
    }

    @JsonProperty("database")
    public void setDatabase(Database database) {
        this.database = database;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("database", database).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(database).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Create) == false) {
            return false;
        }
        Create rhs = ((Create) other);
        return new EqualsBuilder().append(database, rhs.database).isEquals();
    }

}

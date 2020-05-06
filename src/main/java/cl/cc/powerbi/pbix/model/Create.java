
package cl.cc.powerbi.pbix.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
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
        StringBuilder sb = new StringBuilder();
        sb.append(Create.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)))
                .append('[');
        sb.append("database");
        sb.append('=');
        sb.append(((this.database == null) ? "<null>" : this.database));
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
        result = ((result * 31) + ((this.database == null) ? 0 : this.database.hashCode()));
        return result;
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
        return ((this.database == rhs.database) || ((this.database != null) && this.database.equals(rhs.database)));
    }

}

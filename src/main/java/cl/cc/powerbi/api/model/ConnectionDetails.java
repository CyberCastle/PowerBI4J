package cl.cc.powerbi.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Connection String wrapper.
 *
 * @author CyberCastle
 */
public class ConnectionDetails {

    @JsonProperty("connectionString")
    private String connectionString = null;

    public ConnectionDetails connectionString(String connectionString) {
        this.connectionString = connectionString;
        return this;
    }

    /**
     * A dataset connection string.
     *
     * @return connectionString
     *
     */
    public String getConnectionString() {
        return connectionString;
    }

    public void setConnectionString(String connectionString) {
        this.connectionString = connectionString;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ConnectionDetails connectionDetails = (ConnectionDetails) o;
        return Objects.equals(this.connectionString, connectionDetails.connectionString);
    }

    @Override
    public int hashCode() {
        return Objects.hash(connectionString);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ConnectionDetails {\n");

        sb.append("    connectionString: ").append(toIndentedString(connectionString)).append("\n");
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

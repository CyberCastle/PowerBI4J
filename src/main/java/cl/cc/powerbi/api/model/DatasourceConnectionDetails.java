package cl.cc.powerbi.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * A Power BI datasource connection details
 *
 * @author CyberCastle
 */
public class DatasourceConnectionDetails {

    @JsonProperty("server")
    private String server;

    @JsonProperty("database")
    private String database;

    @JsonProperty("url")
    private String url;

    public DatasourceConnectionDetails server(String server) {
        this.server = server;
        return this;
    }

    /**
     * The connection server
     *
     * @return server
     *
     */
    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public DatasourceConnectionDetails database(String database) {
        this.database = database;
        return this;
    }

    /**
     * The connection database
     *
     * @return database
     *
     */
    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public DatasourceConnectionDetails url(String url) {
        this.url = url;
        return this;
    }

    /**
     * The connection url
     *
     * @return url
     *
     */
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DatasourceConnectionDetails datasourceConnectionDetails = (DatasourceConnectionDetails) o;
        return Objects.equals(this.server, datasourceConnectionDetails.server)
                && Objects.equals(this.database, datasourceConnectionDetails.database)
                && Objects.equals(this.url, datasourceConnectionDetails.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(server, database, url);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DatasourceConnectionDetails {\n");

        sb.append("    server: ").append(toIndentedString(server)).append("\n");
        sb.append("    database: ").append(toIndentedString(database)).append("\n");
        sb.append("    url: ").append(toIndentedString(url)).append("\n");
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

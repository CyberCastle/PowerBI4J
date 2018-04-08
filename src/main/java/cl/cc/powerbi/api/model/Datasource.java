package cl.cc.powerbi.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * A Power BI datasource
 *
 * @author CyberCastle
 */
public class Datasource {

    @JsonProperty("name")
    private String name = null;

    @JsonProperty("connectionString")
    private String connectionString = null;

    @JsonProperty("datasourceType")
    private String datasourceType = null;

    @JsonProperty("connectionDetails")
    private DatasourceConnectionDetails connectionDetails = null;

    @JsonProperty("gatewayId")
    private String gatewayId = null;

    @JsonProperty("datasourceId")
    private String datasourceId = null;

    public Datasource name(String name) {
        this.name = name;
        return this;
    }

    /**
     * The datasource name
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

    public Datasource connectionString(String connectionString) {
        this.connectionString = connectionString;
        return this;
    }

    /**
     * The datasource connection string
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

    public Datasource datasourceType(String datasourceType) {
        this.datasourceType = datasourceType;
        return this;
    }

    /**
     * The datasource type
     *
     * @return datasourceType
     *
     */
    public String getDatasourceType() {
        return datasourceType;
    }

    public void setDatasourceType(String datasourceType) {
        this.datasourceType = datasourceType;
    }

    public Datasource connectionDetails(DatasourceConnectionDetails connectionDetails) {
        this.connectionDetails = connectionDetails;
        return this;
    }

    /**
     * The datasource connection details
     *
     * @return connectionDetails
     *
     */
    public DatasourceConnectionDetails getConnectionDetails() {
        return connectionDetails;
    }

    public void setConnectionDetails(DatasourceConnectionDetails connectionDetails) {
        this.connectionDetails = connectionDetails;
    }

    public Datasource gatewayId(String gatewayId) {
        this.gatewayId = gatewayId;
        return this;
    }

    /**
     * The bound gateway id
     *
     * @return gatewayId
     *
     */
    public String getGatewayId() {
        return gatewayId;
    }

    public void setGatewayId(String gatewayId) {
        this.gatewayId = gatewayId;
    }

    public Datasource datasourceId(String datasourceId) {
        this.datasourceId = datasourceId;
        return this;
    }

    /**
     * The bound datasource id
     *
     * @return datasourceId
     *
     */
    public String getDatasourceId() {
        return datasourceId;
    }

    public void setDatasourceId(String datasourceId) {
        this.datasourceId = datasourceId;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Datasource datasource = (Datasource) o;
        return Objects.equals(this.name, datasource.name)
                && Objects.equals(this.connectionString, datasource.connectionString)
                && Objects.equals(this.datasourceType, datasource.datasourceType)
                && Objects.equals(this.connectionDetails, datasource.connectionDetails)
                && Objects.equals(this.gatewayId, datasource.gatewayId)
                && Objects.equals(this.datasourceId, datasource.datasourceId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, connectionString, datasourceType, connectionDetails, gatewayId, datasourceId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Datasource {\n");

        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    connectionString: ").append(toIndentedString(connectionString)).append("\n");
        sb.append("    datasourceType: ").append(toIndentedString(datasourceType)).append("\n");
        sb.append("    connectionDetails: ").append(toIndentedString(connectionDetails)).append("\n");
        sb.append("    gatewayId: ").append(toIndentedString(gatewayId)).append("\n");
        sb.append("    datasourceId: ").append(toIndentedString(datasourceId)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

}

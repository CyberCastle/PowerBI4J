package cl.cc.powerbi.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * A Power BI gateway datasource
 *
 * @author CyberCastle
 */
public class GatewayDatasource {

    @JsonProperty("id")
    private String id = null;

    @JsonProperty("gatewayId")
    private String gatewayId = null;

    @JsonProperty("datasourceName")
    private String datasourceName = null;

    @JsonProperty("datasourceType")
    private String datasourceType = null;

    @JsonProperty("connectionDetails")
    private String connectionDetails = null;

    @JsonProperty("credentialType")
    private String credentialType = null;

    @JsonProperty("basicCredentials")
    private BasicCredentials basicCredentials = null;

    public GatewayDatasource id(String id) {
        this.id = id;
        return this;
    }

    /**
     * The unique id for this gateway datasource
     *
     * @return id
     *
     */
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public GatewayDatasource gatewayId(String gatewayId) {
        this.gatewayId = gatewayId;
        return this;
    }

    /**
     * The associated gateway id
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

    public GatewayDatasource datasourceName(String datasourceName) {
        this.datasourceName = datasourceName;
        return this;
    }

    /**
     * The datasource name
     *
     * @return datasourceName
     *
     */
    public String getDatasourceName() {
        return datasourceName;
    }

    public void setDatasourceName(String datasourceName) {
        this.datasourceName = datasourceName;
    }

    public GatewayDatasource datasourceType(String datasourceType) {
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

    public GatewayDatasource connectionDetails(String connectionDetails) {
        this.connectionDetails = connectionDetails;
        return this;
    }

    /**
     * The datasource connection details
     *
     * @return connectionDetails
     *
     */
    public String getConnectionDetails() {
        return connectionDetails;
    }

    public void setConnectionDetails(String connectionDetails) {
        this.connectionDetails = connectionDetails;
    }

    public GatewayDatasource credentialType(String credentialType) {
        this.credentialType = credentialType;
        return this;
    }

    /**
     * The datasource credential type
     *
     * @return credentialType
     *
     */
    public String getCredentialType() {
        return credentialType;
    }

    public void setCredentialType(String credentialType) {
        this.credentialType = credentialType;
    }

    public GatewayDatasource basicCredentials(BasicCredentials basicCredentials) {
        this.basicCredentials = basicCredentials;
        return this;
    }

    /**
     * The datasource basic credential
     *
     * @return basicCredentials
     *
     */
    public BasicCredentials getBasicCredentials() {
        return basicCredentials;
    }

    public void setBasicCredentials(BasicCredentials basicCredentials) {
        this.basicCredentials = basicCredentials;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GatewayDatasource gatewayDatasource = (GatewayDatasource) o;
        return Objects.equals(this.id, gatewayDatasource.id)
                && Objects.equals(this.gatewayId, gatewayDatasource.gatewayId)
                && Objects.equals(this.datasourceName, gatewayDatasource.datasourceName)
                && Objects.equals(this.datasourceType, gatewayDatasource.datasourceType)
                && Objects.equals(this.connectionDetails, gatewayDatasource.connectionDetails)
                && Objects.equals(this.credentialType, gatewayDatasource.credentialType)
                && Objects.equals(this.basicCredentials, gatewayDatasource.basicCredentials);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, gatewayId, datasourceName, datasourceType, connectionDetails, credentialType, basicCredentials);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class GatewayDatasource {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    gatewayId: ").append(toIndentedString(gatewayId)).append("\n");
        sb.append("    datasourceName: ").append(toIndentedString(datasourceName)).append("\n");
        sb.append("    datasourceType: ").append(toIndentedString(datasourceType)).append("\n");
        sb.append("    connectionDetails: ").append(toIndentedString(connectionDetails)).append("\n");
        sb.append("    credentialType: ").append(toIndentedString(credentialType)).append("\n");
        sb.append("    basicCredentials: ").append(toIndentedString(basicCredentials)).append("\n");
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

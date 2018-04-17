package cl.cc.powerbi.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * An Update Datasource Connection Request
 *
 * @author CyberCastle
 */
public class UpdateDatasourceConnectionRequest {

    @JsonProperty("connectionDetails")
    private DatasourceConnectionDetails connectionDetails;

    @JsonProperty("datasourceSelector")
    private Datasource datasourceSelector;

    public UpdateDatasourceConnectionRequest connectionDetails(DatasourceConnectionDetails connectionDetails) {
        this.connectionDetails = connectionDetails;
        return this;
    }

    /**
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

    public UpdateDatasourceConnectionRequest datasourceSelector(Datasource datasourceSelector) {
        this.datasourceSelector = datasourceSelector;
        return this;
    }

    /**
     *
     * @return datasourceSelector
     *
     */
    public Datasource getDatasourceSelector() {
        return datasourceSelector;
    }

    public void setDatasourceSelector(Datasource datasourceSelector) {
        this.datasourceSelector = datasourceSelector;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UpdateDatasourceConnectionRequest updateDatasourceConnectionRequest = (UpdateDatasourceConnectionRequest) o;
        return Objects.equals(this.connectionDetails, updateDatasourceConnectionRequest.connectionDetails)
                && Objects.equals(this.datasourceSelector, updateDatasourceConnectionRequest.datasourceSelector);
    }

    @Override
    public int hashCode() {
        return Objects.hash(connectionDetails, datasourceSelector);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class UpdateDatasourceConnectionRequest {\n");

        sb.append("    connectionDetails: ").append(toIndentedString(connectionDetails)).append("\n");
        sb.append("    datasourceSelector: ").append(toIndentedString(datasourceSelector)).append("\n");
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

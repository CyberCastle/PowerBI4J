package cl.cc.powerbi.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * An Update Datasource To Gateway Request
 *
 * @author CyberCastle
 */
public class UpdateDatasourceRequest {

    @JsonProperty("credentialDetails")
    private CredentialDetails credentialDetails = null;

    public UpdateDatasourceRequest credentialDetails(CredentialDetails credentialDetails) {
        this.credentialDetails = credentialDetails;
        return this;
    }

    /**
     * Get credentialDetails
     *
     * @return credentialDetails
     *
     */
    public CredentialDetails getCredentialDetails() {
        return credentialDetails;
    }

    public void setCredentialDetails(CredentialDetails credentialDetails) {
        this.credentialDetails = credentialDetails;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UpdateDatasourceRequest updateDatasourceRequest = (UpdateDatasourceRequest) o;
        return Objects.equals(this.credentialDetails, updateDatasourceRequest.credentialDetails);
    }

    @Override
    public int hashCode() {
        return Objects.hash(credentialDetails);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class UpdateDatasourceRequest {\n");

        sb.append("    credentialDetails: ").append(toIndentedString(credentialDetails)).append("\n");
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

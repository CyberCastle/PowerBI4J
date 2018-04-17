package cl.cc.powerbi.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;

/**
 * An Update Datasource Request
 *
 * @author CyberCastle
 */
public class UpdateDatasourcesRequest {

    @JsonProperty("updateDetails")
    private List<UpdateDatasourceConnectionRequest> updateDetails;

    public UpdateDatasourcesRequest updateDetails(List<UpdateDatasourceConnectionRequest> updateDetails) {
        this.updateDetails = updateDetails;
        return this;
    }

    public UpdateDatasourcesRequest addUpdateDetailsItem(UpdateDatasourceConnectionRequest updateDetailsItem) {
        if (this.updateDetails == null) {
            this.updateDetails = new ArrayList<>();
        }
        this.updateDetails.add(updateDetailsItem);
        return this;
    }

    /**
     * The connection server
     *
     * @return updateDetails
     *
     */
    public List<UpdateDatasourceConnectionRequest> getUpdateDetails() {
        return updateDetails;
    }

    public void setUpdateDetails(List<UpdateDatasourceConnectionRequest> updateDetails) {
        this.updateDetails = updateDetails;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UpdateDatasourcesRequest updateDatasourcesRequest = (UpdateDatasourcesRequest) o;
        return Objects.equals(this.updateDetails, updateDatasourcesRequest.updateDetails);
    }

    @Override
    public int hashCode() {
        return Objects.hash(updateDetails);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class UpdateDatasourcesRequest {\n");

        sb.append("    updateDetails: ").append(toIndentedString(updateDetails)).append("\n");
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

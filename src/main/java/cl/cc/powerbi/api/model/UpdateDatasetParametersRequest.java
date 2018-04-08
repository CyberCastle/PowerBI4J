package cl.cc.powerbi.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;

/**
 * Power BI dataset parameter update request
 *
 * @author CyberCastle
 */
public class UpdateDatasetParametersRequest {

    @JsonProperty("updateDetails")
    private List<UpdateDatasetParameterDetails> updateDetails = new ArrayList<UpdateDatasetParameterDetails>();

    public UpdateDatasetParametersRequest updateDetails(List<UpdateDatasetParameterDetails> updateDetails) {
        this.updateDetails = updateDetails;
        return this;
    }

    public UpdateDatasetParametersRequest addUpdateDetailsItem(UpdateDatasetParameterDetails updateDetailsItem) {
        this.updateDetails.add(updateDetailsItem);
        return this;
    }

    /**
     * The dataset parameter list to update
     *
     * @return updateDetails
     *
     */
    public List<UpdateDatasetParameterDetails> getUpdateDetails() {
        return updateDetails;
    }

    public void setUpdateDetails(List<UpdateDatasetParameterDetails> updateDetails) {
        this.updateDetails = updateDetails;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UpdateDatasetParametersRequest updateDatasetParametersRequest = (UpdateDatasetParametersRequest) o;
        return Objects.equals(this.updateDetails, updateDatasetParametersRequest.updateDetails);
    }

    @Override
    public int hashCode() {
        return Objects.hash(updateDetails);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class UpdateDatasetParametersRequest {\n");

        sb.append("    updateDetails: ").append(toIndentedString(updateDetails)).append("\n");
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

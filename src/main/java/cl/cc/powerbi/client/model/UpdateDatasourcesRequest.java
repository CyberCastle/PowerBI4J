/*
 * Power BI Client
 * No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
 *
 * The version of the OpenAPI document: v1.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package cl.cc.powerbi.client.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 
 */
@ApiModel(description = "")
@JsonPropertyOrder({ UpdateDatasourcesRequest.JSON_PROPERTY_UPDATE_DETAILS })

public class UpdateDatasourcesRequest {
    public static final String JSON_PROPERTY_UPDATE_DETAILS = "updateDetails";
    private List<UpdateDatasourceConnectionRequest> updateDetails = new ArrayList<>();

    public UpdateDatasourcesRequest updateDetails(List<UpdateDatasourceConnectionRequest> updateDetails) {

        this.updateDetails = updateDetails;
        return this;
    }

    public UpdateDatasourcesRequest addUpdateDetailsItem(UpdateDatasourceConnectionRequest updateDetailsItem) {
        this.updateDetails.add(updateDetailsItem);
        return this;
    }

    /**
     * The connection server
     * 
     * @return updateDetails
     **/
    @ApiModelProperty(required = true, value = "The connection server")
    @JsonProperty(JSON_PROPERTY_UPDATE_DETAILS)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public List<UpdateDatasourceConnectionRequest> getUpdateDetails() {
        return updateDetails;
    }

    public void setUpdateDetails(List<UpdateDatasourceConnectionRequest> updateDetails) {
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
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

}

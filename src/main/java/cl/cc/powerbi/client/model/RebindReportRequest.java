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

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Power BI rebind report request
 */
@ApiModel(description = "Power BI rebind report request")
@JsonPropertyOrder({ RebindReportRequest.JSON_PROPERTY_DATASET_ID })

public class RebindReportRequest {
    public static final String JSON_PROPERTY_DATASET_ID = "datasetId";
    private String datasetId;

    public RebindReportRequest datasetId(String datasetId) {

        this.datasetId = datasetId;
        return this;
    }

    /**
     * The new dataset for the rebound report. If the dataset resides in a different
     * workspace than the report, a shared dataset will be created in the
     * report&#39;s workspace
     * 
     * @return datasetId
     **/
    @ApiModelProperty(required = true, value = "The new dataset for the rebound report. If the dataset resides in a different workspace than the report, a shared dataset will be created in the report's workspace")
    @JsonProperty(JSON_PROPERTY_DATASET_ID)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public String getDatasetId() {
        return datasetId;
    }

    public void setDatasetId(String datasetId) {
        this.datasetId = datasetId;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RebindReportRequest rebindReportRequest = (RebindReportRequest) o;
        return Objects.equals(this.datasetId, rebindReportRequest.datasetId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(datasetId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RebindReportRequest {\n");
        sb.append("    datasetId: ").append(toIndentedString(datasetId)).append("\n");
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
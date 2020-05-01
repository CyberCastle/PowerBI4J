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
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Power BI clone report request
 */
@ApiModel(description = "Power BI clone report request")
@JsonPropertyOrder({ CloneReportRequest.JSON_PROPERTY_NAME, CloneReportRequest.JSON_PROPERTY_TARGET_WORKSPACE_ID,
        CloneReportRequest.JSON_PROPERTY_TARGET_MODEL_ID })

public class CloneReportRequest {
    public static final String JSON_PROPERTY_NAME = "name";
    private String name;

    public static final String JSON_PROPERTY_TARGET_WORKSPACE_ID = "targetWorkspaceId";
    private UUID targetWorkspaceId;

    public static final String JSON_PROPERTY_TARGET_MODEL_ID = "targetModelId";
    private String targetModelId;

    public CloneReportRequest name(String name) {

        this.name = name;
        return this;
    }

    /**
     * The new report name
     * 
     * @return name
     **/
    @ApiModelProperty(required = true, value = "The new report name")
    @JsonProperty(JSON_PROPERTY_NAME)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CloneReportRequest targetWorkspaceId(UUID targetWorkspaceId) {

        this.targetWorkspaceId = targetWorkspaceId;
        return this;
    }

    /**
     * Optional parameter for specifying the target workspace id. Empty Guid
     * (00000000-0000-0000-0000-000000000000) indicates &#39;My Workspace&#39;.
     * &lt;br/&gt;If not provided, the new report will be cloned within the same
     * workspace as the source report.
     * 
     * @return targetWorkspaceId
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "Optional parameter for specifying the target workspace id. Empty Guid (00000000-0000-0000-0000-000000000000) indicates 'My Workspace'. <br/>If not provided, the new report will be cloned within the same workspace as the source report.")
    @JsonProperty(JSON_PROPERTY_TARGET_WORKSPACE_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public UUID getTargetWorkspaceId() {
        return targetWorkspaceId;
    }

    public void setTargetWorkspaceId(UUID targetWorkspaceId) {
        this.targetWorkspaceId = targetWorkspaceId;
    }

    public CloneReportRequest targetModelId(String targetModelId) {

        this.targetModelId = targetModelId;
        return this;
    }

    /**
     * Optional parameter for specifying the target associated dataset id.
     * &lt;br/&gt;If not provided, the new report will be associated with the same
     * dataset as the source report
     * 
     * @return targetModelId
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "Optional parameter for specifying the target associated dataset id. <br/>If not provided, the new report will be associated with the same dataset as the source report")
    @JsonProperty(JSON_PROPERTY_TARGET_MODEL_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getTargetModelId() {
        return targetModelId;
    }

    public void setTargetModelId(String targetModelId) {
        this.targetModelId = targetModelId;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CloneReportRequest cloneReportRequest = (CloneReportRequest) o;
        return Objects.equals(this.name, cloneReportRequest.name)
                && Objects.equals(this.targetWorkspaceId, cloneReportRequest.targetWorkspaceId)
                && Objects.equals(this.targetModelId, cloneReportRequest.targetModelId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, targetWorkspaceId, targetModelId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CloneReportRequest {\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    targetWorkspaceId: ").append(toIndentedString(targetWorkspaceId)).append("\n");
        sb.append("    targetModelId: ").append(toIndentedString(targetModelId)).append("\n");
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
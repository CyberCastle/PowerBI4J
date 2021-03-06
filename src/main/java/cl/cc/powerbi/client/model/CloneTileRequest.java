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

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Power BI clone tile request
 */
@ApiModel(description = "Power BI clone tile request")
@JsonPropertyOrder({ CloneTileRequest.JSON_PROPERTY_TARGET_DASHBOARD_ID,
        CloneTileRequest.JSON_PROPERTY_TARGET_WORKSPACE_ID, CloneTileRequest.JSON_PROPERTY_TARGET_REPORT_ID,
        CloneTileRequest.JSON_PROPERTY_TARGET_MODEL_ID, CloneTileRequest.JSON_PROPERTY_POSITION_CONFLICT_ACTION })

public class CloneTileRequest {
    public static final String JSON_PROPERTY_TARGET_DASHBOARD_ID = "targetDashboardId";
    private UUID targetDashboardId;

    public static final String JSON_PROPERTY_TARGET_WORKSPACE_ID = "targetWorkspaceId";
    private UUID targetWorkspaceId;

    public static final String JSON_PROPERTY_TARGET_REPORT_ID = "targetReportId";
    private UUID targetReportId;

    public static final String JSON_PROPERTY_TARGET_MODEL_ID = "targetModelId";
    private String targetModelId;

    /**
     * Optional parameter for specifying the action in case of position conflict.
     * &lt;br/&gt;If not provided, &#39;Tail&#39; is used. &lt;br/&gt;If there is no
     * conflict, clone tile to same position as in source.
     */
    public enum PositionConflictActionEnum {
        TAIL("Tail"),

        ABORT("Abort");

        private String value;

        PositionConflictActionEnum(String value) {
            this.value = value;
        }

        @JsonValue
        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        @JsonCreator
        public static PositionConflictActionEnum fromValue(String value) {
            for (PositionConflictActionEnum b : PositionConflictActionEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }

    public static final String JSON_PROPERTY_POSITION_CONFLICT_ACTION = "positionConflictAction";
    private PositionConflictActionEnum positionConflictAction;

    public CloneTileRequest targetDashboardId(UUID targetDashboardId) {

        this.targetDashboardId = targetDashboardId;
        return this;
    }

    /**
     * The target dashboard id
     * 
     * @return targetDashboardId
     **/
    @ApiModelProperty(required = true, value = "The target dashboard id")
    @JsonProperty(JSON_PROPERTY_TARGET_DASHBOARD_ID)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public UUID getTargetDashboardId() {
        return targetDashboardId;
    }

    public void setTargetDashboardId(UUID targetDashboardId) {
        this.targetDashboardId = targetDashboardId;
    }

    public CloneTileRequest targetWorkspaceId(UUID targetWorkspaceId) {

        this.targetWorkspaceId = targetWorkspaceId;
        return this;
    }

    /**
     * Optional parameter for specifying the target workspace id. Empty Guid
     * (00000000-0000-0000-0000-000000000000) indicates &#39;My Workspace&#39;.
     * &lt;br/&gt;If not provided, tile will be cloned within the same workspace as
     * the source tile.
     * 
     * @return targetWorkspaceId
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "Optional parameter for specifying the target workspace id. Empty Guid (00000000-0000-0000-0000-000000000000) indicates 'My Workspace'. <br/>If not provided, tile will be cloned within the same workspace as the source tile.")
    @JsonProperty(JSON_PROPERTY_TARGET_WORKSPACE_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public UUID getTargetWorkspaceId() {
        return targetWorkspaceId;
    }

    public void setTargetWorkspaceId(UUID targetWorkspaceId) {
        this.targetWorkspaceId = targetWorkspaceId;
    }

    public CloneTileRequest targetReportId(UUID targetReportId) {

        this.targetReportId = targetReportId;
        return this;
    }

    /**
     * Optional parameter &lt;br/&gt;When cloning a tile linked to a report, pass
     * the target report id to rebind the new tile to a different report.
     * 
     * @return targetReportId
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "Optional parameter <br/>When cloning a tile linked to a report, pass the target report id to rebind the new tile to a different report.")
    @JsonProperty(JSON_PROPERTY_TARGET_REPORT_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public UUID getTargetReportId() {
        return targetReportId;
    }

    public void setTargetReportId(UUID targetReportId) {
        this.targetReportId = targetReportId;
    }

    public CloneTileRequest targetModelId(String targetModelId) {

        this.targetModelId = targetModelId;
        return this;
    }

    /**
     * Optional parameter &lt;br/&gt;When cloning a tile linked to a dataset, pass
     * the target model id to rebind the new tile to a different dataset.
     * 
     * @return targetModelId
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "Optional parameter <br/>When cloning a tile linked to a dataset, pass the target model id to rebind the new tile to a different dataset.")
    @JsonProperty(JSON_PROPERTY_TARGET_MODEL_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getTargetModelId() {
        return targetModelId;
    }

    public void setTargetModelId(String targetModelId) {
        this.targetModelId = targetModelId;
    }

    public CloneTileRequest positionConflictAction(PositionConflictActionEnum positionConflictAction) {

        this.positionConflictAction = positionConflictAction;
        return this;
    }

    /**
     * Optional parameter for specifying the action in case of position conflict.
     * &lt;br/&gt;If not provided, &#39;Tail&#39; is used. &lt;br/&gt;If there is no
     * conflict, clone tile to same position as in source.
     * 
     * @return positionConflictAction
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "Optional parameter for specifying the action in case of position conflict. <br/>If not provided, 'Tail' is used. <br/>If there is no conflict, clone tile to same position as in source.")
    @JsonProperty(JSON_PROPERTY_POSITION_CONFLICT_ACTION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public PositionConflictActionEnum getPositionConflictAction() {
        return positionConflictAction;
    }

    public void setPositionConflictAction(PositionConflictActionEnum positionConflictAction) {
        this.positionConflictAction = positionConflictAction;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CloneTileRequest cloneTileRequest = (CloneTileRequest) o;
        return Objects.equals(this.targetDashboardId, cloneTileRequest.targetDashboardId)
                && Objects.equals(this.targetWorkspaceId, cloneTileRequest.targetWorkspaceId)
                && Objects.equals(this.targetReportId, cloneTileRequest.targetReportId)
                && Objects.equals(this.targetModelId, cloneTileRequest.targetModelId)
                && Objects.equals(this.positionConflictAction, cloneTileRequest.positionConflictAction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(targetDashboardId, targetWorkspaceId, targetReportId, targetModelId,
                positionConflictAction);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CloneTileRequest {\n");
        sb.append("    targetDashboardId: ").append(toIndentedString(targetDashboardId)).append("\n");
        sb.append("    targetWorkspaceId: ").append(toIndentedString(targetWorkspaceId)).append("\n");
        sb.append("    targetReportId: ").append(toIndentedString(targetReportId)).append("\n");
        sb.append("    targetModelId: ").append(toIndentedString(targetModelId)).append("\n");
        sb.append("    positionConflictAction: ").append(toIndentedString(positionConflictAction)).append("\n");
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

package cl.cc.powerbi.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Power BI Clone Tile Request
 *
 * @author CyberCastle
 */
public class CloneTileRequest {

    @JsonProperty("targetDashboardId")
    private String targetDashboardId;

    @JsonProperty("targetWorkspaceId")
    private String targetWorkspaceId;

    @JsonProperty("targetReportId")
    private String targetReportId;

    @JsonProperty("targetModelId")
    private String targetModelId;

    @JsonProperty("positionConflictAction")
    private String positionConflictAction;

    public CloneTileRequest targetDashboardId(String targetDashboardId) {
        this.targetDashboardId = targetDashboardId;
        return this;
    }

    /**
     * The target dashboard id
     *
     * @return targetDashboardId
     *
     */
    public String getTargetDashboardId() {
        return targetDashboardId;
    }

    public void setTargetDashboardId(String targetDashboardId) {
        this.targetDashboardId = targetDashboardId;
    }

    public CloneTileRequest targetWorkspaceId(String targetWorkspaceId) {
        this.targetWorkspaceId = targetWorkspaceId;
        return this;
    }

    /**
     * Optional parameter for specifying the target workspace id
     *
     * @return targetWorkspaceId
     *
     */
    public String getTargetWorkspaceId() {
        return targetWorkspaceId;
    }

    public void setTargetWorkspaceId(String targetWorkspaceId) {
        this.targetWorkspaceId = targetWorkspaceId;
    }

    public CloneTileRequest targetReportId(String targetReportId) {
        this.targetReportId = targetReportId;
        return this;
    }

    /**
     * Optional parameter for specifying the target report id
     *
     * @return targetReportId
     *
     */
    public String getTargetReportId() {
        return targetReportId;
    }

    public void setTargetReportId(String targetReportId) {
        this.targetReportId = targetReportId;
    }

    public CloneTileRequest targetModelId(String targetModelId) {
        this.targetModelId = targetModelId;
        return this;
    }

    /**
     * Optional parameter for specifying the target associated model (dataset)
     * id
     *
     * @return targetModelId
     *
     */
    public String getTargetModelId() {
        return targetModelId;
    }

    public void setTargetModelId(String targetModelId) {
        this.targetModelId = targetModelId;
    }

    public CloneTileRequest positionConflictAction(String positionConflictAction) {
        this.positionConflictAction = positionConflictAction;
        return this;
    }

    /**
     * Optional parameter for specifying the action in case of position conflict
     *
     * @return positionConflictAction
     *
     */
    public String getPositionConflictAction() {
        return positionConflictAction;
    }

    public void setPositionConflictAction(String positionConflictAction) {
        this.positionConflictAction = positionConflictAction;
    }

    @Override
    public boolean equals(Object o) {
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
        return Objects.hash(targetDashboardId, targetWorkspaceId, targetReportId, targetModelId, positionConflictAction);
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
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

}

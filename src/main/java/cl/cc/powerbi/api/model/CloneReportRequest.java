package cl.cc.powerbi.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Power BI Clone Report Request
 *
 * @author CyberCastle
 */
public class CloneReportRequest {

    @JsonProperty("name")
    private String name = null;

    @JsonProperty("targetWorkspaceId")
    private String targetWorkspaceId = null;

    @JsonProperty("targetModelId")
    private String targetModelId = null;

    public CloneReportRequest name(String name) {
        this.name = name;
        return this;
    }

    /**
     * The requested report name
     *
     * @return name
     *
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CloneReportRequest targetWorkspaceId(String targetWorkspaceId) {
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

    public CloneReportRequest targetModelId(String targetModelId) {
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

    @Override
    public boolean equals(Object o) {
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
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

}

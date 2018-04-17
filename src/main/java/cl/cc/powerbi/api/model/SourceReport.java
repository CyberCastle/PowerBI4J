package cl.cc.powerbi.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Source from existing report
 *
 * @author CyberCastle
 */
public class SourceReport {

    @JsonProperty("sourceReportId")
    private String sourceReportId;

    @JsonProperty("sourceWorkspaceId")
    private String sourceWorkspaceId;

    public SourceReport sourceReportId(String sourceReportId) {
        this.sourceReportId = sourceReportId;
        return this;
    }

    /**
     * source report id
     *
     * @return sourceReportId
     *
     */
    public String getSourceReportId() {
        return sourceReportId;
    }

    public void setSourceReportId(String sourceReportId) {
        this.sourceReportId = sourceReportId;
    }

    public SourceReport sourceWorkspaceId(String sourceWorkspaceId) {
        this.sourceWorkspaceId = sourceWorkspaceId;
        return this;
    }

    /**
     * source worksapce id
     *
     * @return sourceWorkspaceId
     *
     */
    public String getSourceWorkspaceId() {
        return sourceWorkspaceId;
    }

    public void setSourceWorkspaceId(String sourceWorkspaceId) {
        this.sourceWorkspaceId = sourceWorkspaceId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SourceReport sourceReport = (SourceReport) o;
        return Objects.equals(this.sourceReportId, sourceReport.sourceReportId)
                && Objects.equals(this.sourceWorkspaceId, sourceReport.sourceWorkspaceId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sourceReportId, sourceWorkspaceId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class SourceReport {\n");

        sb.append("    sourceReportId: ").append(toIndentedString(sourceReportId)).append("\n");
        sb.append("    sourceWorkspaceId: ").append(toIndentedString(sourceWorkspaceId)).append("\n");
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

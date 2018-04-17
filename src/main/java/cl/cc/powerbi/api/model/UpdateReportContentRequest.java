package cl.cc.powerbi.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Power BI Update Report Content Request
 *
 * @author CyberCastle
 */
public class UpdateReportContentRequest {

    @JsonProperty("sourceType")
    private String sourceType;

    @JsonProperty("sourceReport")
    private SourceReport sourceReport;

    public UpdateReportContentRequest sourceType(String sourceType) {
        this.sourceType = sourceType;
        return this;
    }

    /**
     * The source type for the content update
     *
     * @return sourceType
     *
     */
    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    public UpdateReportContentRequest sourceReport(SourceReport sourceReport) {
        this.sourceReport = sourceReport;
        return this;
    }

    /**
     * Get sourceReport
     *
     * @return sourceReport
     *
     */
    public SourceReport getSourceReport() {
        return sourceReport;
    }

    public void setSourceReport(SourceReport sourceReport) {
        this.sourceReport = sourceReport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UpdateReportContentRequest updateReportContentRequest = (UpdateReportContentRequest) o;
        return Objects.equals(this.sourceType, updateReportContentRequest.sourceType)
                && Objects.equals(this.sourceReport, updateReportContentRequest.sourceReport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sourceType, sourceReport);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class UpdateReportContentRequest {\n");

        sb.append("    sourceType: ").append(toIndentedString(sourceType)).append("\n");
        sb.append("    sourceReport: ").append(toIndentedString(sourceReport)).append("\n");
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

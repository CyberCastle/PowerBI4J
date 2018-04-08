package cl.cc.powerbi.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Power BI Rebind Report Request
 *
 * @author CyberCastle
 */
public class RebindReportRequest {

    @JsonProperty("datasetId")
    private String datasetId = null;

    public RebindReportRequest datasetId(String datasetId) {
        this.datasetId = datasetId;
        return this;
    }

    /**
     * The new dataset of the rebinded report
     *
     * @return datasetId
     *
     */
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

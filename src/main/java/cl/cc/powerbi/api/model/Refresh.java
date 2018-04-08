package cl.cc.powerbi.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.OffsetDateTime;

/**
 * A Power BI refresh history entry
 *
 * @author CyberCastle
 */
public class Refresh {

    @JsonProperty("refreshType")
    private String refreshType = null;

    @JsonProperty("startTime")
    private OffsetDateTime startTime = null;

    @JsonProperty("endTime")
    private OffsetDateTime endTime = null;

    @JsonProperty("serviceExceptionJson")
    private String serviceExceptionJson = null;

    @JsonProperty("status")
    private String status = null;

    public Refresh refreshType(String refreshType) {
        this.refreshType = refreshType;
        return this;
    }

    /**
     *
     * @return refreshType
     *
     */
    public String getRefreshType() {
        return refreshType;
    }

    public void setRefreshType(String refreshType) {
        this.refreshType = refreshType;
    }

    public Refresh startTime(OffsetDateTime startTime) {
        this.startTime = startTime;
        return this;
    }

    /**
     *
     * @return startTime
     *
     */
    public OffsetDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(OffsetDateTime startTime) {
        this.startTime = startTime;
    }

    public Refresh endTime(OffsetDateTime endTime) {
        this.endTime = endTime;
        return this;
    }

    /**
     *
     * @return endTime
     *
     */
    public OffsetDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(OffsetDateTime endTime) {
        this.endTime = endTime;
    }

    public Refresh serviceExceptionJson(String serviceExceptionJson) {
        this.serviceExceptionJson = serviceExceptionJson;
        return this;
    }

    /**
     *
     * @return serviceExceptionJson
     *
     */
    public String getServiceExceptionJson() {
        return serviceExceptionJson;
    }

    public void setServiceExceptionJson(String serviceExceptionJson) {
        this.serviceExceptionJson = serviceExceptionJson;
    }

    public Refresh status(String status) {
        this.status = status;
        return this;
    }

    /**
     *
     * @return status
     *
     */
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Refresh refresh = (Refresh) o;
        return Objects.equals(this.refreshType, refresh.refreshType)
                && Objects.equals(this.startTime, refresh.startTime)
                && Objects.equals(this.endTime, refresh.endTime)
                && Objects.equals(this.serviceExceptionJson, refresh.serviceExceptionJson)
                && Objects.equals(this.status, refresh.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(refreshType, startTime, endTime, serviceExceptionJson, status);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Refresh {\n");

        sb.append("    refreshType: ").append(toIndentedString(refreshType)).append("\n");
        sb.append("    startTime: ").append(toIndentedString(startTime)).append("\n");
        sb.append("    endTime: ").append(toIndentedString(endTime)).append("\n");
        sb.append("    serviceExceptionJson: ").append(toIndentedString(serviceExceptionJson)).append("\n");
        sb.append("    status: ").append(toIndentedString(status)).append("\n");
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

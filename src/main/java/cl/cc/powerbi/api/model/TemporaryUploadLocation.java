package cl.cc.powerbi.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.OffsetDateTime;

/**
 * Power BI Update Report Content Request
 *
 * @author CyberCastle
 */
public class TemporaryUploadLocation {

    @JsonProperty("Url")
    private String url = null;

    @JsonProperty("ExpirationTime")
    private OffsetDateTime expirationTime = null;

    public TemporaryUploadLocation url(String url) {
        this.url = url;
        return this;
    }

    /**
     * The SAS url for the temporary blob storage
     *
     * @return url
     *
     */
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public TemporaryUploadLocation expirationTime(OffsetDateTime expirationTime) {
        this.expirationTime = expirationTime;
        return this;
    }

    /**
     * The expiration time of the SAS url
     *
     * @return expirationTime
     *
     */
    public OffsetDateTime getExpirationTime() {
        return expirationTime;
    }

    public void setExpirationTime(OffsetDateTime expirationTime) {
        this.expirationTime = expirationTime;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TemporaryUploadLocation temporaryUploadLocation = (TemporaryUploadLocation) o;
        return Objects.equals(this.url, temporaryUploadLocation.url)
                && Objects.equals(this.expirationTime, temporaryUploadLocation.expirationTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(url, expirationTime);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TemporaryUploadLocation {\n");

        sb.append("    url: ").append(toIndentedString(url)).append("\n");
        sb.append("    expirationTime: ").append(toIndentedString(expirationTime)).append("\n");
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

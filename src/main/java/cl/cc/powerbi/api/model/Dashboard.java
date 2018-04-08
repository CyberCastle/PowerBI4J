package cl.cc.powerbi.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * A Power BI Dashboard
 *
 * @author CyberCastle
 */
public class Dashboard {

    @JsonProperty("id")
    private String id = null;

    @JsonProperty("displayName")
    private String displayName = null;

    @JsonProperty("isReadOnly")
    private Boolean isReadOnly = null;

    @JsonProperty("embedUrl")
    private String embedUrl = null;

    public Dashboard id(String id) {
        this.id = id;
        return this;
    }

    /**
     * The dashboard id
     *
     * @return id
     *
     */
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Dashboard displayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    /**
     * The dashboard display name
     *
     * @return displayName
     *
     */
    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public Dashboard isReadOnly(Boolean isReadOnly) {
        this.isReadOnly = isReadOnly;
        return this;
    }

    /**
     * Is ReadOnly dashboard
     *
     * @return isReadOnly
     *
     */
    public Boolean isIsReadOnly() {
        return isReadOnly;
    }

    public void setIsReadOnly(Boolean isReadOnly) {
        this.isReadOnly = isReadOnly;
    }

    public Dashboard embedUrl(String embedUrl) {
        this.embedUrl = embedUrl;
        return this;
    }

    /**
     * The dashboard embed url
     *
     * @return embedUrl
     *
     */
    public String getEmbedUrl() {
        return embedUrl;
    }

    public void setEmbedUrl(String embedUrl) {
        this.embedUrl = embedUrl;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Dashboard dashboard = (Dashboard) o;
        return Objects.equals(this.id, dashboard.id)
                && Objects.equals(this.displayName, dashboard.displayName)
                && Objects.equals(this.isReadOnly, dashboard.isReadOnly)
                && Objects.equals(this.embedUrl, dashboard.embedUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, displayName, isReadOnly, embedUrl);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Dashboard {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
        sb.append("    isReadOnly: ").append(toIndentedString(isReadOnly)).append("\n");
        sb.append("    embedUrl: ").append(toIndentedString(embedUrl)).append("\n");
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

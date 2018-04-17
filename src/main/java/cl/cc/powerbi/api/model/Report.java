package cl.cc.powerbi.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * A Power BI Report
 *
 * @author CyberCastle
 */
public class Report {

    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("webUrl")
    private String webUrl;

    @JsonProperty("embedUrl")
    private String embedUrl;

    @JsonProperty("datasetId")
    private String datasetId;

    public Report id(String id) {
        this.id = id;
        return this;
    }

    /**
     * The report id
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

    public Report name(String name) {
        this.name = name;
        return this;
    }

    /**
     * The report name
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

    public Report webUrl(String webUrl) {
        this.webUrl = webUrl;
        return this;
    }

    /**
     * The report web url
     *
     * @return webUrl
     *
     */
    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

    public Report embedUrl(String embedUrl) {
        this.embedUrl = embedUrl;
        return this;
    }

    /**
     * The report embed url
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

    public Report datasetId(String datasetId) {
        this.datasetId = datasetId;
        return this;
    }

    /**
     * The dataset id
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
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Report report = (Report) o;
        return Objects.equals(this.id, report.id)
                && Objects.equals(this.name, report.name)
                && Objects.equals(this.webUrl, report.webUrl)
                && Objects.equals(this.embedUrl, report.embedUrl)
                && Objects.equals(this.datasetId, report.datasetId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, webUrl, embedUrl, datasetId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Report {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    webUrl: ").append(toIndentedString(webUrl)).append("\n");
        sb.append("    embedUrl: ").append(toIndentedString(embedUrl)).append("\n");
        sb.append("    datasetId: ").append(toIndentedString(datasetId)).append("\n");
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

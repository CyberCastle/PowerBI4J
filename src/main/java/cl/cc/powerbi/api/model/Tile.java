package cl.cc.powerbi.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * A Power BI Tile
 *
 * @author CyberCastle
 */
public class Tile {

    @JsonProperty("id")
    private String id;

    @JsonProperty("title")
    private String title;

    @JsonProperty("rowSpan")
    private Integer rowSpan;

    @JsonProperty("colSpan")
    private Integer colSpan;

    @JsonProperty("embedUrl")
    private String embedUrl;

    @JsonProperty("embedData")
    private String embedData;

    @JsonProperty("reportId")
    private String reportId;

    @JsonProperty("datasetId")
    private String datasetId;

    public Tile id(String id) {
        this.id = id;
        return this;
    }

    /**
     * The tile id
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

    public Tile title(String title) {
        this.title = title;
        return this;
    }

    /**
     * The dashboard display name
     *
     * @return title
     *
     */
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Tile rowSpan(Integer rowSpan) {
        this.rowSpan = rowSpan;
        return this;
    }

    /**
     * number of rows a tile should span
     *
     * @return rowSpan
     *
     */
    public Integer getRowSpan() {
        return rowSpan;
    }

    public void setRowSpan(Integer rowSpan) {
        this.rowSpan = rowSpan;
    }

    public Tile colSpan(Integer colSpan) {
        this.colSpan = colSpan;
        return this;
    }

    /**
     * number of columns a tile should span
     *
     * @return colSpan
     *
     */
    public Integer getColSpan() {
        return colSpan;
    }

    public void setColSpan(Integer colSpan) {
        this.colSpan = colSpan;
    }

    public Tile embedUrl(String embedUrl) {
        this.embedUrl = embedUrl;
        return this;
    }

    /**
     * The tile embed url
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

    public Tile embedData(String embedData) {
        this.embedData = embedData;
        return this;
    }

    /**
     * The tile embed data
     *
     * @return embedData
     *
     */
    public String getEmbedData() {
        return embedData;
    }

    public void setEmbedData(String embedData) {
        this.embedData = embedData;
    }

    public Tile reportId(String reportId) {
        this.reportId = reportId;
        return this;
    }

    /**
     * The report id
     *
     * @return reportId
     *
     */
    public String getReportId() {
        return reportId;
    }

    public void setReportId(String reportId) {
        this.reportId = reportId;
    }

    public Tile datasetId(String datasetId) {
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
        Tile tile = (Tile) o;
        return Objects.equals(this.id, tile.id)
                && Objects.equals(this.title, tile.title)
                && Objects.equals(this.rowSpan, tile.rowSpan)
                && Objects.equals(this.colSpan, tile.colSpan)
                && Objects.equals(this.embedUrl, tile.embedUrl)
                && Objects.equals(this.embedData, tile.embedData)
                && Objects.equals(this.reportId, tile.reportId)
                && Objects.equals(this.datasetId, tile.datasetId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, rowSpan, colSpan, embedUrl, embedData, reportId, datasetId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Tile {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    title: ").append(toIndentedString(title)).append("\n");
        sb.append("    rowSpan: ").append(toIndentedString(rowSpan)).append("\n");
        sb.append("    colSpan: ").append(toIndentedString(colSpan)).append("\n");
        sb.append("    embedUrl: ").append(toIndentedString(embedUrl)).append("\n");
        sb.append("    embedData: ").append(toIndentedString(embedData)).append("\n");
        sb.append("    reportId: ").append(toIndentedString(reportId)).append("\n");
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

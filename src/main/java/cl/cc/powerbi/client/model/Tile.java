/*
 * Power BI Client
 * No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
 *
 * The version of the OpenAPI document: v1.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package cl.cc.powerbi.client.model;

import java.util.Objects;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * A Power BI tile
 */
@ApiModel(description = "A Power BI tile")
@JsonPropertyOrder({ Tile.JSON_PROPERTY_ID, Tile.JSON_PROPERTY_TITLE, Tile.JSON_PROPERTY_ROW_SPAN,
        Tile.JSON_PROPERTY_COL_SPAN, Tile.JSON_PROPERTY_EMBED_URL, Tile.JSON_PROPERTY_EMBED_DATA,
        Tile.JSON_PROPERTY_REPORT_ID, Tile.JSON_PROPERTY_DATASET_ID })

public class Tile {
    public static final String JSON_PROPERTY_ID = "id";
    private UUID id;

    public static final String JSON_PROPERTY_TITLE = "title";
    private String title;

    public static final String JSON_PROPERTY_ROW_SPAN = "rowSpan";
    private Integer rowSpan;

    public static final String JSON_PROPERTY_COL_SPAN = "colSpan";
    private Integer colSpan;

    public static final String JSON_PROPERTY_EMBED_URL = "embedUrl";
    private String embedUrl;

    public static final String JSON_PROPERTY_EMBED_DATA = "embedData";
    private String embedData;

    public static final String JSON_PROPERTY_REPORT_ID = "reportId";
    private UUID reportId;

    public static final String JSON_PROPERTY_DATASET_ID = "datasetId";
    private String datasetId;

    public Tile id(UUID id) {

        this.id = id;
        return this;
    }

    /**
     * The tile id
     * 
     * @return id
     **/
    @ApiModelProperty(required = true, value = "The tile id")
    @JsonProperty(JSON_PROPERTY_ID)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
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
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "The dashboard display name")
    @JsonProperty(JSON_PROPERTY_TITLE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

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
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "number of rows a tile should span")
    @JsonProperty(JSON_PROPERTY_ROW_SPAN)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

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
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "number of columns a tile should span")
    @JsonProperty(JSON_PROPERTY_COL_SPAN)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

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
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "The tile embed url")
    @JsonProperty(JSON_PROPERTY_EMBED_URL)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

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
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "The tile embed data")
    @JsonProperty(JSON_PROPERTY_EMBED_DATA)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getEmbedData() {
        return embedData;
    }

    public void setEmbedData(String embedData) {
        this.embedData = embedData;
    }

    public Tile reportId(UUID reportId) {

        this.reportId = reportId;
        return this;
    }

    /**
     * The report id. Available only for tiles created from a report.
     * 
     * @return reportId
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "The report id. Available only for tiles created from a report.")
    @JsonProperty(JSON_PROPERTY_REPORT_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public UUID getReportId() {
        return reportId;
    }

    public void setReportId(UUID reportId) {
        this.reportId = reportId;
    }

    public Tile datasetId(String datasetId) {

        this.datasetId = datasetId;
        return this;
    }

    /**
     * The dataset id. Available only for tiles created from a report or using a
     * dataset; for example, Q&amp;A tiles.
     * 
     * @return datasetId
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "The dataset id. Available only for tiles created from a report or using a dataset; for example, Q&A tiles.")
    @JsonProperty(JSON_PROPERTY_DATASET_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

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
        Tile tile = (Tile) o;
        return Objects.equals(this.id, tile.id) && Objects.equals(this.title, tile.title)
                && Objects.equals(this.rowSpan, tile.rowSpan) && Objects.equals(this.colSpan, tile.colSpan)
                && Objects.equals(this.embedUrl, tile.embedUrl) && Objects.equals(this.embedData, tile.embedData)
                && Objects.equals(this.reportId, tile.reportId) && Objects.equals(this.datasetId, tile.datasetId);
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
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

}

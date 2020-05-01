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

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * The information about the import
 */
@ApiModel(description = "The information about the import")
@JsonPropertyOrder({ ImportInfo.JSON_PROPERTY_FILE_PATH, ImportInfo.JSON_PROPERTY_CONNECTION_TYPE,
        ImportInfo.JSON_PROPERTY_FILE_URL })

public class ImportInfo {
    public static final String JSON_PROPERTY_FILE_PATH = "filePath";
    private String filePath;

    /**
     * The import connection type for OneDrive for Business file
     */
    public enum ConnectionTypeEnum {
        IMPORT("import"),

        CONNECT("connect");

        private String value;

        ConnectionTypeEnum(String value) {
            this.value = value;
        }

        @JsonValue
        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        @JsonCreator
        public static ConnectionTypeEnum fromValue(String value) {
            for (ConnectionTypeEnum b : ConnectionTypeEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }

    public static final String JSON_PROPERTY_CONNECTION_TYPE = "connectionType";
    private ConnectionTypeEnum connectionType;

    public static final String JSON_PROPERTY_FILE_URL = "fileUrl";
    private String fileUrl;

    public ImportInfo filePath(String filePath) {

        this.filePath = filePath;
        return this;
    }

    /**
     * The OneDrive for Business .xlsx file path to import, can be absolute or
     * relative. .pbix files are not supported.
     * 
     * @return filePath
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "The OneDrive for Business .xlsx file path to import, can be absolute or relative. .pbix files are not supported.")
    @JsonProperty(JSON_PROPERTY_FILE_PATH)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public ImportInfo connectionType(ConnectionTypeEnum connectionType) {

        this.connectionType = connectionType;
        return this;
    }

    /**
     * The import connection type for OneDrive for Business file
     * 
     * @return connectionType
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "The import connection type for OneDrive for Business file")
    @JsonProperty(JSON_PROPERTY_CONNECTION_TYPE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public ConnectionTypeEnum getConnectionType() {
        return connectionType;
    }

    public void setConnectionType(ConnectionTypeEnum connectionType) {
        this.connectionType = connectionType;
    }

    public ImportInfo fileUrl(String fileUrl) {

        this.fileUrl = fileUrl;
        return this;
    }

    /**
     * The shared access signature (SAS) url of the temporary blob storage, used to
     * import large .pbix files between 1 GB and 10 GB
     * 
     * @return fileUrl
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "The shared access signature (SAS) url of the temporary blob storage, used to import large .pbix files between 1 GB and 10 GB")
    @JsonProperty(JSON_PROPERTY_FILE_URL)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ImportInfo importInfo = (ImportInfo) o;
        return Objects.equals(this.filePath, importInfo.filePath)
                && Objects.equals(this.connectionType, importInfo.connectionType)
                && Objects.equals(this.fileUrl, importInfo.fileUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(filePath, connectionType, fileUrl);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ImportInfo {\n");
        sb.append("    filePath: ").append(toIndentedString(filePath)).append("\n");
        sb.append("    connectionType: ").append(toIndentedString(connectionType)).append("\n");
        sb.append("    fileUrl: ").append(toIndentedString(fileUrl)).append("\n");
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

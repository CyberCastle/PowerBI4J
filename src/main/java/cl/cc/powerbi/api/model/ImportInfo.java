package cl.cc.powerbi.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The import info
 *
 * @author CyberCastle
 */
public class ImportInfo {

    @JsonProperty("filePath")
    private String filePath = null;

    @JsonProperty("connectionType")
    private String connectionType = null;

    @JsonProperty("fileUrl")
    private String fileUrl = null;

    public ImportInfo filePath(String filePath) {
        this.filePath = filePath;
        return this;
    }

    /**
     * The file path to import
     *
     * @return filePath
     *
     */
    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public ImportInfo connectionType(String connectionType) {
        this.connectionType = connectionType;
        return this;
    }

    /**
     * The import connection type
     *
     * @return connectionType
     *
     */
    public String getConnectionType() {
        return connectionType;
    }

    public void setConnectionType(String connectionType) {
        this.connectionType = connectionType;
    }

    public ImportInfo fileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
        return this;
    }

    /**
     * The SAS url of the temporary blob storage
     *
     * @return fileUrl
     *
     */
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

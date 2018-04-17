package cl.cc.powerbi.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * The import object
 *
 * @author CyberCastle
 */
public class Imports {

    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("importState")
    private String importState;

    @JsonProperty("reports")
    private List<Report> reports;

    @JsonProperty("datasets")
    private List<Dataset> datasets;

    @JsonProperty("createdDateTime")
    private OffsetDateTime createdDateTime;

    @JsonProperty("updatedDateTime")
    private OffsetDateTime updatedDateTime;

    public Imports id(String id) {
        this.id = id;
        return this;
    }

    /**
     * The import id
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

    public Imports name(String name) {
        this.name = name;
        return this;
    }

    /**
     * The import name name
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

    public Imports importState(String importState) {
        this.importState = importState;
        return this;
    }

    /**
     * The import upload state
     *
     * @return importState
     *
     */
    public String getImportState() {
        return importState;
    }

    public void setImportState(String importState) {
        this.importState = importState;
    }

    public Imports reports(List<Report> reports) {
        this.reports = reports;
        return this;
    }

    public Imports addReportsItem(Report reportsItem) {
        if (this.reports == null) {
            this.reports = new ArrayList<>();
        }
        this.reports.add(reportsItem);
        return this;
    }

    /**
     * The reports associated with this import
     *
     * @return reports
     *
     */
    public List<Report> getReports() {
        return reports;
    }

    public void setReports(List<Report> reports) {
        this.reports = reports;
    }

    public Imports datasets(List<Dataset> datasets) {
        this.datasets = datasets;
        return this;
    }

    public Imports addDatasetsItem(Dataset datasetsItem) {
        if (this.datasets == null) {
            this.datasets = new ArrayList<>();
        }
        this.datasets.add(datasetsItem);
        return this;
    }

    /**
     * The datasets associated with this import
     *
     * @return datasets
     *
     */
    public List<Dataset> getDatasets() {
        return datasets;
    }

    public void setDatasets(List<Dataset> datasets) {
        this.datasets = datasets;
    }

    public Imports createdDateTime(OffsetDateTime createdDateTime) {
        this.createdDateTime = createdDateTime;
        return this;
    }

    /**
     * Import creation time
     *
     * @return createdDateTime
     *
     */
    public OffsetDateTime getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(OffsetDateTime createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    public Imports updatedDateTime(OffsetDateTime updatedDateTime) {
        this.updatedDateTime = updatedDateTime;
        return this;
    }

    /**
     * Import last update time
     *
     * @return updatedDateTime
     *
     */
    public OffsetDateTime getUpdatedDateTime() {
        return updatedDateTime;
    }

    public void setUpdatedDateTime(OffsetDateTime updatedDateTime) {
        this.updatedDateTime = updatedDateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Imports _import = (Imports) o;
        return Objects.equals(this.id, _import.id)
                && Objects.equals(this.name, _import.name)
                && Objects.equals(this.importState, _import.importState)
                && Objects.equals(this.reports, _import.reports)
                && Objects.equals(this.datasets, _import.datasets)
                && Objects.equals(this.createdDateTime, _import.createdDateTime)
                && Objects.equals(this.updatedDateTime, _import.updatedDateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, importState, reports, datasets, createdDateTime, updatedDateTime);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ModelImport {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    importState: ").append(toIndentedString(importState)).append("\n");
        sb.append("    reports: ").append(toIndentedString(reports)).append("\n");
        sb.append("    datasets: ").append(toIndentedString(datasets)).append("\n");
        sb.append("    createdDateTime: ").append(toIndentedString(createdDateTime)).append("\n");
        sb.append("    updatedDateTime: ").append(toIndentedString(updatedDateTime)).append("\n");
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

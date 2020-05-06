
package cl.cc.powerbi.datamodel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "culture", "dataAccessOptions", "defaultPowerBIDataSourceVersion", "sourceQueryCulture", "tables",
        "relationships", "cultures", "annotations" })
public class Model implements Serializable {

    @JsonProperty("culture")
    private String culture;
    @JsonProperty("dataAccessOptions")
    private DataAccessOptions dataAccessOptions;
    @JsonProperty("defaultPowerBIDataSourceVersion")
    private String defaultPowerBIDataSourceVersion;
    @JsonProperty("sourceQueryCulture")
    private String sourceQueryCulture;
    @JsonProperty("tables")
    private List<Table> tables = new ArrayList<Table>();
    @JsonProperty("relationships")
    private List<Relationship> relationships = new ArrayList<Relationship>();
    @JsonProperty("cultures")
    private List<Culture> cultures = new ArrayList<Culture>();
    @JsonProperty("annotations")
    private List<Annotation> annotations = new ArrayList<Annotation>();
    private final static long serialVersionUID = -2877946722026414977L;

    @JsonProperty("culture")
    public String getCulture() {
        return culture;
    }

    @JsonProperty("culture")
    public void setCulture(String culture) {
        this.culture = culture;
    }

    @JsonProperty("dataAccessOptions")
    public DataAccessOptions getDataAccessOptions() {
        return dataAccessOptions;
    }

    @JsonProperty("dataAccessOptions")
    public void setDataAccessOptions(DataAccessOptions dataAccessOptions) {
        this.dataAccessOptions = dataAccessOptions;
    }

    @JsonProperty("defaultPowerBIDataSourceVersion")
    public String getDefaultPowerBIDataSourceVersion() {
        return defaultPowerBIDataSourceVersion;
    }

    @JsonProperty("defaultPowerBIDataSourceVersion")
    public void setDefaultPowerBIDataSourceVersion(String defaultPowerBIDataSourceVersion) {
        this.defaultPowerBIDataSourceVersion = defaultPowerBIDataSourceVersion;
    }

    @JsonProperty("sourceQueryCulture")
    public String getSourceQueryCulture() {
        return sourceQueryCulture;
    }

    @JsonProperty("sourceQueryCulture")
    public void setSourceQueryCulture(String sourceQueryCulture) {
        this.sourceQueryCulture = sourceQueryCulture;
    }

    @JsonProperty("tables")
    public List<Table> getTables() {
        return tables;
    }

    @JsonProperty("tables")
    public void setTables(List<Table> tables) {
        this.tables = tables;
    }

    @JsonProperty("relationships")
    public List<Relationship> getRelationships() {
        return relationships;
    }

    @JsonProperty("relationships")
    public void setRelationships(List<Relationship> relationships) {
        this.relationships = relationships;
    }

    @JsonProperty("cultures")
    public List<Culture> getCultures() {
        return cultures;
    }

    @JsonProperty("cultures")
    public void setCultures(List<Culture> cultures) {
        this.cultures = cultures;
    }

    @JsonProperty("annotations")
    public List<Annotation> getAnnotations() {
        return annotations;
    }

    @JsonProperty("annotations")
    public void setAnnotations(List<Annotation> annotations) {
        this.annotations = annotations;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Model.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)))
                .append('[');
        sb.append("culture");
        sb.append('=');
        sb.append(((this.culture == null) ? "<null>" : this.culture));
        sb.append(',');
        sb.append("dataAccessOptions");
        sb.append('=');
        sb.append(((this.dataAccessOptions == null) ? "<null>" : this.dataAccessOptions));
        sb.append(',');
        sb.append("defaultPowerBIDataSourceVersion");
        sb.append('=');
        sb.append(((this.defaultPowerBIDataSourceVersion == null) ? "<null>" : this.defaultPowerBIDataSourceVersion));
        sb.append(',');
        sb.append("sourceQueryCulture");
        sb.append('=');
        sb.append(((this.sourceQueryCulture == null) ? "<null>" : this.sourceQueryCulture));
        sb.append(',');
        sb.append("tables");
        sb.append('=');
        sb.append(((this.tables == null) ? "<null>" : this.tables));
        sb.append(',');
        sb.append("relationships");
        sb.append('=');
        sb.append(((this.relationships == null) ? "<null>" : this.relationships));
        sb.append(',');
        sb.append("cultures");
        sb.append('=');
        sb.append(((this.cultures == null) ? "<null>" : this.cultures));
        sb.append(',');
        sb.append("annotations");
        sb.append('=');
        sb.append(((this.annotations == null) ? "<null>" : this.annotations));
        sb.append(',');
        if (sb.charAt((sb.length() - 1)) == ',') {
            sb.setCharAt((sb.length() - 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result * 31) + ((this.relationships == null) ? 0 : this.relationships.hashCode()));
        result = ((result * 31) + ((this.sourceQueryCulture == null) ? 0 : this.sourceQueryCulture.hashCode()));
        result = ((result * 31) + ((this.tables == null) ? 0 : this.tables.hashCode()));
        result = ((result * 31) + ((this.culture == null) ? 0 : this.culture.hashCode()));
        result = ((result * 31) + ((this.defaultPowerBIDataSourceVersion == null) ? 0
                : this.defaultPowerBIDataSourceVersion.hashCode()));
        result = ((result * 31) + ((this.cultures == null) ? 0 : this.cultures.hashCode()));
        result = ((result * 31) + ((this.annotations == null) ? 0 : this.annotations.hashCode()));
        result = ((result * 31) + ((this.dataAccessOptions == null) ? 0 : this.dataAccessOptions.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Model) == false) {
            return false;
        }
        Model rhs = ((Model) other);
        return (((((((((this.relationships == rhs.relationships)
                || ((this.relationships != null) && this.relationships.equals(rhs.relationships)))
                && ((this.sourceQueryCulture == rhs.sourceQueryCulture) || ((this.sourceQueryCulture != null)
                        && this.sourceQueryCulture.equals(rhs.sourceQueryCulture))))
                && ((this.tables == rhs.tables) || ((this.tables != null) && this.tables.equals(rhs.tables))))
                && ((this.culture == rhs.culture) || ((this.culture != null) && this.culture.equals(rhs.culture))))
                && ((this.defaultPowerBIDataSourceVersion == rhs.defaultPowerBIDataSourceVersion)
                        || ((this.defaultPowerBIDataSourceVersion != null)
                                && this.defaultPowerBIDataSourceVersion.equals(rhs.defaultPowerBIDataSourceVersion))))
                && ((this.cultures == rhs.cultures) || ((this.cultures != null) && this.cultures.equals(rhs.cultures))))
                && ((this.annotations == rhs.annotations)
                        || ((this.annotations != null) && this.annotations.equals(rhs.annotations))))
                && ((this.dataAccessOptions == rhs.dataAccessOptions)
                        || ((this.dataAccessOptions != null) && this.dataAccessOptions.equals(rhs.dataAccessOptions))));
    }

}

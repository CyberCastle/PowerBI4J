package cl.cc.powerbi.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.ArrayList;
import java.util.List;

/**
 * A Power BI Dataset. More info here:
 * https://msdn.microsoft.com/en-us/library/mt742155.aspx
 *
 * @author CyberCastle
 */
public class Dataset {

    public Dataset() {

    }

    public Dataset(String name) {
        this.name = name;
    }

    @JsonProperty("id")
    private String id = null;

    @JsonProperty("name")
    private String name = null;

    @JsonProperty("configuredBy")
    private String configuredBy = null;

    @JsonProperty("defaultRetentionPolicy")
    private String defaultRetentionPolicy = null;

    @JsonProperty("addRowsAPIEnabled")
    private Boolean addRowsAPIEnabled = null;

    @JsonProperty("tables")
    private List<Table> tables = new ArrayList<Table>();

    @JsonProperty("relationships")
    private List<Relationship> relationships = null;

    @JsonProperty("webUrl")
    private String webUrl = null;

    @JsonProperty("datasources")
    private List<Datasource> datasources = null;

    /**
     * The dataset mode or type
     */
    public enum DefaultModeEnum {
        ASAZURE("AsAzure"),
        ASONPREM("AsOnPrem"),
        PUSH("Push"),
        STREAMING("Streaming"),
        PUSHSTREAMING("PushStreaming");

        private final String value;

        DefaultModeEnum(String value) {
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
        public static DefaultModeEnum fromValue(String text) {
            for (DefaultModeEnum b : DefaultModeEnum.values()) {
                if (String.valueOf(b.value).equals(text)) {
                    return b;
                }
            }
            return null;
        }
    }

    @JsonProperty("defaultMode")
    private DefaultModeEnum defaultMode = null;

    @JsonProperty("IsRefreshable")
    private Boolean isRefreshable = null;

    @JsonProperty("IsEffectiveIdentityRequired")
    private Boolean isEffectiveIdentityRequired = null;

    @JsonProperty("IsEffectiveIdentityRolesRequired")
    private Boolean isEffectiveIdentityRolesRequired = null;

    @JsonProperty("IsOnPremGatewayRequired")
    private Boolean isOnPremGatewayRequired = null;

    public Dataset id(String id) {
        this.id = id;
        return this;
    }

    /**
     * The dataset id
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

    public Dataset name(String name) {
        this.name = name;
        return this;
    }

    /**
     * The dataset name
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

    public Dataset configuredBy(String configuredBy) {
        this.configuredBy = configuredBy;
        return this;
    }

    /**
     * The dataset owner
     *
     * @return configuredBy
     *
     */
    public String getConfiguredBy() {
        return configuredBy;
    }

    public void setConfiguredBy(String configuredBy) {
        this.configuredBy = configuredBy;
    }

    public Dataset defaultRetentionPolicy(String defaultRetentionPolicy) {
        this.defaultRetentionPolicy = defaultRetentionPolicy;
        return this;
    }

    /**
     * The dataset default data retention policy
     *
     * @return defaultRetentionPolicy
     *
     */
    public String getDefaultRetentionPolicy() {
        return defaultRetentionPolicy;
    }

    public void setDefaultRetentionPolicy(String defaultRetentionPolicy) {
        this.defaultRetentionPolicy = defaultRetentionPolicy;
    }

    public Dataset addRowsAPIEnabled(Boolean addRowsAPIEnabled) {
        this.addRowsAPIEnabled = addRowsAPIEnabled;
        return this;
    }

    /**
     * Is Push Dataset
     *
     * @return addRowsAPIEnabled
     *
     */
    public Boolean isAddRowsAPIEnabled() {
        return addRowsAPIEnabled;
    }

    public void setAddRowsAPIEnabled(Boolean addRowsAPIEnabled) {
        this.addRowsAPIEnabled = addRowsAPIEnabled;
    }

    public Dataset tables(List<Table> tables) {
        this.tables = tables;
        return this;
    }

    public Dataset addTablesItem(Table tablesItem) {
        this.tables.add(tablesItem);
        return this;
    }

    /**
     * The dataset tables
     *
     * @return tables
     *
     */
    public List<Table> getTables() {
        return tables;
    }

    public void setTables(List<Table> tables) {
        this.tables = tables;
    }

    public Dataset relationships(List<Relationship> relationships) {
        this.relationships = relationships;
        return this;
    }

    public Dataset addRelationshipsItem(Relationship relationshipsItem) {
        if (this.relationships == null) {
            this.relationships = new ArrayList<>();
        }
        this.relationships.add(relationshipsItem);
        return this;
    }

    /**
     * The dataset relationships
     *
     * @return relationships
     *
     */
    public List<Relationship> getRelationships() {
        return relationships;
    }

    public void setRelationships(List<Relationship> relationships) {
        this.relationships = relationships;
    }

    public Dataset webUrl(String webUrl) {
        this.webUrl = webUrl;
        return this;
    }

    /**
     * The dataset web url
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

    public Dataset datasources(List<Datasource> datasources) {
        this.datasources = datasources;
        return this;
    }

    public Dataset addDatasourcesItem(Datasource datasourcesItem) {
        if (this.datasources == null) {
            this.datasources = new ArrayList<>();
        }
        this.datasources.add(datasourcesItem);
        return this;
    }

    /**
     * The datasources associated with this dataset
     *
     * @return datasources
     *
     */
    public List<Datasource> getDatasources() {
        return datasources;
    }

    public void setDatasources(List<Datasource> datasources) {
        this.datasources = datasources;
    }

    public Dataset defaultMode(DefaultModeEnum defaultMode) {
        this.defaultMode = defaultMode;
        return this;
    }

    /**
     * The dataset mode or type
     *
     * @return defaultMode
     *
     */
    public DefaultModeEnum getDefaultMode() {
        return defaultMode;
    }

    public void setDefaultMode(DefaultModeEnum defaultMode) {
        this.defaultMode = defaultMode;
    }

    public Dataset isRefreshable(Boolean isRefreshable) {
        this.isRefreshable = isRefreshable;
        return this;
    }

    /**
     * Can this dataset be refreshed
     *
     * @return isRefreshable
     *
     */
    public Boolean isIsRefreshable() {
        return isRefreshable;
    }

    public void setIsRefreshable(Boolean isRefreshable) {
        this.isRefreshable = isRefreshable;
    }

    public Dataset isEffectiveIdentityRequired(Boolean isEffectiveIdentityRequired) {
        this.isEffectiveIdentityRequired = isEffectiveIdentityRequired;
        return this;
    }

    /**
     * Dataset requires effective identity
     *
     * @return isEffectiveIdentityRequired
     *
     */
    public Boolean isIsEffectiveIdentityRequired() {
        return isEffectiveIdentityRequired;
    }

    public void setIsEffectiveIdentityRequired(Boolean isEffectiveIdentityRequired) {
        this.isEffectiveIdentityRequired = isEffectiveIdentityRequired;
    }

    public Dataset isEffectiveIdentityRolesRequired(Boolean isEffectiveIdentityRolesRequired) {
        this.isEffectiveIdentityRolesRequired = isEffectiveIdentityRolesRequired;
        return this;
    }

    /**
     * Dataset requires roles
     *
     * @return isEffectiveIdentityRolesRequired
     *
     */
    public Boolean isIsEffectiveIdentityRolesRequired() {
        return isEffectiveIdentityRolesRequired;
    }

    public void setIsEffectiveIdentityRolesRequired(Boolean isEffectiveIdentityRolesRequired) {
        this.isEffectiveIdentityRolesRequired = isEffectiveIdentityRolesRequired;
    }

    public Dataset isOnPremGatewayRequired(Boolean isOnPremGatewayRequired) {
        this.isOnPremGatewayRequired = isOnPremGatewayRequired;
        return this;
    }

    /**
     * Dataset requires onprem gateway
     *
     * @return isOnPremGatewayRequired
     *
     */
    public Boolean isIsOnPremGatewayRequired() {
        return isOnPremGatewayRequired;
    }

    public void setIsOnPremGatewayRequired(Boolean isOnPremGatewayRequired) {
        this.isOnPremGatewayRequired = isOnPremGatewayRequired;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Dataset dataset = (Dataset) o;
        return Objects.equals(this.id, dataset.id)
                && Objects.equals(this.name, dataset.name)
                && Objects.equals(this.configuredBy, dataset.configuredBy)
                && Objects.equals(this.defaultRetentionPolicy, dataset.defaultRetentionPolicy)
                && Objects.equals(this.addRowsAPIEnabled, dataset.addRowsAPIEnabled)
                && Objects.equals(this.tables, dataset.tables)
                && Objects.equals(this.relationships, dataset.relationships)
                && Objects.equals(this.webUrl, dataset.webUrl)
                && Objects.equals(this.datasources, dataset.datasources)
                && Objects.equals(this.defaultMode, dataset.defaultMode)
                && Objects.equals(this.isRefreshable, dataset.isRefreshable)
                && Objects.equals(this.isEffectiveIdentityRequired, dataset.isEffectiveIdentityRequired)
                && Objects.equals(this.isEffectiveIdentityRolesRequired, dataset.isEffectiveIdentityRolesRequired)
                && Objects.equals(this.isOnPremGatewayRequired, dataset.isOnPremGatewayRequired);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, configuredBy, defaultRetentionPolicy, addRowsAPIEnabled, tables, relationships, webUrl, datasources, defaultMode, isRefreshable, isEffectiveIdentityRequired, isEffectiveIdentityRolesRequired, isOnPremGatewayRequired);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Dataset {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    configuredBy: ").append(toIndentedString(configuredBy)).append("\n");
        sb.append("    defaultRetentionPolicy: ").append(toIndentedString(defaultRetentionPolicy)).append("\n");
        sb.append("    addRowsAPIEnabled: ").append(toIndentedString(addRowsAPIEnabled)).append("\n");
        sb.append("    tables: ").append(toIndentedString(tables)).append("\n");
        sb.append("    relationships: ").append(toIndentedString(relationships)).append("\n");
        sb.append("    webUrl: ").append(toIndentedString(webUrl)).append("\n");
        sb.append("    datasources: ").append(toIndentedString(datasources)).append("\n");
        sb.append("    defaultMode: ").append(toIndentedString(defaultMode)).append("\n");
        sb.append("    isRefreshable: ").append(toIndentedString(isRefreshable)).append("\n");
        sb.append("    isEffectiveIdentityRequired: ").append(toIndentedString(isEffectiveIdentityRequired)).append("\n");
        sb.append("    isEffectiveIdentityRolesRequired: ").append(toIndentedString(isEffectiveIdentityRolesRequired)).append("\n");
        sb.append("    isOnPremGatewayRequired: ").append(toIndentedString(isOnPremGatewayRequired)).append("\n");
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

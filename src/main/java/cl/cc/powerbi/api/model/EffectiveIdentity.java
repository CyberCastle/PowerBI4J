package cl.cc.powerbi.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;

/**
 * The identity that the generated token should reflect
 *
 * @author CyberCastle
 */
public class EffectiveIdentity {

    @JsonProperty("username")
    private String username = null;

    @JsonProperty("roles")
    private List<String> roles = null;

    @JsonProperty("datasets")
    private List<String> datasets = new ArrayList<String>();

    @JsonProperty("customData")
    private String customData = null;

    public EffectiveIdentity username(String username) {
        this.username = username;
        return this;
    }

    /**
     * The effective username reflected by a token for applying RLS rules
     *
     * @return username
     *
     */
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public EffectiveIdentity roles(List<String> roles) {
        this.roles = roles;
        return this;
    }

    public EffectiveIdentity addRolesItem(String rolesItem) {
        if (this.roles == null) {
            this.roles = new ArrayList<>();
        }
        this.roles.add(rolesItem);
        return this;
    }

    /**
     * An array of roles reflected by a token when applying RLS rules
     *
     * @return roles
     *
     */
    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public EffectiveIdentity datasets(List<String> datasets) {
        this.datasets = datasets;
        return this;
    }

    public EffectiveIdentity addDatasetsItem(String datasetsItem) {
        this.datasets.add(datasetsItem);
        return this;
    }

    /**
     * An array of datasets for which this mapping applies to, if not provided -
     * applies to all datasets
     *
     * @return datasets
     *
     */
    public List<String> getDatasets() {
        return datasets;
    }

    public void setDatasets(List<String> datasets) {
        this.datasets = datasets;
    }

    public EffectiveIdentity customData(String customData) {
        this.customData = customData;
        return this;
    }

    /**
     * The custom data string to be added to the AS connection string
     *
     * @return customData
     *
     */
    public String getCustomData() {
        return customData;
    }

    public void setCustomData(String customData) {
        this.customData = customData;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EffectiveIdentity effectiveIdentity = (EffectiveIdentity) o;
        return Objects.equals(this.username, effectiveIdentity.username)
                && Objects.equals(this.roles, effectiveIdentity.roles)
                && Objects.equals(this.datasets, effectiveIdentity.datasets)
                && Objects.equals(this.customData, effectiveIdentity.customData);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, roles, datasets, customData);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EffectiveIdentity {\n");

        sb.append("    username: ").append(toIndentedString(username)).append("\n");
        sb.append("    roles: ").append(toIndentedString(roles)).append("\n");
        sb.append("    datasets: ").append(toIndentedString(datasets)).append("\n");
        sb.append("    customData: ").append(toIndentedString(customData)).append("\n");
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

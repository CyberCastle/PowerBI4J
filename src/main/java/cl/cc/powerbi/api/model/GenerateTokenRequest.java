package cl.cc.powerbi.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.ArrayList;
import java.util.List;

/**
 * Power BI Generate Token Request
 *
 * @author CyberCastle
 */
public class GenerateTokenRequest {

    /**
     * The dataset mode or type
     */
    public enum AccessLevelEnum {
        VIEW("View"),
        EDIT("Edit"),
        CREATE("Create");

        private final String value;

        AccessLevelEnum(String value) {
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
        public static AccessLevelEnum fromValue(String text) {
            for (AccessLevelEnum b : AccessLevelEnum.values()) {
                if (String.valueOf(b.value).equals(text)) {
                    return b;
                }
            }
            return null;
        }
    }

    @JsonProperty("accessLevel")
    private AccessLevelEnum accessLevel;

    @JsonProperty("datasetId")
    private String datasetId;

    @JsonProperty("allowSaveAs")
    private Boolean allowSaveAs;

    @JsonProperty("identities")
    private List<EffectiveIdentity> identities;

    public GenerateTokenRequest accessLevel(AccessLevelEnum accessLevel) {
        this.accessLevel = accessLevel;
        return this;
    }

    /**
     * The dataset mode or type
     *
     * @return accessLevel
     *
     */
    public AccessLevelEnum getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(AccessLevelEnum accessLevel) {
        this.accessLevel = accessLevel;
    }

    public GenerateTokenRequest datasetId(String datasetId) {
        this.datasetId = datasetId;
        return this;
    }

    /**
     * The dataset Id
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

    public GenerateTokenRequest allowSaveAs(Boolean allowSaveAs) {
        this.allowSaveAs = allowSaveAs;
        return this;
    }

    /**
     * Allow SaveAs the report with generated token.
     *
     * @return allowSaveAs
     *
     */
    public Boolean isAllowSaveAs() {
        return allowSaveAs;
    }

    public void setAllowSaveAs(Boolean allowSaveAs) {
        this.allowSaveAs = allowSaveAs;
    }

    public GenerateTokenRequest identities(List<EffectiveIdentity> identities) {
        this.identities = identities;
        return this;
    }

    public GenerateTokenRequest addIdentitiesItem(EffectiveIdentity identitiesItem) {
        if (this.identities == null) {
            this.identities = new ArrayList<>();
        }
        this.identities.add(identitiesItem);
        return this;
    }

    /**
     * The effective identities to use for RLS rules
     *
     * @return identities
     *
     */
    public List<EffectiveIdentity> getIdentities() {
        return identities;
    }

    public void setIdentities(List<EffectiveIdentity> identities) {
        this.identities = identities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GenerateTokenRequest generateTokenRequest = (GenerateTokenRequest) o;
        return Objects.equals(this.accessLevel, generateTokenRequest.accessLevel)
                && Objects.equals(this.datasetId, generateTokenRequest.datasetId)
                && Objects.equals(this.allowSaveAs, generateTokenRequest.allowSaveAs)
                && Objects.equals(this.identities, generateTokenRequest.identities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accessLevel, datasetId, allowSaveAs, identities);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class GenerateTokenRequest {\n");

        sb.append("    accessLevel: ").append(toIndentedString(accessLevel)).append("\n");
        sb.append("    datasetId: ").append(toIndentedString(datasetId)).append("\n");
        sb.append("    allowSaveAs: ").append(toIndentedString(allowSaveAs)).append("\n");
        sb.append("    identities: ").append(toIndentedString(identities)).append("\n");
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

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

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Add encryption key request
 */
@ApiModel(description = "Add encryption key request")
@JsonPropertyOrder({ TenantKeyCreationRequest.JSON_PROPERTY_NAME,
        TenantKeyCreationRequest.JSON_PROPERTY_KEY_VAULT_KEY_IDENTIFIER,
        TenantKeyCreationRequest.JSON_PROPERTY_IS_DEFAULT, TenantKeyCreationRequest.JSON_PROPERTY_ACTIVATE })

public class TenantKeyCreationRequest {
    public static final String JSON_PROPERTY_NAME = "name";
    private String name;

    public static final String JSON_PROPERTY_KEY_VAULT_KEY_IDENTIFIER = "keyVaultKeyIdentifier";
    private String keyVaultKeyIdentifier;

    public static final String JSON_PROPERTY_IS_DEFAULT = "isDefault";
    private Boolean isDefault;

    public static final String JSON_PROPERTY_ACTIVATE = "activate";
    private Boolean activate;

    public TenantKeyCreationRequest name(String name) {

        this.name = name;
        return this;
    }

    /**
     * The name of the encryption key
     * 
     * @return name
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "The name of the encryption key")
    @JsonProperty(JSON_PROPERTY_NAME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TenantKeyCreationRequest keyVaultKeyIdentifier(String keyVaultKeyIdentifier) {

        this.keyVaultKeyIdentifier = keyVaultKeyIdentifier;
        return this;
    }

    /**
     * Uri to the version of the Azure Key Vault key to be used
     * 
     * @return keyVaultKeyIdentifier
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "Uri to the version of the Azure Key Vault key to be used")
    @JsonProperty(JSON_PROPERTY_KEY_VAULT_KEY_IDENTIFIER)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getKeyVaultKeyIdentifier() {
        return keyVaultKeyIdentifier;
    }

    public void setKeyVaultKeyIdentifier(String keyVaultKeyIdentifier) {
        this.keyVaultKeyIdentifier = keyVaultKeyIdentifier;
    }

    public TenantKeyCreationRequest isDefault(Boolean isDefault) {

        this.isDefault = isDefault;
        return this;
    }

    /**
     * Indicates that this key is set as default for the entire tenant. Any new
     * capacity creation will inherit this key upon creation
     * 
     * @return isDefault
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "Indicates that this key is set as default for the entire tenant. Any new capacity creation will inherit this key upon creation")
    @JsonProperty(JSON_PROPERTY_IS_DEFAULT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Boolean getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Boolean isDefault) {
        this.isDefault = isDefault;
    }

    public TenantKeyCreationRequest activate(Boolean activate) {

        this.activate = activate;
        return this;
    }

    /**
     * Indicates to activate any inactivated capacities to use this key for its
     * encryption
     * 
     * @return activate
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "Indicates to activate any inactivated capacities to use this key for its encryption")
    @JsonProperty(JSON_PROPERTY_ACTIVATE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Boolean getActivate() {
        return activate;
    }

    public void setActivate(Boolean activate) {
        this.activate = activate;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TenantKeyCreationRequest tenantKeyCreationRequest = (TenantKeyCreationRequest) o;
        return Objects.equals(this.name, tenantKeyCreationRequest.name)
                && Objects.equals(this.keyVaultKeyIdentifier, tenantKeyCreationRequest.keyVaultKeyIdentifier)
                && Objects.equals(this.isDefault, tenantKeyCreationRequest.isDefault)
                && Objects.equals(this.activate, tenantKeyCreationRequest.activate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, keyVaultKeyIdentifier, isDefault, activate);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TenantKeyCreationRequest {\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    keyVaultKeyIdentifier: ").append(toIndentedString(keyVaultKeyIdentifier)).append("\n");
        sb.append("    isDefault: ").append(toIndentedString(isDefault)).append("\n");
        sb.append("    activate: ").append(toIndentedString(activate)).append("\n");
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

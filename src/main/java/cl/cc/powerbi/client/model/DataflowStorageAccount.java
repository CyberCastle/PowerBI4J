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
 * A Power BI dataflow storage account
 */
@ApiModel(description = "A Power BI dataflow storage account")
@JsonPropertyOrder({ DataflowStorageAccount.JSON_PROPERTY_ID, DataflowStorageAccount.JSON_PROPERTY_NAME,
        DataflowStorageAccount.JSON_PROPERTY_IS_ENABLED })

public class DataflowStorageAccount {
    public static final String JSON_PROPERTY_ID = "id";
    private UUID id;

    public static final String JSON_PROPERTY_NAME = "name";
    private String name;

    public static final String JSON_PROPERTY_IS_ENABLED = "isEnabled";
    private Boolean isEnabled;

    public DataflowStorageAccount id(UUID id) {

        this.id = id;
        return this;
    }

    /**
     * The Power BI dataflow storage account id
     * 
     * @return id
     **/
    @ApiModelProperty(required = true, value = "The Power BI dataflow storage account id")
    @JsonProperty(JSON_PROPERTY_ID)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public DataflowStorageAccount name(String name) {

        this.name = name;
        return this;
    }

    /**
     * The Power BI dataflow storage account name
     * 
     * @return name
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "The Power BI dataflow storage account name")
    @JsonProperty(JSON_PROPERTY_NAME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DataflowStorageAccount isEnabled(Boolean isEnabled) {

        this.isEnabled = isEnabled;
        return this;
    }

    /**
     * Indicates if workspaces can be assigned to this storage account
     * 
     * @return isEnabled
     **/
    @ApiModelProperty(required = true, value = "Indicates if workspaces can be assigned to this storage account")
    @JsonProperty(JSON_PROPERTY_IS_ENABLED)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public Boolean getIsEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(Boolean isEnabled) {
        this.isEnabled = isEnabled;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DataflowStorageAccount dataflowStorageAccount = (DataflowStorageAccount) o;
        return Objects.equals(this.id, dataflowStorageAccount.id)
                && Objects.equals(this.name, dataflowStorageAccount.name)
                && Objects.equals(this.isEnabled, dataflowStorageAccount.isEnabled);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, isEnabled);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DataflowStorageAccount {\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    isEnabled: ").append(toIndentedString(isEnabled)).append("\n");
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

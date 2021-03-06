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
 * Power BI request to restore a deleted group
 */
@ApiModel(description = "Power BI request to restore a deleted group")
@JsonPropertyOrder({ GroupRestoreRequest.JSON_PROPERTY_NAME, GroupRestoreRequest.JSON_PROPERTY_EMAIL_ADDRESS })

public class GroupRestoreRequest {
    public static final String JSON_PROPERTY_NAME = "name";
    private String name;

    public static final String JSON_PROPERTY_EMAIL_ADDRESS = "emailAddress";
    private String emailAddress;

    public GroupRestoreRequest name(String name) {

        this.name = name;
        return this;
    }

    /**
     * The name of the group to be restored.
     * 
     * @return name
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "The name of the group to be restored.")
    @JsonProperty(JSON_PROPERTY_NAME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GroupRestoreRequest emailAddress(String emailAddress) {

        this.emailAddress = emailAddress;
        return this;
    }

    /**
     * The email address of the owner of the group to be restored.
     * 
     * @return emailAddress
     **/
    @ApiModelProperty(required = true, value = "The email address of the owner of the group to be restored.")
    @JsonProperty(JSON_PROPERTY_EMAIL_ADDRESS)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GroupRestoreRequest groupRestoreRequest = (GroupRestoreRequest) o;
        return Objects.equals(this.name, groupRestoreRequest.name)
                && Objects.equals(this.emailAddress, groupRestoreRequest.emailAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, emailAddress);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class GroupRestoreRequest {\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    emailAddress: ").append(toIndentedString(emailAddress)).append("\n");
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

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
 * The report object for Generate Token Request V2.
 */
@ApiModel(description = "The report object for Generate Token Request V2.")
@JsonPropertyOrder({ GenerateTokenRequestV2Report.JSON_PROPERTY_ALLOW_EDIT,
        GenerateTokenRequestV2Report.JSON_PROPERTY_ID })

public class GenerateTokenRequestV2Report {
    public static final String JSON_PROPERTY_ALLOW_EDIT = "allowEdit";
    private Boolean allowEdit;

    public static final String JSON_PROPERTY_ID = "id";
    private UUID id;

    public GenerateTokenRequestV2Report allowEdit(Boolean allowEdit) {

        this.allowEdit = allowEdit;
        return this;
    }

    /**
     * Indicates that the generated EmbedToken grand editing for this report
     * 
     * @return allowEdit
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "Indicates that the generated EmbedToken grand editing for this report")
    @JsonProperty(JSON_PROPERTY_ALLOW_EDIT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Boolean getAllowEdit() {
        return allowEdit;
    }

    public void setAllowEdit(Boolean allowEdit) {
        this.allowEdit = allowEdit;
    }

    public GenerateTokenRequestV2Report id(UUID id) {

        this.id = id;
        return this;
    }

    /**
     * Report Id
     * 
     * @return id
     **/
    @ApiModelProperty(required = true, value = "Report Id")
    @JsonProperty(JSON_PROPERTY_ID)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GenerateTokenRequestV2Report generateTokenRequestV2Report = (GenerateTokenRequestV2Report) o;
        return Objects.equals(this.allowEdit, generateTokenRequestV2Report.allowEdit)
                && Objects.equals(this.id, generateTokenRequestV2Report.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(allowEdit, id);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class GenerateTokenRequestV2Report {\n");
        sb.append("    allowEdit: ").append(toIndentedString(allowEdit)).append("\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
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

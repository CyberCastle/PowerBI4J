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
 * The dataset object for Generate Token Request V2.
 */
@ApiModel(description = "The dataset object for Generate Token Request V2.")
@JsonPropertyOrder({ GenerateTokenRequestV2Dataset.JSON_PROPERTY_ID })

public class GenerateTokenRequestV2Dataset {
    public static final String JSON_PROPERTY_ID = "id";
    private String id;

    public GenerateTokenRequestV2Dataset id(String id) {

        this.id = id;
        return this;
    }

    /**
     * Dataset Id
     * 
     * @return id
     **/
    @ApiModelProperty(required = true, value = "Dataset Id")
    @JsonProperty(JSON_PROPERTY_ID)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
        GenerateTokenRequestV2Dataset generateTokenRequestV2Dataset = (GenerateTokenRequestV2Dataset) o;
        return Objects.equals(this.id, generateTokenRequestV2Dataset.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class GenerateTokenRequestV2Dataset {\n");
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

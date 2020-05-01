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
 * Additional feature information
 */
@ApiModel(description = "Additional feature information")
@JsonPropertyOrder({ AdditionalFeatureInfo.JSON_PROPERTY_USAGE })

public class AdditionalFeatureInfo {
    public static final String JSON_PROPERTY_USAGE = "Usage";
    private Integer usage;

    public AdditionalFeatureInfo usage(Integer usage) {

        this.usage = usage;
        return this;
    }

    /**
     * The token generation usage (in %) from the limitation on shared capacity
     * 
     * @return usage
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "The token generation usage (in %) from the limitation on shared capacity")
    @JsonProperty(JSON_PROPERTY_USAGE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Integer getUsage() {
        return usage;
    }

    public void setUsage(Integer usage) {
        this.usage = usage;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AdditionalFeatureInfo additionalFeatureInfo = (AdditionalFeatureInfo) o;
        return Objects.equals(this.usage, additionalFeatureInfo.usage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(usage);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AdditionalFeatureInfo {\n");
        sb.append("    usage: ").append(toIndentedString(usage)).append("\n");
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

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
 * A Power BI gateway public key
 */
@ApiModel(description = "A Power BI gateway public key")
@JsonPropertyOrder({ GatewayPublicKey.JSON_PROPERTY_EXPONENT, GatewayPublicKey.JSON_PROPERTY_MODULUS })

public class GatewayPublicKey {
    public static final String JSON_PROPERTY_EXPONENT = "exponent";
    private String exponent;

    public static final String JSON_PROPERTY_MODULUS = "modulus";
    private String modulus;

    public GatewayPublicKey exponent(String exponent) {

        this.exponent = exponent;
        return this;
    }

    /**
     * The public key exponent
     * 
     * @return exponent
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "The public key exponent")
    @JsonProperty(JSON_PROPERTY_EXPONENT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getExponent() {
        return exponent;
    }

    public void setExponent(String exponent) {
        this.exponent = exponent;
    }

    public GatewayPublicKey modulus(String modulus) {

        this.modulus = modulus;
        return this;
    }

    /**
     * The public key modulus
     * 
     * @return modulus
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "The public key  modulus")
    @JsonProperty(JSON_PROPERTY_MODULUS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getModulus() {
        return modulus;
    }

    public void setModulus(String modulus) {
        this.modulus = modulus;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GatewayPublicKey gatewayPublicKey = (GatewayPublicKey) o;
        return Objects.equals(this.exponent, gatewayPublicKey.exponent)
                && Objects.equals(this.modulus, gatewayPublicKey.modulus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(exponent, modulus);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class GatewayPublicKey {\n");
        sb.append("    exponent: ").append(toIndentedString(exponent)).append("\n");
        sb.append("    modulus: ").append(toIndentedString(modulus)).append("\n");
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
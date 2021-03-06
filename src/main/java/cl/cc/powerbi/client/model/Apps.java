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

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Odata response wrapper for a Power BI installed App list
 */
@ApiModel(description = "Odata response wrapper for a Power BI installed App list")
@JsonPropertyOrder({ Apps.JSON_PROPERTY_ODATA_CONTEXT, Apps.JSON_PROPERTY_VALUE })

public class Apps {
    public static final String JSON_PROPERTY_ODATA_CONTEXT = "odata.context";
    private String odataContext;

    public static final String JSON_PROPERTY_VALUE = "value";
    private List<App> value = null;

    public Apps odataContext(String odataContext) {

        this.odataContext = odataContext;
        return this;
    }

    /**
     * OData context
     * 
     * @return odataContext
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "OData context")
    @JsonProperty(JSON_PROPERTY_ODATA_CONTEXT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getOdataContext() {
        return odataContext;
    }

    public void setOdataContext(String odataContext) {
        this.odataContext = odataContext;
    }

    public Apps value(List<App> value) {

        this.value = value;
        return this;
    }

    public Apps addValueItem(App valueItem) {
        if (this.value == null) {
            this.value = new ArrayList<>();
        }
        this.value.add(valueItem);
        return this;
    }

    /**
     * The installed apps
     * 
     * @return value
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "The installed apps")
    @JsonProperty(JSON_PROPERTY_VALUE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<App> getValue() {
        return value;
    }

    public void setValue(List<App> value) {
        this.value = value;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Apps apps = (Apps) o;
        return Objects.equals(this.odataContext, apps.odataContext) && Objects.equals(this.value, apps.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(odataContext, value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Apps {\n");
        sb.append("    odataContext: ").append(toIndentedString(odataContext)).append("\n");
        sb.append("    value: ").append(toIndentedString(value)).append("\n");
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

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
 * The bookmark to apply on a single page. Provide name or state, but not both.
 */
@ApiModel(description = "The bookmark to apply on a single page. Provide name or state, but not both.")
@JsonPropertyOrder({ PageBookmark.JSON_PROPERTY_NAME, PageBookmark.JSON_PROPERTY_STATE })

public class PageBookmark {
    public static final String JSON_PROPERTY_NAME = "name";
    private String name;

    public static final String JSON_PROPERTY_STATE = "state";
    private String state;

    public PageBookmark name(String name) {

        this.name = name;
        return this;
    }

    /**
     * The bookmark name. Currently not supported
     * 
     * @return name
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "The bookmark name. Currently not supported")
    @JsonProperty(JSON_PROPERTY_NAME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PageBookmark state(String state) {

        this.state = state;
        return this;
    }

    /**
     * The bookmark state
     * 
     * @return state
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "The bookmark state")
    @JsonProperty(JSON_PROPERTY_STATE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PageBookmark pageBookmark = (PageBookmark) o;
        return Objects.equals(this.name, pageBookmark.name) && Objects.equals(this.state, pageBookmark.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, state);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class PageBookmark {\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    state: ").append(toIndentedString(state)).append("\n");
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

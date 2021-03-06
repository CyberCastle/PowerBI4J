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
 * Connection string wrapper.
 */
@ApiModel(description = "Connection string wrapper.")
@JsonPropertyOrder({ ConnectionDetails.JSON_PROPERTY_CONNECTION_STRING })

public class ConnectionDetails {
    public static final String JSON_PROPERTY_CONNECTION_STRING = "connectionString";
    private String connectionString;

    public ConnectionDetails connectionString(String connectionString) {

        this.connectionString = connectionString;
        return this;
    }

    /**
     * A dataset connection string.
     * 
     * @return connectionString
     **/
    @ApiModelProperty(required = true, value = "A dataset connection string.")
    @JsonProperty(JSON_PROPERTY_CONNECTION_STRING)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public String getConnectionString() {
        return connectionString;
    }

    public void setConnectionString(String connectionString) {
        this.connectionString = connectionString;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ConnectionDetails connectionDetails = (ConnectionDetails) o;
        return Objects.equals(this.connectionString, connectionDetails.connectionString);
    }

    @Override
    public int hashCode() {
        return Objects.hash(connectionString);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ConnectionDetails {\n");
        sb.append("    connectionString: ").append(toIndentedString(connectionString)).append("\n");
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

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
 * Patch workload setting request
 */
@ApiModel(description = "Patch workload setting request")
@JsonPropertyOrder({ PatchWorkloadRequest.JSON_PROPERTY_STATE,
        PatchWorkloadRequest.JSON_PROPERTY_MAX_MEMORY_PERCENTAGE_SET_BY_USER })

public class PatchWorkloadRequest {
    public static final String JSON_PROPERTY_STATE = "state";
    private WorkloadState state;

    public static final String JSON_PROPERTY_MAX_MEMORY_PERCENTAGE_SET_BY_USER = "maxMemoryPercentageSetByUser";
    private Integer maxMemoryPercentageSetByUser;

    public PatchWorkloadRequest state(WorkloadState state) {

        this.state = state;
        return this;
    }

    /**
     * Get state
     * 
     * @return state
     **/
    @ApiModelProperty(required = true, value = "")
    @JsonProperty(JSON_PROPERTY_STATE)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public WorkloadState getState() {
        return state;
    }

    public void setState(WorkloadState state) {
        this.state = state;
    }

    public PatchWorkloadRequest maxMemoryPercentageSetByUser(Integer maxMemoryPercentageSetByUser) {

        this.maxMemoryPercentageSetByUser = maxMemoryPercentageSetByUser;
        return this;
    }

    /**
     * The memory percentage maximum Limit set by the user
     * 
     * @return maxMemoryPercentageSetByUser
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "The memory percentage maximum Limit set by the user")
    @JsonProperty(JSON_PROPERTY_MAX_MEMORY_PERCENTAGE_SET_BY_USER)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Integer getMaxMemoryPercentageSetByUser() {
        return maxMemoryPercentageSetByUser;
    }

    public void setMaxMemoryPercentageSetByUser(Integer maxMemoryPercentageSetByUser) {
        this.maxMemoryPercentageSetByUser = maxMemoryPercentageSetByUser;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PatchWorkloadRequest patchWorkloadRequest = (PatchWorkloadRequest) o;
        return Objects.equals(this.state, patchWorkloadRequest.state)
                && Objects.equals(this.maxMemoryPercentageSetByUser, patchWorkloadRequest.maxMemoryPercentageSetByUser);
    }

    @Override
    public int hashCode() {
        return Objects.hash(state, maxMemoryPercentageSetByUser);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class PatchWorkloadRequest {\n");
        sb.append("    state: ").append(toIndentedString(state)).append("\n");
        sb.append("    maxMemoryPercentageSetByUser: ").append(toIndentedString(maxMemoryPercentageSetByUser))
                .append("\n");
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
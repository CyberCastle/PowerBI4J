package cl.cc.powerbi.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Power BI Assign to Capacity Request
 *
 * @author CyberCastle
 */
public class AssignToCapacityRequest {

    @JsonProperty("capacityId")
    private String capacityId;

    public AssignToCapacityRequest capacityId(String capacityId) {
        this.capacityId = capacityId;
        return this;
    }

    /**
     * The capacity id
     *
     * @return capacityId
     *
     */
    public String getCapacityId() {
        return capacityId;
    }

    public void setCapacityId(String capacityId) {
        this.capacityId = capacityId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AssignToCapacityRequest assignToCapacityRequest = (AssignToCapacityRequest) o;
        return Objects.equals(this.capacityId, assignToCapacityRequest.capacityId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(capacityId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AssignToCapacityRequest {\n");

        sb.append("    capacityId: ").append(toIndentedString(capacityId)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

}

package cl.cc.powerbi.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Bind dataset to gateway request
 *
 * @author CyberCastle
 */
public class BindToGatewayRequest {

    @JsonProperty("gatewayObjectId")
    private String gatewayObjectId = null;

    public BindToGatewayRequest gatewayObjectId(String gatewayObjectId) {
        this.gatewayObjectId = gatewayObjectId;
        return this;
    }

    /**
     * The gateway id
     *
     * @return gatewayObjectId
     *
     */
    public String getGatewayObjectId() {
        return gatewayObjectId;
    }

    public void setGatewayObjectId(String gatewayObjectId) {
        this.gatewayObjectId = gatewayObjectId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BindToGatewayRequest bindToGatewayRequest = (BindToGatewayRequest) o;
        return Objects.equals(this.gatewayObjectId, bindToGatewayRequest.gatewayObjectId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gatewayObjectId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class BindToGatewayRequest {\n");

        sb.append("    gatewayObjectId: ").append(toIndentedString(gatewayObjectId)).append("\n");
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

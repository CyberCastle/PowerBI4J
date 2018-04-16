package cl.cc.powerbi.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * A Power BI Gateway
 *
 * @author CyberCastle
 */
public class Gateway {

    @JsonProperty("id")
    private String id = null;

    @JsonProperty("name")
    private String name = null;

    @JsonProperty("type")
    private String type = null;

    @JsonProperty("gatewayAnnotation")
    private String gatewayAnnotation = null;

    @JsonProperty("publicKey")
    private GatewayPublicKey publicKey = null;

    @JsonProperty("gatewayStatus")
    private String gatewayStatus = null;

    public Gateway id(String id) {
        this.id = id;
        return this;
    }

    /**
     * The gateway id
     *
     * @return id
     *
     */
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Gateway name(String name) {
        this.name = name;
        return this;
    }

    /**
     * The gateway name
     *
     * @return name
     *
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gateway type(String type) {
        this.type = type;
        return this;
    }

    /**
     * The gateway type
     *
     * @return type
     *
     */
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Gateway gatewayAnnotation(String gatewayAnnotation) {
        this.gatewayAnnotation = gatewayAnnotation;
        return this;
    }

    /**
     * The gateway annotation
     *
     * @return gatewayAnnotation
     *
     */
    public String getGatewayAnnotation() {
        return gatewayAnnotation;
    }

    public void setGatewayAnnotation(String gatewayAnnotation) {
        this.gatewayAnnotation = gatewayAnnotation;
    }

    public Gateway publicKey(GatewayPublicKey publicKey) {
        this.publicKey = publicKey;
        return this;
    }

    /**
     * The gateway public key
     *
     * @return publicKey
     *
     */
    public GatewayPublicKey getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(GatewayPublicKey publicKey) {
        this.publicKey = publicKey;
    }

    public Gateway gatewayStatus(String gatewayStatus) {
        this.gatewayStatus = gatewayStatus;
        return this;
    }

    /**
     * The gateway connectivity status
     *
     * @return gatewayStatus
     *
     */
    public String getGatewayStatus() {
        return gatewayStatus;
    }

    public void setGatewayStatus(String gatewayStatus) {
        this.gatewayStatus = gatewayStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Gateway gateway = (Gateway) o;
        return Objects.equals(this.id, gateway.id)
                && Objects.equals(this.name, gateway.name)
                && Objects.equals(this.type, gateway.type)
                && Objects.equals(this.gatewayAnnotation, gateway.gatewayAnnotation)
                && Objects.equals(this.publicKey, gateway.publicKey)
                && Objects.equals(this.gatewayStatus, gateway.gatewayStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, type, gatewayAnnotation, publicKey, gatewayStatus);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Gateway {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    gatewayAnnotation: ").append(toIndentedString(gatewayAnnotation)).append("\n");
        sb.append("    publicKey: ").append(toIndentedString(publicKey)).append("\n");
        sb.append("    gatewayStatus: ").append(toIndentedString(gatewayStatus)).append("\n");
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

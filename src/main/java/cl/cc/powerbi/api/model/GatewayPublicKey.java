package cl.cc.powerbi.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * A Power BI Gateway Public Key
 *
 * @author CyberCastle
 */
public class GatewayPublicKey {

    @JsonProperty("exponent")
    private String exponent = null;

    @JsonProperty("modulus")
    private String modulus = null;

    public GatewayPublicKey exponent(String exponent) {
        this.exponent = exponent;
        return this;
    }

    /**
     * The public key exponent
     *
     * @return exponent
     *
     */
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
     *
     */
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

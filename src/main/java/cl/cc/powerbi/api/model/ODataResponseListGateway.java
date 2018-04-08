package cl.cc.powerbi.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;

/**
 * Odata response wrapper for a Power BI Gateways list
 *
 * @author CyberCastle
 */
public class ODataResponseListGateway {

    @JsonProperty("odata.context")
    private String odataContext = null;

    @JsonProperty("value")
    private List<Gateway> value = null;

    public ODataResponseListGateway odataContext(String odataContext) {
        this.odataContext = odataContext;
        return this;
    }

    /**
     * Get odataContext
     *
     * @return odataContext
     *
     */
    public String getOdataContext() {
        return odataContext;
    }

    public void setOdataContext(String odataContext) {
        this.odataContext = odataContext;
    }

    public ODataResponseListGateway value(List<Gateway> value) {
        this.value = value;
        return this;
    }

    public ODataResponseListGateway addValueItem(Gateway valueItem) {
        if (this.value == null) {
            this.value = new ArrayList<>();
        }
        this.value.add(valueItem);
        return this;
    }

    /**
     * The Gateways
     *
     * @return value
     *
     */
    public List<Gateway> getValue() {
        return value;
    }

    public void setValue(List<Gateway> value) {
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
        ODataResponseListGateway odataResponseListGateway = (ODataResponseListGateway) o;
        return Objects.equals(this.odataContext, odataResponseListGateway.odataContext)
                && Objects.equals(this.value, odataResponseListGateway.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(odataContext, value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ODataResponseListGateway {\n");

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

package cl.cc.powerbi.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;

/**
 * Odata response wrapper for a Power BI Refresh history
 *
 * @author CyberCastle
 */
public class ODataResponseListRefresh {

    @JsonProperty("odata.context")
    private String odataContext = null;

    @JsonProperty("value")
    private List<Refresh> value = null;

    public ODataResponseListRefresh odataContext(String odataContext) {
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

    public ODataResponseListRefresh value(List<Refresh> value) {
        this.value = value;
        return this;
    }

    public ODataResponseListRefresh addValueItem(Refresh valueItem) {
        if (this.value == null) {
            this.value = new ArrayList<>();
        }
        this.value.add(valueItem);
        return this;
    }

    /**
     * The Refresh history list
     *
     * @return value
     *
     */
    public List<Refresh> getValue() {
        return value;
    }

    public void setValue(List<Refresh> value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ODataResponseListRefresh odataResponseListRefresh = (ODataResponseListRefresh) o;
        return Objects.equals(this.odataContext, odataResponseListRefresh.odataContext)
                && Objects.equals(this.value, odataResponseListRefresh.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(odataContext, value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ODataResponseListRefresh {\n");

        sb.append("    odataContext: ").append(toIndentedString(odataContext)).append("\n");
        sb.append("    value: ").append(toIndentedString(value)).append("\n");
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

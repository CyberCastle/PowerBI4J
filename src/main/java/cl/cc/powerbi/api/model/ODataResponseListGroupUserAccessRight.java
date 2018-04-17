package cl.cc.powerbi.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;

/**
 * Odata response wrapper for a Power BI user Access Right for group List
 *
 * @author CyberCastle
 */
public class ODataResponseListGroupUserAccessRight {

    @JsonProperty("odata.context")
    private String odataContext;

    @JsonProperty("value")
    private List<GroupUserAccessRight> value;

    public ODataResponseListGroupUserAccessRight odataContext(String odataContext) {
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

    public ODataResponseListGroupUserAccessRight value(List<GroupUserAccessRight> value) {
        this.value = value;
        return this;
    }

    public ODataResponseListGroupUserAccessRight addValueItem(GroupUserAccessRight valueItem) {
        if (this.value == null) {
            this.value = new ArrayList<>();
        }
        this.value.add(valueItem);
        return this;
    }

    /**
     * The user Access Right for group List
     *
     * @return value
     *
     */
    public List<GroupUserAccessRight> getValue() {
        return value;
    }

    public void setValue(List<GroupUserAccessRight> value) {
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
        ODataResponseListGroupUserAccessRight odataResponseListGroupUserAccessRight = (ODataResponseListGroupUserAccessRight) o;
        return Objects.equals(this.odataContext, odataResponseListGroupUserAccessRight.odataContext)
                && Objects.equals(this.value, odataResponseListGroupUserAccessRight.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(odataContext, value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ODataResponseListGroupUserAccessRight {\n");

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

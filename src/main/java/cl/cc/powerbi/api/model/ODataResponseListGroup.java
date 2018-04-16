package cl.cc.powerbi.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;

/**
 * Odata response wrapper for a Power BI Group list
 *
 * @author CyberCastle
 */
public class ODataResponseListGroup {

    @JsonProperty("odata.context")
    private String odataContext = null;

    @JsonProperty("value")
    private List<Group> value = null;

    public ODataResponseListGroup odataContext(String odataContext) {
        this.odataContext = odataContext;
        return this;
    }

    /**
     * OData context
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

    public ODataResponseListGroup value(List<Group> value) {
        this.value = value;
        return this;
    }

    public ODataResponseListGroup addValueItem(Group valueItem) {
        if (this.value == null) {
            this.value = new ArrayList<>();
        }
        this.value.add(valueItem);
        return this;
    }

    /**
     * The groups
     *
     * @return value
     *
     */
    public List<Group> getValue() {
        return value;
    }

    public void setValue(List<Group> value) {
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
        ODataResponseListGroup odataResponseListGroup = (ODataResponseListGroup) o;
        return Objects.equals(this.odataContext, odataResponseListGroup.odataContext)
                && Objects.equals(this.value, odataResponseListGroup.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(odataContext, value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ODataResponseListGroup {\n");

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

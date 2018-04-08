package cl.cc.powerbi.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;

/**
 * Odata response wrapper for a Power BI dataset parameter list
 *
 * @author CyberCastle
 */
public class ODataResponseListDatasetParameter {

    @JsonProperty("odata.context")
    private String odataContext = null;

    @JsonProperty("value")
    private List<DatasetParameter> value = null;

    public ODataResponseListDatasetParameter odataContext(String odataContext) {
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

    public ODataResponseListDatasetParameter value(List<DatasetParameter> value) {
        this.value = value;
        return this;
    }

    public ODataResponseListDatasetParameter addValueItem(DatasetParameter valueItem) {
        if (this.value == null) {
            this.value = new ArrayList<>();
        }
        this.value.add(valueItem);
        return this;
    }

    /**
     * The dataset parameter List
     *
     * @return value
     *
     */
    public List<DatasetParameter> getValue() {
        return value;
    }

    public void setValue(List<DatasetParameter> value) {
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
        ODataResponseListDatasetParameter odataResponseListDatasetParameter = (ODataResponseListDatasetParameter) o;
        return Objects.equals(this.odataContext, odataResponseListDatasetParameter.odataContext)
                && Objects.equals(this.value, odataResponseListDatasetParameter.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(odataContext, value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ODataResponseListDatasetParameter {\n");

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

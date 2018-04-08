package cl.cc.powerbi.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;

/**
 * Odata response wrapper for a Power BI datasource collection
 *
 * @author CyberCastle
 */
public class ODataResponseListDatasource {

    @JsonProperty("odata.context")
    private String odataContext = null;

    @JsonProperty("value")
    private List<Datasource> value = null;

    public ODataResponseListDatasource odataContext(String odataContext) {
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

    public ODataResponseListDatasource value(List<Datasource> value) {
        this.value = value;
        return this;
    }

    public ODataResponseListDatasource addValueItem(Datasource valueItem) {
        if (this.value == null) {
            this.value = new ArrayList<>();
        }
        this.value.add(valueItem);
        return this;
    }

    /**
     * The datasource collection
     *
     * @return value
     *
     */
    public List<Datasource> getValue() {
        return value;
    }

    public void setValue(List<Datasource> value) {
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
        ODataResponseListDatasource odataResponseListDatasource = (ODataResponseListDatasource) o;
        return Objects.equals(this.odataContext, odataResponseListDatasource.odataContext)
                && Objects.equals(this.value, odataResponseListDatasource.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(odataContext, value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ODataResponseListDatasource {\n");

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

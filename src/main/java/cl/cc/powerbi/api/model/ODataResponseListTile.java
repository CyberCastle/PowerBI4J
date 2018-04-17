package cl.cc.powerbi.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;

/**
 * Odata response wrapper for a Power BI Tile collection
 *
 * @author CyberCastle
 */
public class ODataResponseListTile {

    @JsonProperty("odata.context")
    private String odataContext;

    @JsonProperty("value")
    private List<Tile> value;

    public ODataResponseListTile odataContext(String odataContext) {
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

    public ODataResponseListTile value(List<Tile> value) {
        this.value = value;
        return this;
    }

    public ODataResponseListTile addValueItem(Tile valueItem) {
        if (this.value == null) {
            this.value = new ArrayList<>();
        }
        this.value.add(valueItem);
        return this;
    }

    /**
     * The tile collection
     *
     * @return value
     *
     */
    public List<Tile> getValue() {
        return value;
    }

    public void setValue(List<Tile> value) {
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
        ODataResponseListTile odataResponseListTile = (ODataResponseListTile) o;
        return Objects.equals(this.odataContext, odataResponseListTile.odataContext)
                && Objects.equals(this.value, odataResponseListTile.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(odataContext, value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ODataResponseListTile {\n");

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

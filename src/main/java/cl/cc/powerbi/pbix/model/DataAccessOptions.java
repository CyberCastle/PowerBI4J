
package cl.cc.powerbi.pbix.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "legacyRedirects", "returnErrorValuesAsNull" })
public class DataAccessOptions implements Serializable {

    @JsonProperty("legacyRedirects")
    private Boolean legacyRedirects;
    @JsonProperty("returnErrorValuesAsNull")
    private Boolean returnErrorValuesAsNull;
    private final static long serialVersionUID = 1216613574008942092L;

    @JsonProperty("legacyRedirects")
    public Boolean getLegacyRedirects() {
        return legacyRedirects;
    }

    @JsonProperty("legacyRedirects")
    public void setLegacyRedirects(Boolean legacyRedirects) {
        this.legacyRedirects = legacyRedirects;
    }

    @JsonProperty("returnErrorValuesAsNull")
    public Boolean getReturnErrorValuesAsNull() {
        return returnErrorValuesAsNull;
    }

    @JsonProperty("returnErrorValuesAsNull")
    public void setReturnErrorValuesAsNull(Boolean returnErrorValuesAsNull) {
        this.returnErrorValuesAsNull = returnErrorValuesAsNull;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(DataAccessOptions.class.getName()).append('@')
                .append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("legacyRedirects");
        sb.append('=');
        sb.append(((this.legacyRedirects == null) ? "<null>" : this.legacyRedirects));
        sb.append(',');
        sb.append("returnErrorValuesAsNull");
        sb.append('=');
        sb.append(((this.returnErrorValuesAsNull == null) ? "<null>" : this.returnErrorValuesAsNull));
        sb.append(',');
        if (sb.charAt((sb.length() - 1)) == ',') {
            sb.setCharAt((sb.length() - 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result * 31)
                + ((this.returnErrorValuesAsNull == null) ? 0 : this.returnErrorValuesAsNull.hashCode()));
        result = ((result * 31) + ((this.legacyRedirects == null) ? 0 : this.legacyRedirects.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof DataAccessOptions) == false) {
            return false;
        }
        DataAccessOptions rhs = ((DataAccessOptions) other);
        return (((this.returnErrorValuesAsNull == rhs.returnErrorValuesAsNull)
                || ((this.returnErrorValuesAsNull != null)
                        && this.returnErrorValuesAsNull.equals(rhs.returnErrorValuesAsNull)))
                && ((this.legacyRedirects == rhs.legacyRedirects)
                        || ((this.legacyRedirects != null) && this.legacyRedirects.equals(rhs.legacyRedirects))));
    }

}

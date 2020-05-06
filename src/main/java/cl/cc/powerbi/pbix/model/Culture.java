
package cl.cc.powerbi.pbix.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "name", "linguisticMetadata" })
public class Culture implements Serializable {

    @JsonProperty("name")
    private String name;
    @JsonProperty("linguisticMetadata")
    private LinguisticMetadata linguisticMetadata;
    private final static long serialVersionUID = 1258032343278945091L;

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("linguisticMetadata")
    public LinguisticMetadata getLinguisticMetadata() {
        return linguisticMetadata;
    }

    @JsonProperty("linguisticMetadata")
    public void setLinguisticMetadata(LinguisticMetadata linguisticMetadata) {
        this.linguisticMetadata = linguisticMetadata;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Culture.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)))
                .append('[');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null) ? "<null>" : this.name));
        sb.append(',');
        sb.append("linguisticMetadata");
        sb.append('=');
        sb.append(((this.linguisticMetadata == null) ? "<null>" : this.linguisticMetadata));
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
        result = ((result * 31) + ((this.name == null) ? 0 : this.name.hashCode()));
        result = ((result * 31) + ((this.linguisticMetadata == null) ? 0 : this.linguisticMetadata.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Culture) == false) {
            return false;
        }
        Culture rhs = ((Culture) other);
        return (((this.name == rhs.name) || ((this.name != null) && this.name.equals(rhs.name)))
                && ((this.linguisticMetadata == rhs.linguisticMetadata) || ((this.linguisticMetadata != null)
                        && this.linguisticMetadata.equals(rhs.linguisticMetadata))));
    }

}


package cl.cc.powerbi.datamodel;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "Version", "Language", "DynamicImprovement" })
public class Content implements Serializable {

    @JsonProperty("Version")
    private String version;
    @JsonProperty("Language")
    private String language;
    @JsonProperty("DynamicImprovement")
    private String dynamicImprovement;
    private final static long serialVersionUID = 1146185067182105036L;

    @JsonProperty("Version")
    public String getVersion() {
        return version;
    }

    @JsonProperty("Version")
    public void setVersion(String version) {
        this.version = version;
    }

    @JsonProperty("Language")
    public String getLanguage() {
        return language;
    }

    @JsonProperty("Language")
    public void setLanguage(String language) {
        this.language = language;
    }

    @JsonProperty("DynamicImprovement")
    public String getDynamicImprovement() {
        return dynamicImprovement;
    }

    @JsonProperty("DynamicImprovement")
    public void setDynamicImprovement(String dynamicImprovement) {
        this.dynamicImprovement = dynamicImprovement;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Content.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)))
                .append('[');
        sb.append("version");
        sb.append('=');
        sb.append(((this.version == null) ? "<null>" : this.version));
        sb.append(',');
        sb.append("language");
        sb.append('=');
        sb.append(((this.language == null) ? "<null>" : this.language));
        sb.append(',');
        sb.append("dynamicImprovement");
        sb.append('=');
        sb.append(((this.dynamicImprovement == null) ? "<null>" : this.dynamicImprovement));
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
        result = ((result * 31) + ((this.language == null) ? 0 : this.language.hashCode()));
        result = ((result * 31) + ((this.version == null) ? 0 : this.version.hashCode()));
        result = ((result * 31) + ((this.dynamicImprovement == null) ? 0 : this.dynamicImprovement.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Content) == false) {
            return false;
        }
        Content rhs = ((Content) other);
        return ((((this.language == rhs.language) || ((this.language != null) && this.language.equals(rhs.language)))
                && ((this.version == rhs.version) || ((this.version != null) && this.version.equals(rhs.version))))
                && ((this.dynamicImprovement == rhs.dynamicImprovement) || ((this.dynamicImprovement != null)
                        && this.dynamicImprovement.equals(rhs.dynamicImprovement))));
    }

}


package cl.cc.powerbi.datamodel;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "content", "contentType" })
public class LinguisticMetadata implements Serializable {

    @JsonProperty("content")
    private Content content;
    @JsonProperty("contentType")
    private String contentType;
    private final static long serialVersionUID = 6921875478527201801L;

    @JsonProperty("content")
    public Content getContent() {
        return content;
    }

    @JsonProperty("content")
    public void setContent(Content content) {
        this.content = content;
    }

    @JsonProperty("contentType")
    public String getContentType() {
        return contentType;
    }

    @JsonProperty("contentType")
    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(LinguisticMetadata.class.getName()).append('@')
                .append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("content");
        sb.append('=');
        sb.append(((this.content == null) ? "<null>" : this.content));
        sb.append(',');
        sb.append("contentType");
        sb.append('=');
        sb.append(((this.contentType == null) ? "<null>" : this.contentType));
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
        result = ((result * 31) + ((this.contentType == null) ? 0 : this.contentType.hashCode()));
        result = ((result * 31) + ((this.content == null) ? 0 : this.content.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof LinguisticMetadata) == false) {
            return false;
        }
        LinguisticMetadata rhs = ((LinguisticMetadata) other);
        return (((this.contentType == rhs.contentType)
                || ((this.contentType != null) && this.contentType.equals(rhs.contentType)))
                && ((this.content == rhs.content) || ((this.content != null) && this.content.equals(rhs.content))));
    }

}

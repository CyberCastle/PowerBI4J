package cl.cc.powerbi.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.OffsetDateTime;

/**
 * Power BI Embed Token
 *
 * @author CyberCastle
 */
public class EmbedToken {

    @JsonProperty("token")
    private String token = null;

    @JsonProperty("tokenId")
    private String tokenId = null;

    @JsonProperty("expiration")
    private OffsetDateTime expiration = null;

    public EmbedToken token(String token) {
        this.token = token;
        return this;
    }

    /**
     * Embed token.
     *
     * @return token
     *
     */
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public EmbedToken tokenId(String tokenId) {
        this.tokenId = tokenId;
        return this;
    }

    /**
     * Unique token Id.
     *
     * @return tokenId
     *
     */
    public String getTokenId() {
        return tokenId;
    }

    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }

    public EmbedToken expiration(OffsetDateTime expiration) {
        this.expiration = expiration;
        return this;
    }

    /**
     * Expiration time of token - in UTC.
     *
     * @return expiration
     *
     */
    public OffsetDateTime getExpiration() {
        return expiration;
    }

    public void setExpiration(OffsetDateTime expiration) {
        this.expiration = expiration;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EmbedToken embedToken = (EmbedToken) o;
        return Objects.equals(this.token, embedToken.token)
                && Objects.equals(this.tokenId, embedToken.tokenId)
                && Objects.equals(this.expiration, embedToken.expiration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(token, tokenId, expiration);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EmbedToken {\n");

        sb.append("    token: ").append(toIndentedString(token)).append("\n");
        sb.append("    tokenId: ").append(toIndentedString(tokenId)).append("\n");
        sb.append("    expiration: ").append(toIndentedString(expiration)).append("\n");
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

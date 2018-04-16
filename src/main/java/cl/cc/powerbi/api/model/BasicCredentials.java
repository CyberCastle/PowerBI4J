package cl.cc.powerbi.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Object representing basic authentication credentials
 *
 * @author CyberCastle
 */
public class BasicCredentials {

    @JsonProperty("username")
    private String username = null;

    @JsonProperty("password")
    private String password = null;

    public BasicCredentials username(String username) {
        this.username = username;
        return this;
    }

    /**
     * Username required to access the datasource
     *
     * @return username
     *
     */
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public BasicCredentials password(String password) {
        this.password = password;
        return this;
    }

    /**
     * Password required to access the datasource
     *
     * @return password
     *
     */
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BasicCredentials basicCredentials = (BasicCredentials) o;
        return Objects.equals(this.username, basicCredentials.username)
                && Objects.equals(this.password, basicCredentials.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class BasicCredentials {\n");

        sb.append("    username: ").append(toIndentedString(username)).append("\n");
        sb.append("    password: ").append(toIndentedString(password)).append("\n");
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

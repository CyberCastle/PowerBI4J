package cl.cc.powerbi.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * A Power BI user details in a group
 *
 * @author CyberCastle
 */
public class GroupUser {

    /**
     * Type of user in a group.
     */
    public enum UserTypeEnum {
        NONE("None"),
        MEMBER("Member"),
        ADMIN("Admin");

        private final String value;

        UserTypeEnum(String value) {
            this.value = value;
        }

        @JsonValue
        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        @JsonCreator
        public static UserTypeEnum fromValue(String text) {
            for (UserTypeEnum b : UserTypeEnum.values()) {
                if (String.valueOf(b.value).equals(text)) {
                    return b;
                }
            }
            return null;
        }
    }

    @JsonProperty("userType")
    private UserTypeEnum userType;

    @JsonProperty("emailAddress")
    private String emailAddress;

    public GroupUser userType(UserTypeEnum userType) {
        this.userType = userType;
        return this;
    }

    /**
     * Type of user in a group.
     *
     * @return userType
     *
     */
    public UserTypeEnum getUserType() {
        return userType;
    }

    public void setUserType(UserTypeEnum userType) {
        this.userType = userType;
    }

    public GroupUser emailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
        return this;
    }

    /**
     * Email address of the user.
     *
     * @return emailAddress
     *
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GroupUser groupUser = (GroupUser) o;
        return Objects.equals(this.userType, groupUser.userType)
                && Objects.equals(this.emailAddress, groupUser.emailAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userType, emailAddress);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class GroupUser {\n");

        sb.append("    userType: ").append(toIndentedString(userType)).append("\n");
        sb.append("    emailAddress: ").append(toIndentedString(emailAddress)).append("\n");
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

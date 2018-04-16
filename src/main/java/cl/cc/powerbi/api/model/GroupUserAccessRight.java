package cl.cc.powerbi.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * A Power BI user Access Right entry for group
 *
 * @author CyberCastle
 */
public class GroupUserAccessRight {

    /**
     * Access rights user has for group
     */
    public enum GroupUserAccessRightEnum {
        NONE("None"),
        MEMBER("Member"),
        ADMIN("Admin");

        private final String value;

        GroupUserAccessRightEnum(String value) {
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
        public static GroupUserAccessRightEnum fromValue(String text) {
            for (GroupUserAccessRightEnum b : GroupUserAccessRightEnum.values()) {
                if (String.valueOf(b.value).equals(text)) {
                    return b;
                }
            }
            return null;
        }
    }

    @JsonProperty("groupUserAccessRight")
    private GroupUserAccessRightEnum groupUserAccessRight = null;

    @JsonProperty("emailAddress")
    private String emailAddress = null;

    public GroupUserAccessRight groupUserAccessRight(GroupUserAccessRightEnum groupUserAccessRight) {
        this.groupUserAccessRight = groupUserAccessRight;
        return this;
    }

    /**
     * Access rights user has for group
     *
     * @return groupUserAccessRight
     *
     */
    public GroupUserAccessRightEnum getGroupUserAccessRight() {
        return groupUserAccessRight;
    }

    public void setGroupUserAccessRight(GroupUserAccessRightEnum groupUserAccessRight) {
        this.groupUserAccessRight = groupUserAccessRight;
    }

    public GroupUserAccessRight emailAddress(String emailAddress) {
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
        GroupUserAccessRight groupUserAccessRight = (GroupUserAccessRight) o;
        return Objects.equals(this.groupUserAccessRight, groupUserAccessRight.groupUserAccessRight)
                && Objects.equals(this.emailAddress, groupUserAccessRight.emailAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupUserAccessRight, emailAddress);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class GroupUserAccessRight {\n");

        sb.append("    groupUserAccessRight: ").append(toIndentedString(groupUserAccessRight)).append("\n");
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

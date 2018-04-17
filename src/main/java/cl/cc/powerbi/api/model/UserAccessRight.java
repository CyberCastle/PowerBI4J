package cl.cc.powerbi.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * A Power BI user Access Right entry for datasource
 *
 * @author CyberCastle
 */
public class UserAccessRight {

    /**
     * Access rights user has for datasource
     */
    public enum DatasourceAccessRightEnum {
        NONE("None"),
        READ("Read"),
        WRITE("Write"),
        ADMIN("Admin"),
        READWRITE("ReadWrite");

        private final String value;

        DatasourceAccessRightEnum(String value) {
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
        public static DatasourceAccessRightEnum fromValue(String text) {
            for (DatasourceAccessRightEnum b : DatasourceAccessRightEnum.values()) {
                if (String.valueOf(b.value).equals(text)) {
                    return b;
                }
            }
            return null;
        }
    }

    @JsonProperty("datasourceAccessRight")
    private DatasourceAccessRightEnum datasourceAccessRight;

    @JsonProperty("emailAddress")
    private String emailAddress;

    public UserAccessRight datasourceAccessRight(DatasourceAccessRightEnum datasourceAccessRight) {
        this.datasourceAccessRight = datasourceAccessRight;
        return this;
    }

    /**
     * Access rights user has for datasource
     *
     * @return datasourceAccessRight
     *
     */
    public DatasourceAccessRightEnum getDatasourceAccessRight() {
        return datasourceAccessRight;
    }

    public void setDatasourceAccessRight(DatasourceAccessRightEnum datasourceAccessRight) {
        this.datasourceAccessRight = datasourceAccessRight;
    }

    public UserAccessRight emailAddress(String emailAddress) {
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
        UserAccessRight userAccessRight = (UserAccessRight) o;
        return Objects.equals(this.datasourceAccessRight, userAccessRight.datasourceAccessRight)
                && Objects.equals(this.emailAddress, userAccessRight.emailAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(datasourceAccessRight, emailAddress);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class UserAccessRight {\n");

        sb.append("    datasourceAccessRight: ").append(toIndentedString(datasourceAccessRight)).append("\n");
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

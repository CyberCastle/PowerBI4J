/*
 * Power BI Client
 * No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
 *
 * The version of the OpenAPI document: v1.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package cl.cc.powerbi.client.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Encryption information for a dataset
 */
@ApiModel(description = "Encryption information for a dataset")
@JsonPropertyOrder({ Encryption.JSON_PROPERTY_ENCRYPTION_STATUS })

public class Encryption {
    /**
     * Dataset encryption status
     */
    public enum EncryptionStatusEnum {
        UNKNOWN("Unknown"),

        NOTSUPPORTED("NotSupported"),

        INSYNCWITHWORKSPACE("InSyncWithWorkspace"),

        NOTINSYNCWITHWORKSPACE("NotInSyncWithWorkspace");

        private String value;

        EncryptionStatusEnum(String value) {
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
        public static EncryptionStatusEnum fromValue(String value) {
            for (EncryptionStatusEnum b : EncryptionStatusEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }

    public static final String JSON_PROPERTY_ENCRYPTION_STATUS = "EncryptionStatus";
    private EncryptionStatusEnum encryptionStatus;

    public Encryption encryptionStatus(EncryptionStatusEnum encryptionStatus) {

        this.encryptionStatus = encryptionStatus;
        return this;
    }

    /**
     * Dataset encryption status
     * 
     * @return encryptionStatus
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "Dataset encryption status")
    @JsonProperty(JSON_PROPERTY_ENCRYPTION_STATUS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public EncryptionStatusEnum getEncryptionStatus() {
        return encryptionStatus;
    }

    public void setEncryptionStatus(EncryptionStatusEnum encryptionStatus) {
        this.encryptionStatus = encryptionStatus;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Encryption encryption = (Encryption) o;
        return Objects.equals(this.encryptionStatus, encryption.encryptionStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(encryptionStatus);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Encryption {\n");
        sb.append("    encryptionStatus: ").append(toIndentedString(encryptionStatus)).append("\n");
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
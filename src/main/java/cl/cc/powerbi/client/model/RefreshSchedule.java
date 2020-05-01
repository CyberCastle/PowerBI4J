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

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * A Power BI refresh schedule for cached model
 */
@ApiModel(description = "A Power BI refresh schedule for cached model")
@JsonPropertyOrder({ RefreshSchedule.JSON_PROPERTY_DAYS, RefreshSchedule.JSON_PROPERTY_TIMES,
        RefreshSchedule.JSON_PROPERTY_ENABLED, RefreshSchedule.JSON_PROPERTY_LOCAL_TIME_ZONE_ID,
        RefreshSchedule.JSON_PROPERTY_NOTIFY_OPTION })

public class RefreshSchedule {
    /**
     * Days of week
     */
    public enum DaysEnum {
        MONDAY("Monday"),

        TUESDAY("Tuesday"),

        WEDNESDAY("Wednesday"),

        THURSDAY("Thursday"),

        FRIDAY("Friday"),

        SATURDAY("Saturday"),

        SUNDAY("Sunday");

        private String value;

        DaysEnum(String value) {
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
        public static DaysEnum fromValue(String value) {
            for (DaysEnum b : DaysEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }

    public static final String JSON_PROPERTY_DAYS = "days";
    private List<DaysEnum> days = null;

    public static final String JSON_PROPERTY_TIMES = "times";
    private List<String> times = null;

    public static final String JSON_PROPERTY_ENABLED = "enabled";
    private Boolean enabled;

    public static final String JSON_PROPERTY_LOCAL_TIME_ZONE_ID = "localTimeZoneId";
    private String localTimeZoneId;

    /**
     * Notification option at scheduled refresh termination
     */
    public enum NotifyOptionEnum {
        NONOTIFICATION("NoNotification"),

        MAILONFAILURE("MailOnFailure");

        private String value;

        NotifyOptionEnum(String value) {
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
        public static NotifyOptionEnum fromValue(String value) {
            for (NotifyOptionEnum b : NotifyOptionEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }

    public static final String JSON_PROPERTY_NOTIFY_OPTION = "NotifyOption";
    private NotifyOptionEnum notifyOption;

    public RefreshSchedule days(List<DaysEnum> days) {

        this.days = days;
        return this;
    }

    public RefreshSchedule addDaysItem(DaysEnum daysItem) {
        if (this.days == null) {
            this.days = new ArrayList<>();
        }
        this.days.add(daysItem);
        return this;
    }

    /**
     * Days to execute the refresh
     * 
     * @return days
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "Days to execute the refresh")
    @JsonProperty(JSON_PROPERTY_DAYS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<DaysEnum> getDays() {
        return days;
    }

    public void setDays(List<DaysEnum> days) {
        this.days = days;
    }

    public RefreshSchedule times(List<String> times) {

        this.times = times;
        return this;
    }

    public RefreshSchedule addTimesItem(String timesItem) {
        if (this.times == null) {
            this.times = new ArrayList<>();
        }
        this.times.add(timesItem);
        return this;
    }

    /**
     * Times to execute the refresh within each day
     * 
     * @return times
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "Times to execute the refresh within each day")
    @JsonProperty(JSON_PROPERTY_TIMES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<String> getTimes() {
        return times;
    }

    public void setTimes(List<String> times) {
        this.times = times;
    }

    public RefreshSchedule enabled(Boolean enabled) {

        this.enabled = enabled;
        return this;
    }

    /**
     * Is the refresh enabled
     * 
     * @return enabled
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "Is the refresh enabled")
    @JsonProperty(JSON_PROPERTY_ENABLED)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public RefreshSchedule localTimeZoneId(String localTimeZoneId) {

        this.localTimeZoneId = localTimeZoneId;
        return this;
    }

    /**
     * The Id of the Time zone to use. See **Name of Time Zone** column in
     * [Microsoft Time Zone Index
     * Values.](https://support.microsoft.com/help/973627/microsoft-time-zone-index-values)
     * 
     * @return localTimeZoneId
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "The Id of the Time zone to use. See **Name of Time Zone** column in [Microsoft Time Zone Index Values.](https://support.microsoft.com/help/973627/microsoft-time-zone-index-values)")
    @JsonProperty(JSON_PROPERTY_LOCAL_TIME_ZONE_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getLocalTimeZoneId() {
        return localTimeZoneId;
    }

    public void setLocalTimeZoneId(String localTimeZoneId) {
        this.localTimeZoneId = localTimeZoneId;
    }

    public RefreshSchedule notifyOption(NotifyOptionEnum notifyOption) {

        this.notifyOption = notifyOption;
        return this;
    }

    /**
     * Notification option at scheduled refresh termination
     * 
     * @return notifyOption
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "Notification option at scheduled refresh termination")
    @JsonProperty(JSON_PROPERTY_NOTIFY_OPTION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public NotifyOptionEnum getNotifyOption() {
        return notifyOption;
    }

    public void setNotifyOption(NotifyOptionEnum notifyOption) {
        this.notifyOption = notifyOption;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RefreshSchedule refreshSchedule = (RefreshSchedule) o;
        return Objects.equals(this.days, refreshSchedule.days) && Objects.equals(this.times, refreshSchedule.times)
                && Objects.equals(this.enabled, refreshSchedule.enabled)
                && Objects.equals(this.localTimeZoneId, refreshSchedule.localTimeZoneId)
                && Objects.equals(this.notifyOption, refreshSchedule.notifyOption);
    }

    @Override
    public int hashCode() {
        return Objects.hash(days, times, enabled, localTimeZoneId, notifyOption);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RefreshSchedule {\n");
        sb.append("    days: ").append(toIndentedString(days)).append("\n");
        sb.append("    times: ").append(toIndentedString(times)).append("\n");
        sb.append("    enabled: ").append(toIndentedString(enabled)).append("\n");
        sb.append("    localTimeZoneId: ").append(toIndentedString(localTimeZoneId)).append("\n");
        sb.append("    notifyOption: ").append(toIndentedString(notifyOption)).append("\n");
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

package cl.cc.powerbi.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Power BI dataset parameter
 *
 * @author CyberCastle
 */
public class DatasetParameter {

    @JsonProperty("name")
    private String name = null;

    @JsonProperty("type")
    private String type = null;

    @JsonProperty("currentValue")
    private String currentValue = null;

    @JsonProperty("isRequired")
    private Boolean isRequired = null;

    public DatasetParameter name(String name) {
        this.name = name;
        return this;
    }

    /**
     * The parameter name
     *
     * @return name
     *
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DatasetParameter type(String type) {
        this.type = type;
        return this;
    }

    /**
     * The parameter type
     *
     * @return type
     *
     */
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public DatasetParameter currentValue(String currentValue) {
        this.currentValue = currentValue;
        return this;
    }

    /**
     * The parameter current value
     *
     * @return currentValue
     *
     */
    public String getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(String currentValue) {
        this.currentValue = currentValue;
    }

    public DatasetParameter isRequired(Boolean isRequired) {
        this.isRequired = isRequired;
        return this;
    }

    /**
     * Is dataset parameter required
     *
     * @return isRequired
     *
     */
    public Boolean isIsRequired() {
        return isRequired;
    }

    public void setIsRequired(Boolean isRequired) {
        this.isRequired = isRequired;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DatasetParameter datasetParameter = (DatasetParameter) o;
        return Objects.equals(this.name, datasetParameter.name)
                && Objects.equals(this.type, datasetParameter.type)
                && Objects.equals(this.currentValue, datasetParameter.currentValue)
                && Objects.equals(this.isRequired, datasetParameter.isRequired);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type, currentValue, isRequired);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DatasetParameter {\n");

        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    currentValue: ").append(toIndentedString(currentValue)).append("\n");
        sb.append("    isRequired: ").append(toIndentedString(isRequired)).append("\n");
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

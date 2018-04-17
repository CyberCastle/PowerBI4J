package cl.cc.powerbi.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Power BI dataset parameter update details
 *
 * @author CyberCastle
 */
public class UpdateDatasetParameterDetails {

    @JsonProperty("name")
    private String name;

    @JsonProperty("newValue")
    private String newValue;

    public UpdateDatasetParameterDetails name(String name) {
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

    public UpdateDatasetParameterDetails newValue(String newValue) {
        this.newValue = newValue;
        return this;
    }

    /**
     * The parameter new value
     *
     * @return newValue
     *
     */
    public String getNewValue() {
        return newValue;
    }

    public void setNewValue(String newValue) {
        this.newValue = newValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UpdateDatasetParameterDetails updateDatasetParameterDetails = (UpdateDatasetParameterDetails) o;
        return Objects.equals(this.name, updateDatasetParameterDetails.name)
                && Objects.equals(this.newValue, updateDatasetParameterDetails.newValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, newValue);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class UpdateDatasetParameterDetails {\n");

        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    newValue: ").append(toIndentedString(newValue)).append("\n");
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

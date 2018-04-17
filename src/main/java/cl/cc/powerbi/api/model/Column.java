package cl.cc.powerbi.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * A Power BI Column
 *
 * @author CyberCastle
 */
@JsonPropertyOrder({
    "name",
    "dataType"
})
public class Column {

    @JsonProperty("name")
    private String name;

    @JsonProperty("dataType")
    private DataType dataType;

    public enum DataType {
        INT64("Int64"),
        DOUBLE("Double"),
        BOOLEAN("Boolean"),
        DATETIME("Datetime"),
        STRING("String");

        private final String value;

        DataType(String value) {
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
        public static DataType fromValue(String text) {
            for (DataType b : DataType.values()) {
                if (String.valueOf(b.value).equalsIgnoreCase(text)) {
                    return b;
                }
            }
            return null;
        }
    }

    public Column() {

    }

    public Column(String name, DataType dataType) {
        this.name = name;
        this.dataType = dataType;
    }

    public Column name(String name) {
        this.name = name;
        return this;
    }

    /**
     * The column name
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

    public Column dataType(DataType dataType) {
        this.dataType = dataType;
        return this;
    }

    /**
     * The column data type
     *
     * @return dataType
     *
     */
    public DataType getDataType() {
        return dataType;
    }

    public void setDataType(DataType dataType) {
        this.dataType = dataType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Column column = (Column) o;
        return Objects.equals(this.name, column.name)
                && Objects.equals(this.dataType, column.dataType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, dataType);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Column {\n");

        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    dataType: ").append(toIndentedString(dataType)).append("\n");
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

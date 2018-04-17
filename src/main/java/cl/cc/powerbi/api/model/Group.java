package cl.cc.powerbi.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * A Power BI Group
 *
 * @author CyberCastle
 */
public class Group {

    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("isReadOnly")
    private Boolean isReadOnly;

    @JsonProperty("isOnDedicatedCapacity")
    private Boolean isOnDedicatedCapacity;

    @JsonProperty("capacityId")
    private String capacityId;

    public Group id(String id) {
        this.id = id;
        return this;
    }

    /**
     * The group id
     *
     * @return id
     *
     */
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Group name(String name) {
        this.name = name;
        return this;
    }

    /**
     * The group name
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

    public Group isReadOnly(Boolean isReadOnly) {
        this.isReadOnly = isReadOnly;
        return this;
    }

    /**
     * Is ReadOnly group
     *
     * @return isReadOnly
     *
     */
    public Boolean isIsReadOnly() {
        return isReadOnly;
    }

    public void setIsReadOnly(Boolean isReadOnly) {
        this.isReadOnly = isReadOnly;
    }

    public Group isOnDedicatedCapacity(Boolean isOnDedicatedCapacity) {
        this.isOnDedicatedCapacity = isOnDedicatedCapacity;
        return this;
    }

    /**
     * Is group on dedicated capacity
     *
     * @return isOnDedicatedCapacity
     *
     */
    public Boolean isIsOnDedicatedCapacity() {
        return isOnDedicatedCapacity;
    }

    public void setIsOnDedicatedCapacity(Boolean isOnDedicatedCapacity) {
        this.isOnDedicatedCapacity = isOnDedicatedCapacity;
    }

    public Group capacityId(String capacityId) {
        this.capacityId = capacityId;
        return this;
    }

    /**
     * The capacity id
     *
     * @return capacityId
     *
     */
    public String getCapacityId() {
        return capacityId;
    }

    public void setCapacityId(String capacityId) {
        this.capacityId = capacityId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Group group = (Group) o;
        return Objects.equals(this.id, group.id)
                && Objects.equals(this.name, group.name)
                && Objects.equals(this.isReadOnly, group.isReadOnly)
                && Objects.equals(this.isOnDedicatedCapacity, group.isOnDedicatedCapacity)
                && Objects.equals(this.capacityId, group.capacityId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, isReadOnly, isOnDedicatedCapacity, capacityId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Group {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    isReadOnly: ").append(toIndentedString(isReadOnly)).append("\n");
        sb.append("    isOnDedicatedCapacity: ").append(toIndentedString(isOnDedicatedCapacity)).append("\n");
        sb.append("    capacityId: ").append(toIndentedString(capacityId)).append("\n");
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

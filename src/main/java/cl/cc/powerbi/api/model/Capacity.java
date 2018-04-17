package cl.cc.powerbi.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.ArrayList;
import java.util.List;

/**
 * A Power BI capacity
 *
 * @author CyberCastle
 */
public class Capacity {

    @JsonProperty("id")
    private String id;

    @JsonProperty("displayName")
    private String displayName;

    @JsonProperty("admins")
    private List<String> admins;

    @JsonProperty("sku")
    private String sku;

    /**
     * The capacity state
     */
    public enum StateEnum {
        NOTACTIVATED("NotActivated"),
        ACTIVE("Active"),
        PROVISIONING("Provisioning"),
        PROVISIONFAILED("ProvisionFailed"),
        PRESUSPENDED("PreSuspended"),
        SUSPENDED("Suspended"),
        DELETING("Deleting"),
        DELETED("Deleted"),
        INVALID("Invalid"),
        UPDATINGSKU("UpdatingSku");

        private final String value;

        StateEnum(String value) {
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
        public static StateEnum fromValue(String text) {
            for (StateEnum b : StateEnum.values()) {
                if (String.valueOf(b.value).equals(text)) {
                    return b;
                }
            }
            return null;
        }
    }

    @JsonProperty("state")
    private StateEnum state;

    /**
     * Access rights user has for capacity
     */
    public enum CapacityUserAccessRightEnum {
        NONE("None"),
        ASSIGN("Assign"),
        ADMIN("Admin");

        private final String value;

        CapacityUserAccessRightEnum(String value) {
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
        public static CapacityUserAccessRightEnum fromValue(String text) {
            for (CapacityUserAccessRightEnum b : CapacityUserAccessRightEnum.values()) {
                if (String.valueOf(b.value).equals(text)) {
                    return b;
                }
            }
            return null;
        }
    }

    @JsonProperty("capacityUserAccessRight")
    private CapacityUserAccessRightEnum capacityUserAccessRight;

    public Capacity id(String id) {
        this.id = id;
        return this;
    }

    /**
     * The capacity id
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

    public Capacity displayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    /**
     * The capacity display name
     *
     * @return displayName
     *
     */
    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public Capacity admins(List<String> admins) {
        this.admins = admins;
        return this;
    }

    public Capacity addAdminsItem(String adminsItem) {
        if (this.admins == null) {
            this.admins = new ArrayList<>();
        }
        this.admins.add(adminsItem);
        return this;
    }

    /**
     * An array of capacity admins
     *
     * @return admins
     *
     */
    public List<String> getAdmins() {
        return admins;
    }

    public void setAdmins(List<String> admins) {
        this.admins = admins;
    }

    public Capacity sku(String sku) {
        this.sku = sku;
        return this;
    }

    /**
     * The capacity SKU
     *
     * @return sku
     *
     */
    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public Capacity state(StateEnum state) {
        this.state = state;
        return this;
    }

    /**
     * The capacity state
     *
     * @return state
     *
     */
    public StateEnum getState() {
        return state;
    }

    public void setState(StateEnum state) {
        this.state = state;
    }

    public Capacity capacityUserAccessRight(CapacityUserAccessRightEnum capacityUserAccessRight) {
        this.capacityUserAccessRight = capacityUserAccessRight;
        return this;
    }

    /**
     * Access rights user has for capacity
     *
     * @return capacityUserAccessRight
     *
     */
    public CapacityUserAccessRightEnum getCapacityUserAccessRight() {
        return capacityUserAccessRight;
    }

    public void setCapacityUserAccessRight(CapacityUserAccessRightEnum capacityUserAccessRight) {
        this.capacityUserAccessRight = capacityUserAccessRight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Capacity capacity = (Capacity) o;
        return Objects.equals(this.id, capacity.id)
                && Objects.equals(this.displayName, capacity.displayName)
                && Objects.equals(this.admins, capacity.admins)
                && Objects.equals(this.sku, capacity.sku)
                && Objects.equals(this.state, capacity.state)
                && Objects.equals(this.capacityUserAccessRight, capacity.capacityUserAccessRight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, displayName, admins, sku, state, capacityUserAccessRight);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Capacity {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
        sb.append("    admins: ").append(toIndentedString(admins)).append("\n");
        sb.append("    sku: ").append(toIndentedString(sku)).append("\n");
        sb.append("    state: ").append(toIndentedString(state)).append("\n");
        sb.append("    capacityUserAccessRight: ").append(toIndentedString(capacityUserAccessRight)).append("\n");
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

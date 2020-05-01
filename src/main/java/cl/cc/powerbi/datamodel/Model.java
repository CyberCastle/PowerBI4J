package cl.cc.powerbi.datamodel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 *
 * @author CyberCastle
 */
@JsonPropertyOrder({ "culture", "dataSources", "tables", "relationships", "annotations" })
public class Model implements Serializable {

    @JsonProperty("culture")
    private String culture;
    @JsonProperty("dataSources")
    private List<DataSource> dataSources = new ArrayList<DataSource>();
    @JsonProperty("tables")
    private List<Table> tables = new ArrayList<Table>();
    @JsonProperty("relationships")
    private List<Relationship> relationships = new ArrayList<Relationship>();
    @JsonProperty("annotations")
    private List<Annotation> annotations = new ArrayList<Annotation>();
    private final static long serialVersionUID = -4289214933706103018L;

    @JsonProperty("culture")
    public String getCulture() {
        return culture;
    }

    @JsonProperty("culture")
    public void setCulture(String culture) {
        this.culture = culture;
    }

    @JsonProperty("dataSources")
    public List<DataSource> getDataSources() {
        return dataSources;
    }

    @JsonProperty("dataSources")
    public void setDataSources(List<DataSource> dataSources) {
        this.dataSources = dataSources;
    }

    @JsonProperty("tables")
    public List<Table> getTables() {
        return tables;
    }

    @JsonProperty("tables")
    public void setTables(List<Table> tables) {
        this.tables = tables;
    }

    @JsonProperty("relationships")
    public List<Relationship> getRelationships() {
        return relationships;
    }

    @JsonProperty("relationships")
    public void setRelationships(List<Relationship> relationships) {
        this.relationships = relationships;
    }

    @JsonProperty("annotations")
    public List<Annotation> getAnnotations() {
        return annotations;
    }

    @JsonProperty("annotations")
    public void setAnnotations(List<Annotation> annotations) {
        this.annotations = annotations;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("culture", culture).append("dataSources", dataSources)
                .append("tables", tables).append("relationships", relationships).append("annotations", annotations)
                .toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(relationships).append(annotations).append(tables).append(dataSources)
                .append(culture).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Model) == false) {
            return false;
        }
        Model rhs = ((Model) other);
        return new EqualsBuilder().append(relationships, rhs.relationships).append(annotations, rhs.annotations)
                .append(tables, rhs.tables).append(dataSources, rhs.dataSources).append(culture, rhs.culture)
                .isEquals();
    }

}

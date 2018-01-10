
package com.xtravels.obj;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "name",
    "desc1",
    "desc2",
    "ruleFeeDetails"
})
public class Frrl implements Serializable
{

    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("desc1")
    private String desc1;
    @JsonProperty("desc2")
    private String desc2;
    @JsonProperty("ruleFeeDetails")
    private RuleFeeDetails ruleFeeDetails;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 110529611033018661L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Frrl() {
    }

    /**
     * 
     * @param id
     * @param ruleFeeDetails
     * @param name
     * @param desc1
     * @param desc2
     */
    public Frrl(String id, String name, String desc1, String desc2, RuleFeeDetails ruleFeeDetails) {
        super();
        this.id = id;
        this.name = name;
        this.desc1 = desc1;
        this.desc2 = desc2;
        this.ruleFeeDetails = ruleFeeDetails;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("desc1")
    public String getDesc1() {
        return desc1;
    }

    @JsonProperty("desc1")
    public void setDesc1(String desc1) {
        this.desc1 = desc1;
    }

    @JsonProperty("desc2")
    public String getDesc2() {
        return desc2;
    }

    @JsonProperty("desc2")
    public void setDesc2(String desc2) {
        this.desc2 = desc2;
    }

    @JsonProperty("ruleFeeDetails")
    public RuleFeeDetails getRuleFeeDetails() {
        return ruleFeeDetails;
    }

    @JsonProperty("ruleFeeDetails")
    public void setRuleFeeDetails(RuleFeeDetails ruleFeeDetails) {
        this.ruleFeeDetails = ruleFeeDetails;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("name", name).append("desc1", desc1).append("desc2", desc2).append("ruleFeeDetails", ruleFeeDetails).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(id).append(ruleFeeDetails).append(additionalProperties).append(name).append(desc1).append(desc2).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Frrl) == false) {
            return false;
        }
        Frrl rhs = ((Frrl) other);
        return new EqualsBuilder().append(id, rhs.id).append(ruleFeeDetails, rhs.ruleFeeDetails).append(additionalProperties, rhs.additionalProperties).append(name, rhs.name).append(desc1, rhs.desc1).append(desc2, rhs.desc2).isEquals();
    }

}

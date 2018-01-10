
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
    "desc2"
})
public class Rl implements Serializable
{

    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("desc1")
    private String desc1;
    @JsonProperty("desc2")
    private String desc2;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -3465944604022442160L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Rl() {
    }

    /**
     * 
     * @param id
     * @param name
     * @param desc1
     * @param desc2
     */
    public Rl(String id, String name, String desc1, String desc2) {
        super();
        this.id = id;
        this.name = name;
        this.desc1 = desc1;
        this.desc2 = desc2;
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
        return new ToStringBuilder(this).append("id", id).append("name", name).append("desc1", desc1).append("desc2", desc2).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(id).append(additionalProperties).append(name).append(desc1).append(desc2).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Rl) == false) {
            return false;
        }
        Rl rhs = ((Rl) other);
        return new EqualsBuilder().append(id, rhs.id).append(additionalProperties, rhs.additionalProperties).append(name, rhs.name).append(desc1, rhs.desc1).append(desc2, rhs.desc2).isEquals();
    }

}

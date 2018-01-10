
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
    "flgtSrchRes"
})
public class Test implements Serializable
{

    @JsonProperty("flgtSrchRes")
    private FlgtSrchRes flgtSrchRes;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 6018131079803575335L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Test() {
    }

    /**
     * 
     * @param flgtSrchRes
     */
    public Test(FlgtSrchRes flgtSrchRes) {
        super();
        this.flgtSrchRes = flgtSrchRes;
    }

    @JsonProperty("flgtSrchRes")
    public FlgtSrchRes getFlgtSrchRes() {
        return flgtSrchRes;
    }

    @JsonProperty("flgtSrchRes")
    public void setFlgtSrchRes(FlgtSrchRes flgtSrchRes) {
        this.flgtSrchRes = flgtSrchRes;
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
        return new ToStringBuilder(this).append("flgtSrchRes", flgtSrchRes).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(additionalProperties).append(flgtSrchRes).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Test) == false) {
            return false;
        }
        Test rhs = ((Test) other);
        return new EqualsBuilder().append(additionalProperties, rhs.additionalProperties).append(flgtSrchRes, rhs.flgtSrchRes).isEquals();
    }

}


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
    "baseFare",
    "totalFare"
})
public class Pricing implements Serializable
{

    @JsonProperty("baseFare")
    private String baseFare;
    @JsonProperty("totalFare")
    private String totalFare;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -86003100768980191L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Pricing() {
    }

    /**
     * 
     * @param baseFare
     * @param totalFare
     */
    public Pricing(String baseFare, String totalFare) {
        super();
        this.baseFare = baseFare;
        this.totalFare = totalFare;
    }

    @JsonProperty("baseFare")
    public String getBaseFare() {
        return baseFare;
    }

    @JsonProperty("baseFare")
    public void setBaseFare(String baseFare) {
        this.baseFare = baseFare;
    }

    @JsonProperty("totalFare")
    public String getTotalFare() {
        return totalFare;
    }

    @JsonProperty("totalFare")
    public void setTotalFare(String totalFare) {
        this.totalFare = totalFare;
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
        return new ToStringBuilder(this).append("baseFare", baseFare).append("totalFare", totalFare).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(baseFare).append(totalFare).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Pricing) == false) {
            return false;
        }
        Pricing rhs = ((Pricing) other);
        return new EqualsBuilder().append(baseFare, rhs.baseFare).append(totalFare, rhs.totalFare).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}


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
    "checkIn",
    "cabin"
})
public class BaggageInfo implements Serializable
{

    @JsonProperty("checkIn")
    private String checkIn;
    @JsonProperty("cabin")
    private String cabin;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -286392015215876551L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public BaggageInfo() {
    }

    /**
     * 
     * @param cabin
     * @param checkIn
     */
    public BaggageInfo(String checkIn, String cabin) {
        super();
        this.checkIn = checkIn;
        this.cabin = cabin;
    }

    @JsonProperty("checkIn")
    public String getCheckIn() {
        return checkIn;
    }

    @JsonProperty("checkIn")
    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    @JsonProperty("cabin")
    public String getCabin() {
        return cabin;
    }

    @JsonProperty("cabin")
    public void setCabin(String cabin) {
        this.cabin = cabin;
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
        return new ToStringBuilder(this).append("checkIn", checkIn).append("cabin", cabin).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(cabin).append(additionalProperties).append(checkIn).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof BaggageInfo) == false) {
            return false;
        }
        BaggageInfo rhs = ((BaggageInfo) other);
        return new EqualsBuilder().append(cabin, rhs.cabin).append(additionalProperties, rhs.additionalProperties).append(checkIn, rhs.checkIn).isEquals();
    }

}

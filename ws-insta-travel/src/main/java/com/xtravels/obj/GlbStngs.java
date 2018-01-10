
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
    "currencyType"
})
public class GlbStngs implements Serializable
{

    @JsonProperty("currencyType")
    private String currencyType;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 4454006670281180453L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public GlbStngs() {
    }

    /**
     * 
     * @param currencyType
     */
    public GlbStngs(String currencyType) {
        super();
        this.currencyType = currencyType;
    }

    @JsonProperty("currencyType")
    public String getCurrencyType() {
        return currencyType;
    }

    @JsonProperty("currencyType")
    public void setCurrencyType(String currencyType) {
        this.currencyType = currencyType;
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
        return new ToStringBuilder(this).append("currencyType", currencyType).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(additionalProperties).append(currencyType).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof GlbStngs) == false) {
            return false;
        }
        GlbStngs rhs = ((GlbStngs) other);
        return new EqualsBuilder().append(additionalProperties, rhs.additionalProperties).append(currencyType, rhs.currencyType).isEquals();
    }

}

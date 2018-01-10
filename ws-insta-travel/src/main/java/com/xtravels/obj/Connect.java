
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
    "-order",
    "flgtDtls"
})
public class Connect implements Serializable
{

    @JsonProperty("order")
    private String order;
    @JsonProperty("flgtDtls")
    private FlgtDtls flgtDtls;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -3620735595644374036L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Connect() {
    }

    /**
     * 
     * @param order
     * @param flgtDtls
     */
    public Connect(String order, FlgtDtls flgtDtls) {
        super();
        this.order = order;
        this.flgtDtls = flgtDtls;
    }

    @JsonProperty("order")
    public String getOrder() {
        return order;
    }

    @JsonProperty("order")
    public void setOrder(String order) {
        this.order = order;
    }

    @JsonProperty("flgtDtls")
    public FlgtDtls getFlgtDtls() {
        return flgtDtls;
    }

    @JsonProperty("flgtDtls")
    public void setFlgtDtls(FlgtDtls flgtDtls) {
        this.flgtDtls = flgtDtls;
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
        return new ToStringBuilder(this).append("order", order).append("flgtDtls", flgtDtls).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(order).append(additionalProperties).append(flgtDtls).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Connect) == false) {
            return false;
        }
        Connect rhs = ((Connect) other);
        return new EqualsBuilder().append(order, rhs.order).append(additionalProperties, rhs.additionalProperties).append(flgtDtls, rhs.flgtDtls).isEquals();
    }

}

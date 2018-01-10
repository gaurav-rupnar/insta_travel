
package com.xtravels.obj;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
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
    "frrl"
})
public class FrRls implements Serializable
{

    @JsonProperty("frrl")
    private List<Frrl> frrl = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -6665370307011176237L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public FrRls() {
    }

    /**
     * 
     * @param frrl
     */
    public FrRls(List<Frrl> frrl) {
        super();
        this.frrl = frrl;
    }

    @JsonProperty("frrl")
    public List<Frrl> getFrrl() {
        return frrl;
    }

    @JsonProperty("frrl")
    public void setFrrl(List<Frrl> frrl) {
        this.frrl = frrl;
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
        return new ToStringBuilder(this).append("frrl", frrl).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(frrl).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof FrRls) == false) {
            return false;
        }
        FrRls rhs = ((FrRls) other);
        return new EqualsBuilder().append(frrl, rhs.frrl).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}

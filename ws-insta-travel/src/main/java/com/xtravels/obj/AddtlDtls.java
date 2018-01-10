
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
    "bFlxDts",
    "bNearByArpt"
})
public class AddtlDtls implements Serializable
{

    @JsonProperty("bFlxDts")
    private String bFlxDts;
    @JsonProperty("bNearByArpt")
    private String bNearByArpt;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -8796108091403168243L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public AddtlDtls() {
    }

    /**
     * 
     * @param bNearByArpt
     * @param bFlxDts
     */
    public AddtlDtls(String bFlxDts, String bNearByArpt) {
        super();
        this.bFlxDts = bFlxDts;
        this.bNearByArpt = bNearByArpt;
    }

    @JsonProperty("bFlxDts")
    public String getBFlxDts() {
        return bFlxDts;
    }

    @JsonProperty("bFlxDts")
    public void setBFlxDts(String bFlxDts) {
        this.bFlxDts = bFlxDts;
    }

    @JsonProperty("bNearByArpt")
    public String getBNearByArpt() {
        return bNearByArpt;
    }

    @JsonProperty("bNearByArpt")
    public void setBNearByArpt(String bNearByArpt) {
        this.bNearByArpt = bNearByArpt;
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
        return new ToStringBuilder(this).append("bFlxDts", bFlxDts).append("bNearByArpt", bNearByArpt).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(bNearByArpt).append(bFlxDts).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AddtlDtls) == false) {
            return false;
        }
        AddtlDtls rhs = ((AddtlDtls) other);
        return new EqualsBuilder().append(bNearByArpt, rhs.bNearByArpt).append(bFlxDts, rhs.bFlxDts).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}

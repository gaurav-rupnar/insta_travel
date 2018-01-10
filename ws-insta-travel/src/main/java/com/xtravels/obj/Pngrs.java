
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
    "nAdlts",
    "nChldrn",
    "nInfnts",
    "nInfntInLaps"
})
public class Pngrs implements Serializable
{

    @JsonProperty("nAdlts")
    private String nAdlts;
    @JsonProperty("nChldrn")
    private String nChldrn;
    @JsonProperty("nInfnts")
    private String nInfnts;
    @JsonProperty("nInfntInLaps")
    private String nInfntInLaps;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 7952344588145285049L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Pngrs() {
    }

    /**
     * 
     * @param nInfnts
     * @param nInfntInLaps
     * @param nChldrn
     * @param nAdlts
     */
    public Pngrs(String nAdlts, String nChldrn, String nInfnts, String nInfntInLaps) {
        super();
        this.nAdlts = nAdlts;
        this.nChldrn = nChldrn;
        this.nInfnts = nInfnts;
        this.nInfntInLaps = nInfntInLaps;
    }

    @JsonProperty("nAdlts")
    public String getNAdlts() {
        return nAdlts;
    }

    @JsonProperty("nAdlts")
    public void setNAdlts(String nAdlts) {
        this.nAdlts = nAdlts;
    }

    @JsonProperty("nChldrn")
    public String getNChldrn() {
        return nChldrn;
    }

    @JsonProperty("nChldrn")
    public void setNChldrn(String nChldrn) {
        this.nChldrn = nChldrn;
    }

    @JsonProperty("nInfnts")
    public String getNInfnts() {
        return nInfnts;
    }

    @JsonProperty("nInfnts")
    public void setNInfnts(String nInfnts) {
        this.nInfnts = nInfnts;
    }

    @JsonProperty("nInfntInLaps")
    public String getNInfntInLaps() {
        return nInfntInLaps;
    }

    @JsonProperty("nInfntInLaps")
    public void setNInfntInLaps(String nInfntInLaps) {
        this.nInfntInLaps = nInfntInLaps;
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
        return new ToStringBuilder(this).append("nAdlts", nAdlts).append("nChldrn", nChldrn).append("nInfnts", nInfnts).append("nInfntInLaps", nInfntInLaps).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(nInfnts).append(nInfntInLaps).append(additionalProperties).append(nChldrn).append(nAdlts).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Pngrs) == false) {
            return false;
        }
        Pngrs rhs = ((Pngrs) other);
        return new EqualsBuilder().append(nInfnts, rhs.nInfnts).append(nInfntInLaps, rhs.nInfntInLaps).append(additionalProperties, rhs.additionalProperties).append(nChldrn, rhs.nChldrn).append(nAdlts, rhs.nAdlts).isEquals();
    }

}


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
    "dtTime",
    "loc",
    "arptCd",
    "trmnl"
})
public class ToLoc implements Serializable
{

    @JsonProperty("dtTime")
    private String dtTime;
    @JsonProperty("loc")
    private String loc;
    @JsonProperty("arptCd")
    private String arptCd;
    @JsonProperty("trmnl")
    private String trmnl;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 1629364401607625500L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public ToLoc() {
    }

    /**
     * 
     * @param dtTime
     * @param loc
     * @param arptCd
     * @param trmnl
     */
    public ToLoc(String dtTime, String loc, String arptCd, String trmnl) {
        super();
        this.dtTime = dtTime;
        this.loc = loc;
        this.arptCd = arptCd;
        this.trmnl = trmnl;
    }

    @JsonProperty("dtTime")
    public String getDtTime() {
        return dtTime;
    }

    @JsonProperty("dtTime")
    public void setDtTime(String dtTime) {
        this.dtTime = dtTime;
    }

    @JsonProperty("loc")
    public String getLoc() {
        return loc;
    }

    @JsonProperty("loc")
    public void setLoc(String loc) {
        this.loc = loc;
    }

    @JsonProperty("arptCd")
    public String getArptCd() {
        return arptCd;
    }

    @JsonProperty("arptCd")
    public void setArptCd(String arptCd) {
        this.arptCd = arptCd;
    }

    @JsonProperty("trmnl")
    public String getTrmnl() {
        return trmnl;
    }

    @JsonProperty("trmnl")
    public void setTrmnl(String trmnl) {
        this.trmnl = trmnl;
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
        return new ToStringBuilder(this).append("dtTime", dtTime).append("loc", loc).append("arptCd", arptCd).append("trmnl", trmnl).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(dtTime).append(additionalProperties).append(loc).append(arptCd).append(trmnl).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ToLoc) == false) {
            return false;
        }
        ToLoc rhs = ((ToLoc) other);
        return new EqualsBuilder().append(dtTime, rhs.dtTime).append(additionalProperties, rhs.additionalProperties).append(loc, rhs.loc).append(arptCd, rhs.arptCd).append(trmnl, rhs.trmnl).isEquals();
    }

}

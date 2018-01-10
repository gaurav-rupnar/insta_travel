
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
    "glbStngs",
    "flgtSrchReq",
    "rcmds"
})
public class FlgtSrchRes implements Serializable
{

    @JsonProperty("glbStngs")
    private GlbStngs glbStngs;
    @JsonProperty("flgtSrchReq")
    private FlgtSrchReq flgtSrchReq;
    @JsonProperty("rcmds")
    private Rcmds rcmds;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -8899472675032973284L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public FlgtSrchRes() {
    }

    /**
     * 
     * @param glbStngs
     * @param rcmds
     * @param flgtSrchReq
     */
    public FlgtSrchRes(GlbStngs glbStngs, FlgtSrchReq flgtSrchReq, Rcmds rcmds) {
        super();
        this.glbStngs = glbStngs;
        this.flgtSrchReq = flgtSrchReq;
        this.rcmds = rcmds;
    }

    @JsonProperty("glbStngs")
    public GlbStngs getGlbStngs() {
        return glbStngs;
    }

    @JsonProperty("glbStngs")
    public void setGlbStngs(GlbStngs glbStngs) {
        this.glbStngs = glbStngs;
    }

    @JsonProperty("flgtSrchReq")
    public FlgtSrchReq getFlgtSrchReq() {
        return flgtSrchReq;
    }

    @JsonProperty("flgtSrchReq")
    public void setFlgtSrchReq(FlgtSrchReq flgtSrchReq) {
        this.flgtSrchReq = flgtSrchReq;
    }

    @JsonProperty("rcmds")
    public Rcmds getRcmds() {
        return rcmds;
    }

    @JsonProperty("rcmds")
    public void setRcmds(Rcmds rcmds) {
        this.rcmds = rcmds;
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
        return new ToStringBuilder(this).append("glbStngs", glbStngs).append("flgtSrchReq", flgtSrchReq).append("rcmds", rcmds).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(glbStngs).append(rcmds).append(additionalProperties).append(flgtSrchReq).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof FlgtSrchRes) == false) {
            return false;
        }
        FlgtSrchRes rhs = ((FlgtSrchRes) other);
        return new EqualsBuilder().append(glbStngs, rhs.glbStngs).append(rcmds, rhs.rcmds).append(additionalProperties, rhs.additionalProperties).append(flgtSrchReq, rhs.flgtSrchReq).isEquals();
    }

}

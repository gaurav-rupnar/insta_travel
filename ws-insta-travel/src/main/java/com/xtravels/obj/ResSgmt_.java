
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
    "flgtPath",
    "noOfHops",
    "connect",
    "ttlTripTm"
})
public class ResSgmt_ implements Serializable
{

    @JsonProperty("flgtPath")
    private String flgtPath;
    @JsonProperty("noOfHops")
    private String noOfHops;
    @JsonProperty("connect")
    private List<Connect> connect = null;
    @JsonProperty("ttlTripTm")
    private String ttlTripTm;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -2937355597451782772L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public ResSgmt_() {
    }

    /**
     * 
     * @param connect
     * @param flgtPath
     * @param noOfHops
     * @param ttlTripTm
     */
    public ResSgmt_(String flgtPath, String noOfHops, List<Connect> connect, String ttlTripTm) {
        super();
        this.flgtPath = flgtPath;
        this.noOfHops = noOfHops;
        this.connect = connect;
        this.ttlTripTm = ttlTripTm;
    }

    @JsonProperty("flgtPath")
    public String getFlgtPath() {
        return flgtPath;
    }

    @JsonProperty("flgtPath")
    public void setFlgtPath(String flgtPath) {
        this.flgtPath = flgtPath;
    }

    @JsonProperty("noOfHops")
    public String getNoOfHops() {
        return noOfHops;
    }

    @JsonProperty("noOfHops")
    public void setNoOfHops(String noOfHops) {
        this.noOfHops = noOfHops;
    }

    @JsonProperty("connect")
    public List<Connect> getConnect() {
        return connect;
    }

    @JsonProperty("connect")
    public void setConnect(List<Connect> connect) {
        this.connect = connect;
    }

    @JsonProperty("ttlTripTm")
    public String getTtlTripTm() {
        return ttlTripTm;
    }

    @JsonProperty("ttlTripTm")
    public void setTtlTripTm(String ttlTripTm) {
        this.ttlTripTm = ttlTripTm;
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
        return new ToStringBuilder(this).append("flgtPath", flgtPath).append("noOfHops", noOfHops).append("connect", connect).append("ttlTripTm", ttlTripTm).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(connect).append(additionalProperties).append(flgtPath).append(noOfHops).append(ttlTripTm).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ResSgmt_) == false) {
            return false;
        }
        ResSgmt_ rhs = ((ResSgmt_) other);
        return new EqualsBuilder().append(connect, rhs.connect).append(additionalProperties, rhs.additionalProperties).append(flgtPath, rhs.flgtPath).append(noOfHops, rhs.noOfHops).append(ttlTripTm, rhs.ttlTripTm).isEquals();
    }

}

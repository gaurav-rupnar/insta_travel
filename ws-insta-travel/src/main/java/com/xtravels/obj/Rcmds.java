
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
    "rcmd"
})
public class Rcmds implements Serializable
{

    @JsonProperty("rcmd")
    private List<Rcmd> rcmd = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -6164761403001522554L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Rcmds() {
    }

    /**
     * 
     * @param rcmd
     */
    public Rcmds(List<Rcmd> rcmd) {
        super();
        this.rcmd = rcmd;
    }

    @JsonProperty("rcmd")
    public List<Rcmd> getRcmd() {
        return rcmd;
    }

    @JsonProperty("rcmd")
    public void setRcmd(List<Rcmd> rcmd) {
        this.rcmd = rcmd;
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
        return new ToStringBuilder(this).append("rcmd", rcmd).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(rcmd).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Rcmds) == false) {
            return false;
        }
        Rcmds rhs = ((Rcmds) other);
        return new EqualsBuilder().append(rcmd, rhs.rcmd).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}

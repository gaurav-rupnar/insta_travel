
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
    "oId",
    "sFrom",
    "sTo",
    "dtTrvlDate"
})
public class ReqSgmt implements Serializable
{

    @JsonProperty("oId")
    private String oId;
    @JsonProperty("sFrom")
    private String sFrom;
    @JsonProperty("sTo")
    private String sTo;
    @JsonProperty("dtTrvlDate")
    private String dtTrvlDate;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 812380888579557510L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public ReqSgmt() {
    }

    /**
     * 
     * @param dtTrvlDate
     * @param sTo
     * @param sFrom
     * @param oId
     */
    public ReqSgmt(String oId, String sFrom, String sTo, String dtTrvlDate) {
        super();
        this.oId = oId;
        this.sFrom = sFrom;
        this.sTo = sTo;
        this.dtTrvlDate = dtTrvlDate;
    }

    @JsonProperty("oId")
    public String getOId() {
        return oId;
    }

    @JsonProperty("oId")
    public void setOId(String oId) {
        this.oId = oId;
    }

    @JsonProperty("sFrom")
    public String getSFrom() {
        return sFrom;
    }

    @JsonProperty("sFrom")
    public void setSFrom(String sFrom) {
        this.sFrom = sFrom;
    }

    @JsonProperty("sTo")
    public String getSTo() {
        return sTo;
    }

    @JsonProperty("sTo")
    public void setSTo(String sTo) {
        this.sTo = sTo;
    }

    @JsonProperty("dtTrvlDate")
    public String getDtTrvlDate() {
        return dtTrvlDate;
    }

    @JsonProperty("dtTrvlDate")
    public void setDtTrvlDate(String dtTrvlDate) {
        this.dtTrvlDate = dtTrvlDate;
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
        return new ToStringBuilder(this).append("oId", oId).append("sFrom", sFrom).append("sTo", sTo).append("dtTrvlDate", dtTrvlDate).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(dtTrvlDate).append(sTo).append(additionalProperties).append(sFrom).append(oId).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ReqSgmt) == false) {
            return false;
        }
        ReqSgmt rhs = ((ReqSgmt) other);
        return new EqualsBuilder().append(dtTrvlDate, rhs.dtTrvlDate).append(sTo, rhs.sTo).append(additionalProperties, rhs.additionalProperties).append(sFrom, rhs.sFrom).append(oId, rhs.oId).isEquals();
    }

}

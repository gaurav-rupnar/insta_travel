
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
    "recmIndexId",
    "frRls",
    "pricing",
    "bufferedCol1",
    "bufferedCol2",
    "bufferedCol3",
    "resSgmt"
})
public class Rcmd implements Serializable
{

    @JsonProperty("recmIndexId")
    private String recmIndexId;
    @JsonProperty("frRls")
    private FrRls frRls;
    @JsonProperty("pricing")
    private Pricing pricing;
    @JsonProperty("bufferedCol1")
    private String bufferedCol1;
    @JsonProperty("bufferedCol2")
    private String bufferedCol2;
    @JsonProperty("bufferedCol3")
    private String bufferedCol3;
    @JsonProperty("resSgmt")
    private List<ResSgmt> resSgmt = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -5959800340667543029L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Rcmd() {
    }

    /**
     * 
     * @param resSgmt
     * @param bufferedCol3
     * @param pricing
     * @param bufferedCol1
     * @param bufferedCol2
     * @param frRls
     * @param recmIndexId
     */
    public Rcmd(String recmIndexId, FrRls frRls, Pricing pricing, String bufferedCol1, String bufferedCol2, String bufferedCol3, List<ResSgmt> resSgmt) {
        super();
        this.recmIndexId = recmIndexId;
        this.frRls = frRls;
        this.pricing = pricing;
        this.bufferedCol1 = bufferedCol1;
        this.bufferedCol2 = bufferedCol2;
        this.bufferedCol3 = bufferedCol3;
        this.resSgmt = resSgmt;
    }

    @JsonProperty("recmIndexId")
    public String getRecmIndexId() {
        return recmIndexId;
    }

    @JsonProperty("recmIndexId")
    public void setRecmIndexId(String recmIndexId) {
        this.recmIndexId = recmIndexId;
    }

    @JsonProperty("frRls")
    public FrRls getFrRls() {
        return frRls;
    }

    @JsonProperty("frRls")
    public void setFrRls(FrRls frRls) {
        this.frRls = frRls;
    }

    @JsonProperty("pricing")
    public Pricing getPricing() {
        return pricing;
    }

    @JsonProperty("pricing")
    public void setPricing(Pricing pricing) {
        this.pricing = pricing;
    }

    @JsonProperty("bufferedCol1")
    public String getBufferedCol1() {
        return bufferedCol1;
    }

    @JsonProperty("bufferedCol1")
    public void setBufferedCol1(String bufferedCol1) {
        this.bufferedCol1 = bufferedCol1;
    }

    @JsonProperty("bufferedCol2")
    public String getBufferedCol2() {
        return bufferedCol2;
    }

    @JsonProperty("bufferedCol2")
    public void setBufferedCol2(String bufferedCol2) {
        this.bufferedCol2 = bufferedCol2;
    }

    @JsonProperty("bufferedCol3")
    public String getBufferedCol3() {
        return bufferedCol3;
    }

    @JsonProperty("bufferedCol3")
    public void setBufferedCol3(String bufferedCol3) {
        this.bufferedCol3 = bufferedCol3;
    }

    @JsonProperty("resSgmt")
    public List<ResSgmt> getResSgmt() {
        return resSgmt;
    }

    @JsonProperty("resSgmt")
    public void setResSgmt(List<ResSgmt> resSgmt) {
        this.resSgmt = resSgmt;
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
        return new ToStringBuilder(this).append("recmIndexId", recmIndexId).append("frRls", frRls).append("pricing", pricing).append("bufferedCol1", bufferedCol1).append("bufferedCol2", bufferedCol2).append("bufferedCol3", bufferedCol3).append("resSgmt", resSgmt).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(resSgmt).append(bufferedCol3).append(pricing).append(bufferedCol1).append(bufferedCol2).append(additionalProperties).append(frRls).append(recmIndexId).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Rcmd) == false) {
            return false;
        }
        Rcmd rhs = ((Rcmd) other);
        return new EqualsBuilder().append(resSgmt, rhs.resSgmt).append(bufferedCol3, rhs.bufferedCol3).append(pricing, rhs.pricing).append(bufferedCol1, rhs.bufferedCol1).append(bufferedCol2, rhs.bufferedCol2).append(additionalProperties, rhs.additionalProperties).append(frRls, rhs.frRls).append(recmIndexId, rhs.recmIndexId).isEquals();
    }

}

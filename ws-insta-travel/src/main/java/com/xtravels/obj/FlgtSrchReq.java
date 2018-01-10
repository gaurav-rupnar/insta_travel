
package com.xtravels.obj;

import java.io.Serializable;
import java.math.BigDecimal;
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
    "sTrvlType",
    "sBkCls",
    "addtlDtls",
    "pngrs",
    "noOfRecmdations",
    "reqSgmt"
})
public class FlgtSrchReq implements Serializable
{

    @JsonProperty("sTrvlType")
    private String sTrvlType;
    @JsonProperty("sBkCls")
    private String sBkCls;
    @JsonProperty("addtlDtls")
    private AddtlDtls addtlDtls;
    @JsonProperty("pngrs")
    private Pngrs pngrs;
    
    @JsonProperty("noOfRecmdations")
    private BigDecimal noOfRecmdations;
    
    
    @JsonProperty("travelFlightClassInfo")
    private String travelFlightClassInfo;
    
    
    @JsonProperty("reqSgmt")
    private List<ReqSgmt> reqSgmt = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -722897622186906877L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public FlgtSrchReq() {
    }

    /**
     * 
     * @param reqSgmt
     * @param pngrs
     * @param sBkCls
     * @param addtlDtls
     * @param sTrvlType
     */
    public FlgtSrchReq(String sTrvlType, String sBkCls, AddtlDtls addtlDtls, Pngrs pngrs, List<ReqSgmt> reqSgmt) {
        super();
        this.sTrvlType = sTrvlType;
        this.sBkCls = sBkCls;
        this.addtlDtls = addtlDtls;
        this.pngrs = pngrs;
        this.reqSgmt = reqSgmt;
    }

    @JsonProperty("sTrvlType")
    public String getSTrvlType() {
        return sTrvlType;
    }

    @JsonProperty("sTrvlType")
    public void setSTrvlType(String sTrvlType) {
        this.sTrvlType = sTrvlType;
    }

    @JsonProperty("sBkCls")
    public String getSBkCls() {
        return sBkCls;
    }

    @JsonProperty("sBkCls")
    public void setSBkCls(String sBkCls) {
        this.sBkCls = sBkCls;
    }

    @JsonProperty("addtlDtls")
    public AddtlDtls getAddtlDtls() {
        return addtlDtls;
    }

    @JsonProperty("addtlDtls")
    public void setAddtlDtls(AddtlDtls addtlDtls) {
        this.addtlDtls = addtlDtls;
    }

    @JsonProperty("pngrs")
    public Pngrs getPngrs() {
        return pngrs;
    }

    @JsonProperty("pngrs")
    public void setPngrs(Pngrs pngrs) {
        this.pngrs = pngrs;
    }


    
    @JsonProperty("travelFlightClassInfo")
    public String getTravelFlightClassInfo() {
        return travelFlightClassInfo;
    }

    @JsonProperty("travelFlightClassInfo")
    public void setTravelFlightClassInfo(String travelFlightClassInfo) {
        this.travelFlightClassInfo = travelFlightClassInfo;
    }

    
    @JsonProperty("noOfRecmdations")
    public BigDecimal getNoOfRecmdations() {
        return noOfRecmdations;
    }

    @JsonProperty("noOfRecmdations")
    public void setNoOfRecmdations(BigDecimal noOfRecmdations) {
        this.noOfRecmdations = noOfRecmdations;
    }

    
    @JsonProperty("reqSgmt")
    public List<ReqSgmt> getReqSgmt() {
        return reqSgmt;
    }

    @JsonProperty("reqSgmt")
    public void setReqSgmt(List<ReqSgmt> reqSgmt) {
        this.reqSgmt = reqSgmt;
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
        return new ToStringBuilder(this).append("sTrvlType", sTrvlType).append("sBkCls", sBkCls).append("addtlDtls", addtlDtls).append("pngrs", pngrs).append("reqSgmt", reqSgmt).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(reqSgmt).append(pngrs).append(additionalProperties).append(sBkCls).append(addtlDtls).append(sTrvlType).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof FlgtSrchReq) == false) {
            return false;
        }
        FlgtSrchReq rhs = ((FlgtSrchReq) other);
        return new EqualsBuilder().append(reqSgmt, rhs.reqSgmt).append(pngrs, rhs.pngrs).append(additionalProperties, rhs.additionalProperties).append(sBkCls, rhs.sBkCls).append(addtlDtls, rhs.addtlDtls).append(sTrvlType, rhs.sTrvlType).isEquals();
    }

}

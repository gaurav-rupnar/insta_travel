
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
    "baggageInfo",
    "mrktFlgtId",
    "mrktFlgtNo",
    "mrktFlgtImgUrl",
    "optFlight",
    "trvlDuriation",
    "fromLoc",
    "toLoc",
    "layOverDuriation",
    "from",
    "to"
})
public class FlgtDtls implements Serializable
{

    @JsonProperty("baggageInfo")
    private BaggageInfo baggageInfo;
    @JsonProperty("mrktFlgtId")
    private String mrktFlgtId;
    @JsonProperty("mrktFlgtNo")
    private String mrktFlgtNo;
    @JsonProperty("mrktFlgtImgUrl")
    private String mrktFlgtImgUrl;
    @JsonProperty("optFlight")
    private String optFlight;
    @JsonProperty("trvlDuriation")
    private String trvlDuriation;
    @JsonProperty("fromLoc")
    private FromLoc fromLoc;
    @JsonProperty("toLoc")
    private ToLoc toLoc;
    @JsonProperty("layOverDuriation")
    private String layOverDuriation;
    @JsonProperty("from")
    private From from;
    @JsonProperty("to")
    private To to;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -2168528378997068613L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public FlgtDtls() {
    }

    /**
     * 
     * @param to
     * @param baggageInfo
     * @param layOverDuriation
     * @param fromLoc
     * @param mrktFlgtImgUrl
     * @param mrktFlgtId
     * @param optFlight
     * @param mrktFlgtNo
     * @param from
     * @param toLoc
     * @param trvlDuriation
     */
    public FlgtDtls(BaggageInfo baggageInfo, String mrktFlgtId, String mrktFlgtNo, String mrktFlgtImgUrl, String optFlight, String trvlDuriation, FromLoc fromLoc, ToLoc toLoc, String layOverDuriation, From from, To to) {
        super();
        this.baggageInfo = baggageInfo;
        this.mrktFlgtId = mrktFlgtId;
        this.mrktFlgtNo = mrktFlgtNo;
        this.mrktFlgtImgUrl = mrktFlgtImgUrl;
        this.optFlight = optFlight;
        this.trvlDuriation = trvlDuriation;
        this.fromLoc = fromLoc;
        this.toLoc = toLoc;
        this.layOverDuriation = layOverDuriation;
        this.from = from;
        this.to = to;
    }

    @JsonProperty("baggageInfo")
    public BaggageInfo getBaggageInfo() {
        return baggageInfo;
    }

    @JsonProperty("baggageInfo")
    public void setBaggageInfo(BaggageInfo baggageInfo) {
        this.baggageInfo = baggageInfo;
    }

    @JsonProperty("mrktFlgtId")
    public String getMrktFlgtId() {
        return mrktFlgtId;
    }

    @JsonProperty("mrktFlgtId")
    public void setMrktFlgtId(String mrktFlgtId) {
        this.mrktFlgtId = mrktFlgtId;
    }

    @JsonProperty("mrktFlgtNo")
    public String getMrktFlgtNo() {
        return mrktFlgtNo;
    }

    @JsonProperty("mrktFlgtNo")
    public void setMrktFlgtNo(String mrktFlgtNo) {
        this.mrktFlgtNo = mrktFlgtNo;
    }

    @JsonProperty("mrktFlgtImgUrl")
    public String getMrktFlgtImgUrl() {
        return mrktFlgtImgUrl;
    }

    @JsonProperty("mrktFlgtImgUrl")
    public void setMrktFlgtImgUrl(String mrktFlgtImgUrl) {
        this.mrktFlgtImgUrl = mrktFlgtImgUrl;
    }

    @JsonProperty("optFlight")
    public String getOptFlight() {
        return optFlight;
    }

    @JsonProperty("optFlight")
    public void setOptFlight(String optFlight) {
        this.optFlight = optFlight;
    }

    @JsonProperty("trvlDuriation")
    public String getTrvlDuriation() {
        return trvlDuriation;
    }

    @JsonProperty("trvlDuriation")
    public void setTrvlDuriation(String trvlDuriation) {
        this.trvlDuriation = trvlDuriation;
    }

    @JsonProperty("fromLoc")
    public FromLoc getFromLoc() {
        return fromLoc;
    }

    @JsonProperty("fromLoc")
    public void setFromLoc(FromLoc fromLoc) {
        this.fromLoc = fromLoc;
    }

    @JsonProperty("toLoc")
    public ToLoc getToLoc() {
        return toLoc;
    }

    @JsonProperty("toLoc")
    public void setToLoc(ToLoc toLoc) {
        this.toLoc = toLoc;
    }

    @JsonProperty("layOverDuriation")
    public String getLayOverDuriation() {
        return layOverDuriation;
    }

    @JsonProperty("layOverDuriation")
    public void setLayOverDuriation(String layOverDuriation) {
        this.layOverDuriation = layOverDuriation;
    }

    @JsonProperty("from")
    public From getFrom() {
        return from;
    }

    @JsonProperty("from")
    public void setFrom(From from) {
        this.from = from;
    }

    @JsonProperty("to")
    public To getTo() {
        return to;
    }

    @JsonProperty("to")
    public void setTo(To to) {
        this.to = to;
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
        return new ToStringBuilder(this).append("baggageInfo", baggageInfo).append("mrktFlgtId", mrktFlgtId).append("mrktFlgtNo", mrktFlgtNo).append("mrktFlgtImgUrl", mrktFlgtImgUrl).append("optFlight", optFlight).append("trvlDuriation", trvlDuriation).append("fromLoc", fromLoc).append("toLoc", toLoc).append("layOverDuriation", layOverDuriation).append("from", from).append("to", to).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(to).append(mrktFlgtImgUrl).append(mrktFlgtId).append(from).append(toLoc).append(trvlDuriation).append(baggageInfo).append(layOverDuriation).append(fromLoc).append(additionalProperties).append(optFlight).append(mrktFlgtNo).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof FlgtDtls) == false) {
            return false;
        }
        FlgtDtls rhs = ((FlgtDtls) other);
        return new EqualsBuilder().append(to, rhs.to).append(mrktFlgtImgUrl, rhs.mrktFlgtImgUrl).append(mrktFlgtId, rhs.mrktFlgtId).append(from, rhs.from).append(toLoc, rhs.toLoc).append(trvlDuriation, rhs.trvlDuriation).append(baggageInfo, rhs.baggageInfo).append(layOverDuriation, rhs.layOverDuriation).append(fromLoc, rhs.fromLoc).append(additionalProperties, rhs.additionalProperties).append(optFlight, rhs.optFlight).append(mrktFlgtNo, rhs.mrktFlgtNo).isEquals();
    }

}

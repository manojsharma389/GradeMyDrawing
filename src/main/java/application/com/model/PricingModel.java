package application.com.model;

import org.hibernate.validator.constraints.NotEmpty;

import java.util.Date;

public class PricingModel {
    @NotEmpty(message = "Pricing Key can not be empty")
    private String pricingKey;

    private String pricingValue;

    private String pricingDescription;

    private Date createdDate;

    private String createdBy;

    private Date modifiedDate;

    private String modifiedBy;

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public String getPricingKey() {
        return pricingKey;
    }

    public void setPricingKey(String pricingKey) {
        this.pricingKey = pricingKey;
    }

    public String getPricingValue() {
        return pricingValue;
    }

    public void setPricingValue(String pricingValue) {
        this.pricingValue = pricingValue;
    }

    public String getPricingDescription() {
        return pricingDescription;
    }

    public void setPricingDescription(String pricingDescription) {
        this.pricingDescription = pricingDescription;
    }
}

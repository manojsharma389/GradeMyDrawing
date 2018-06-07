package application.com.model;

import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;
import java.util.Date;

public class SubscriptionModel implements Serializable {

    @NotEmpty(message = "Plan Id can not be empty")
    private String planId;

    private String planName;

    private String planDescription;

    private Date planEffectiveDate;

    private Date planExpirationDate;

    private boolean isPlanDiscountable;

    private String planDiscountName;

    private String planDiscountType;

    private int planDiscountAmount;

    private String planDiscountDescription;

    private Date createdDate;

    private String createdBy;

    private Date modifiedDate;

    private String modifiedBy;

    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
        this.planId = planId;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public String getPlanDescription() {
        return planDescription;
    }

    public void setPlanDescription(String planDescription) {
        this.planDescription = planDescription;
    }

    public Date getPlanEffectiveDate() {
        return planEffectiveDate;
    }

    public void setPlanEffectiveDate(Date planEffectiveDate) {
        this.planEffectiveDate = planEffectiveDate;
    }

    public Date getPlanExpirationDate() {
        return planExpirationDate;
    }

    public void setPlanExpirationDate(Date planExpirationDate) {
        this.planExpirationDate = planExpirationDate;
    }

    public boolean isPlanDiscountable() {
        return isPlanDiscountable;
    }

    public void setIsPlanDiscountable(boolean planDiscountable) {
        isPlanDiscountable = planDiscountable;
    }

    public String getPlanDiscountName() {
        return planDiscountName;
    }

    public void setPlanDiscountName(String planDiscountName) {
        this.planDiscountName = planDiscountName;
    }

    public String getPlanDiscountType() {
        return planDiscountType;
    }

    public void setPlanDiscountType(String planDiscountType) {
        this.planDiscountType = planDiscountType;
    }

    public int getPlanDiscountAmount() {
        return planDiscountAmount;
    }

    public void setPlanDiscountAmount(int planDiscountAmount) {
        this.planDiscountAmount = planDiscountAmount;
    }

    public String getPlanDiscountDescription() {
        return planDiscountDescription;
    }

    public void setPlanDiscountDescription(String planDiscountDescription) {
        this.planDiscountDescription = planDiscountDescription;
    }

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
}

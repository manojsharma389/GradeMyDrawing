package application.com.entities;


import application.com.enums.BillingStatus;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "subscription_history_tbl")
public class SubscriptionHistory implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subscription_history_rec_id", nullable = false)
    private int recId;

    @Column(name = "user_id", unique = true)
    private String userId;

    @Column(name = "date_paid")
    private Date datePaid;

    @Column(name = "plan_id", unique = true)
    private String planId;

    @Column(name = "plan_name")
    private String planName;

    @Column(name = "plan_description")
    private String planDescription;

    @Column(name = "plan_effective_date")
    private Date planEffectiveDate;

    @Column(name = "plan_expiration_date")
    private Date planExpirationDate;

    @Column(name = "plan_discountable")
    private boolean isPlanDiscountable;

    @Column(name = "plan_discount_name")
    private String planDiscountName;

    @Column(name = "plan_discount_type")
    private String planDiscountType;

    @Column(name = "plan_discount_amount")
    private float planDiscountAmount;

    @Column(name = "plan_base_amount")
    private float planBaseAmount;

    @Column(name = "plan_discount_description")
    private String planDiscountDescription;

    @Column(name = "billing_frequency")
    private String billingFrequency;

    @Column(name = "billing_status")
    private BillingStatus billingStatus;

    @Column(name = "billing_transaction_response")
    private String billingTransactionResponse;

    @Column(name = "billing_transaction_date")
    private Date billingTransactionDate;

    @Column(name = "billing_amount")
    private float billingAmount;

    @Column(name = "registration_date")
    private Date registrationDate;

    @Column(name = "registration_expiration_date")
    private Date registration_expiration_date;

    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "modified_date")
    private Date modifiedDate;

    @Column(name = "modified_by")
    private String modifiedBy;

    public int getRecId() {
        return recId;
    }

    public void setRecId(int recId) {
        this.recId = recId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getDatePaid() {
        return datePaid;
    }

    public void setDatePaid(Date datePaid) {
        this.datePaid = datePaid;
    }

    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
        this.planId = planId;
    }

    public float getPlanBaseAmount() {
        return planBaseAmount;
    }

    public void setPlanBaseAmount(float planBaseAmount) {
        this.planBaseAmount = planBaseAmount;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Date getRegistration_expiration_date() {
        return registration_expiration_date;
    }

    public void setRegistration_expiration_date(Date registration_expiration_date) {
        this.registration_expiration_date = registration_expiration_date;
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

    public void setPlanDiscountable(boolean planDiscountable) {
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

    public float getPlanDiscountAmount() {
        return planDiscountAmount;
    }

    public void setPlanDiscountAmount(float planDiscountAmount) {
        this.planDiscountAmount = planDiscountAmount;
    }

    public String getPlanDiscountDescription() {
        return planDiscountDescription;
    }

    public void setPlanDiscountDescription(String planDiscountDescription) {
        this.planDiscountDescription = planDiscountDescription;
    }

    public String getBillingFrequency() {
        return billingFrequency;
    }

    public void setBillingFrequency(String billingFrequency) {
        this.billingFrequency = billingFrequency;
    }

    public BillingStatus getBillingStatus() {
        return billingStatus;
    }

    public void setBillingStatus(BillingStatus billingStatus) {
        this.billingStatus = billingStatus;
    }

    public String getBillingTransactionResponse() {
        return billingTransactionResponse;
    }

    public void setBillingTransactionResponse(String billingTransactionResponse) {
        this.billingTransactionResponse = billingTransactionResponse;
    }

    public Date getBillingTransactionDate() {
        return billingTransactionDate;
    }

    public void setBillingTransactionDate(Date billingTransactionDate) {
        this.billingTransactionDate = billingTransactionDate;
    }

    public float getBillingAmount() {
        return billingAmount;
    }

    public void setBillingAmount(float billingAmount) {
        this.billingAmount = billingAmount;
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

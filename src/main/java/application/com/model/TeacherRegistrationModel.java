package application.com.model;

import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;
import java.util.Date;

public class TeacherRegistrationModel implements Serializable {

    @NotEmpty(message = "User Id can not be empty")
    private String userId;

    @NotEmpty(message = "User Type can not be empty")
    private String userType;

    @NotEmpty(message = "Password can not be empty")
    private String password;

    @NotEmpty(message = "Email can not be empty")
    private String email;

    private String displayName;

    private String planId;

    private Date registrationDate;

    private Date registrationExpirationDate;

    private String billingFrequency;

    private String billingStatus;

    private String billingTransactionResponse;

    private Date billingTransactionDate;

    private float billingAmount;

    private String schoolId;

    private String schoolName;

    private String schoolAddress1;

    private String schoolAddress2;

    private String schoolAddressCity;

    private String schoolAddressState;

    private int schoolAddressZip;

    private String teacherTitle;

    private String teacherSecurityQuestion1;

    private String teacherSecurityQuestion2;

    private String teacherSecurityQuestion3;

    private String teacherSecurityAnswer1;

    private String teacherSecurityAnswer2;

    private String teacherSecurityAnswer3;

    private String teacherStatus;

    private Date createdDate;

    private String createdBy;

    private Date modifiedDate;

    private String modifiedBy;


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
        this.planId = planId;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Date getRegistrationExpirationDate() {
        return registrationExpirationDate;
    }

    public void setRegistrationExpirationDate(Date registrationExpirationDate) {
        this.registrationExpirationDate = registrationExpirationDate;
    }

    public String getBillingFrequency() {
        return billingFrequency;
    }

    public void setBillingFrequency(String billingFrequency) {
        this.billingFrequency = billingFrequency;
    }

    public String getBillingStatus() {
        return billingStatus;
    }

    public void setBillingStatus(String billingStatus) {
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

    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getSchoolAddress1() {
        return schoolAddress1;
    }

    public void setSchoolAddress1(String schoolAddress1) {
        this.schoolAddress1 = schoolAddress1;
    }

    public String getSchoolAddress2() {
        return schoolAddress2;
    }

    public void setSchoolAddress2(String schoolAddress2) {
        this.schoolAddress2 = schoolAddress2;
    }

    public String getSchoolAddressCity() {
        return schoolAddressCity;
    }

    public void setSchoolAddressCity(String schoolAddressCity) {
        this.schoolAddressCity = schoolAddressCity;
    }

    public String getSchoolAddressState() {
        return schoolAddressState;
    }

    public void setSchoolAddressState(String schoolAddressState) {
        this.schoolAddressState = schoolAddressState;
    }

    public int getSchoolAddressZip() {
        return schoolAddressZip;
    }

    public void setSchoolAddressZip(int schoolAddressZip) {
        this.schoolAddressZip = schoolAddressZip;
    }

    public String getTeacherTitle() {
        return teacherTitle;
    }

    public void setTeacherTitle(String teacherTitle) {
        this.teacherTitle = teacherTitle;
    }

    public String getTeacherSecurityQuestion1() {
        return teacherSecurityQuestion1;
    }

    public void setTeacherSecurityQuestion1(String teacherSecurityQuestion1) {
        this.teacherSecurityQuestion1 = teacherSecurityQuestion1;
    }

    public String getTeacherSecurityQuestion2() {
        return teacherSecurityQuestion2;
    }

    public void setTeacherSecurityQuestion2(String teacherSecurityQuestion2) {
        this.teacherSecurityQuestion2 = teacherSecurityQuestion2;
    }

    public String getTeacherSecurityQuestion3() {
        return teacherSecurityQuestion3;
    }

    public void setTeacherSecurityQuestion3(String teacherSecurityQuestion3) {
        this.teacherSecurityQuestion3 = teacherSecurityQuestion3;
    }

    public String getTeacherSecurityAnswer1() {
        return teacherSecurityAnswer1;
    }

    public void setTeacherSecurityAnswer1(String teacherSecurityAnswer1) {
        this.teacherSecurityAnswer1 = teacherSecurityAnswer1;
    }

    public String getTeacherSecurityAnswer2() {
        return teacherSecurityAnswer2;
    }

    public void setTeacherSecurityAnswer2(String teacherSecurityAnswer2) {
        this.teacherSecurityAnswer2 = teacherSecurityAnswer2;
    }

    public String getTeacherSecurityAnswer3() {
        return teacherSecurityAnswer3;
    }

    public void setTeacherSecurityAnswer3(String teacherSecurityAnswer3) {
        this.teacherSecurityAnswer3 = teacherSecurityAnswer3;
    }

    public String getTeacherStatus() {
        return teacherStatus;
    }

    public void setTeacherStatus(String teacherStatus) {
        this.teacherStatus = teacherStatus;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

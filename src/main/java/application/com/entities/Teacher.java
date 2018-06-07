package application.com.entities;

import application.com.enums.TeacherStatus;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "teacher_tbl")
public class Teacher implements Serializable {

    public Teacher(){
        super();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "teacher_rec_id", nullable = false)
    private int recId;

//    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_id", unique = true, referencedColumnName = "user_id")
//    private UserRole userRoles;

    @Column(name = "user_id", unique = true)
    private String userId;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "display_name")
    private String displayName;

    @Column(name = "plan_id")
    private String planId;

    @Column(name = "registration_date")
    private Date registrationDate;

    @Column(name = "registration_expiration_date")
    private Date registrationExpirationDate;

    @Column(name = "billing_frequency")
    private String billingFrequency;

    @Column(name = "billing_status")
    private String billingStatus;

    @Column(name = "billing_transaction_response")
    private String billingTransactionResponse;

    @Column(name = "billing_transaction_date")
    private Date billingTransactionDate;


    @Column(name = "billing_amount")
    private float billingAmount;

    @Column(name = "school_id")
    private String schoolId;

    @Column(name = "school_name")
    private String schoolName;

    @Column(name = "school_address1")
    private String schoolAddress1;

    @Column(name = "school_address2")
    private String schoolAddress2;

    @Column(name = "school_address_city")
    private String schoolAddressCity;

    @Column(name = "school_address_state")
    private String schoolAddressState;

    @Column(name = "school_address_zip")
    private int schoolAddressZip;

    @Column(name = "teacher_title")
    private String teacherTitle;

    @Column(name = "teacher_security_question1")
    private String teacherSecurityQuestion1;

    @Column(name = "teacher_security_question2")
    private String teacherSecurityQuestion2;

    @Column(name = "teacher_security_question3")
    private String teacherSecurityQuestion3;

    @Column(name = "teacher_security_answer1")
    private String teacherSecurityAnswer1;

    @Column(name = "teacher_security_answer2")
    private String teacherSecurityAnswer2;

    @Column(name = "teacher_security_answer3")
    private String teacherSecurityAnswer3;

    @Enumerated(EnumType.STRING)
    @Column(name = "teacher_status")
    private TeacherStatus teacherStatus;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public TeacherStatus getTeacherStatus() {
        return teacherStatus;
    }

    public void setTeacherStatus(TeacherStatus teacherStatus) {
        this.teacherStatus = teacherStatus;
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
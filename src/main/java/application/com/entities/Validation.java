package application.com.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "validation_tbl")
public class Validation {
	
	public Validation() {
		super();
	}
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "validation_rec_id", nullable = false)
	private String recId;
	
	@Column(name = "validation_id", unique = true)
	private String validationId;
	
	@Column(name = "user_id")
	private String userId;
	
	@Column(name = "user_type")
	private String userType;
	
	@Column(name = "validation_effective_date")
	private Date validationEffectiveDate;
	
	@Column(name = "validation_expiration_date")
	private Date validationExpirationDate;
	
	@Column(name = "category")
	private String category;
	
	@Column(name = "validation_type")
	private String validationType;
	
	@Column(name = "validation_description")
	private String validationDescription;
	
	@Column(name = "validation_name")
	private String validationName;
	
	@Column(name = "validation_value")
	private String validationValue;
	
	@Column(name = "validation_date_type")
	private String validationDateType;
	
	@Column(name = "validation_rule")
	private String validationRule;
	
	@Column(name = "validation_tolerance")
	private String validationTolerance;
	
	
	public String getValidationId() {
		return validationId;
	}
	public void setValidationId(String validationId) {
		this.validationId = validationId;
	}
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
	public Date getValidationEffectiveDate() {
		return validationEffectiveDate;
	}
	public void setValidationEffectiveDate(Date validationEffectiveDate) {
		this.validationEffectiveDate = validationEffectiveDate;
	}
	
	public Date getValidationExpirationDate() {
		return validationExpirationDate;
	}
	public void setValidationExpirationDate(Date validationExpirationDate) {
		this.validationExpirationDate = validationExpirationDate;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getValidationType() {
		return validationType;
	}
	public void setValidationType(String validationType) {
		this.validationType = validationType;
	}
	public String getValidationDescription() {
		return validationDescription;
	}
	public void setValidationDescription(String validationDescription) {
		this.validationDescription = validationDescription;
	}
	public String getValidationName() {
		return validationName;
	}
	public void setValidationName(String validationName) {
		this.validationName = validationName;
	}
	public String getValidationValue() {
		return validationValue;
	}
	public void setValidationValue(String validationValue) {
		this.validationValue = validationValue;
	}
	public String getValidationDateType() {
		return validationDateType;
	}
	public void setValidationDateType(String validationDateType) {
		this.validationDateType = validationDateType;
	}
	public String getValidationRule() {
		return validationRule;
	}
	public void setValidationRule(String validationRule) {
		this.validationRule = validationRule;
	}
	public String getValidationTolerance() {
		return validationTolerance;
	}
	public void setValidationTolerance(String validationTolerance) {
		this.validationTolerance = validationTolerance;
	}
	
	

}

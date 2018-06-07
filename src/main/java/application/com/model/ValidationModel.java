package application.com.model;

import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;
import java.util.Date;

public class ValidationModel implements Serializable {

	@NotEmpty(message = "Validation Id can not be empty")
	private String validationId;
	@NotEmpty(message = "User Id can not be empty")
	private String userId;
	private String userType;
	private Date validationEffectiveDate;
	private Date validationExpirationDate;
	private String category;
	private String validationType;
	private String validationDescription;
	private String validationName;
	private String validationValue;
	private String validationDateType;
	private String validationRule;
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

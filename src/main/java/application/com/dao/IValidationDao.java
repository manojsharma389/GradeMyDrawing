package application.com.dao;

import application.com.model.ValidationModel;

public interface IValidationDao {
	
	public void add(ValidationModel validationModel);
	
	public void update(ValidationModel validationModel);
	
	public void delete(String validationId);
	
	public ValidationModel fetchByAssignmentId(String assignmentId, ValidationModel validationModel);

}

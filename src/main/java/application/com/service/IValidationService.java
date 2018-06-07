package application.com.service;

import application.com.model.ValidationModel;

public interface IValidationService {
	
	public void add(ValidationModel validationModel);
	
	public void update(ValidationModel validationModel);
	
	public void delete(String validationId);
	
	public ValidationModel fetchByAssignmentId(String assignmentId, ValidationModel validationModel);

}

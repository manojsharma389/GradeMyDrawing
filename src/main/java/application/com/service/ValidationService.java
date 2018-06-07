package application.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import application.com.dao.IValidationDao;
import application.com.model.ValidationModel;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ValidationService implements IValidationService {
	
	@Autowired
	IValidationDao validationDao;
	
	public void add(ValidationModel validationModel) {
		validationDao.add(validationModel);
	}
	
	public void update(ValidationModel validationModel) {
		validationDao.update(validationModel);
	}
	
	public void delete(String validationId) {
		validationDao.delete(validationId);
	}
	
	public ValidationModel fetchByAssignmentId(String assignmentId, ValidationModel validationModel) {
		return validationDao.fetchByAssignmentId(assignmentId, validationModel);
	}

}

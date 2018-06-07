package application.com.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import application.com.entities.Validation;
import application.com.genericHibernateClient.GenericHibernateClient;
import application.com.model.ValidationModel;

@Repository
public class ValidationDaoImpl extends GenericHibernateClient<Validation, String> implements IValidationDao {

	@Transactional
	public void add(ValidationModel validationModel) {
		Validation validation = new Validation();
		create(modelToValidation(validationModel, validation));
	}
	
	@Transactional
	public void update(ValidationModel validationModel) {
		Validation validation = fetchByAssignmentId
				(validationModel.getValidationId());
		update(modelToValidation(validationModel, validation));
	}
	
	@Transactional
	public void delete(String validationId) {
		Validation validation = fetchByAssignmentId(validationId);
		delete(validation);
	}
	
	public Validation fetchByAssignmentId(String assignmentId) {
		Criterion criterion =  Restrictions.eq("assignmentId", assignmentId);
        List<Validation> validations = findByCriteria(criterion);
        return validations!=null ? validations.get(0): null;
	}
	
	public ValidationModel fetchByAssignmentId(String assignmentId, ValidationModel validationModel) {
		Validation validation = fetchByAssignmentId(assignmentId);
		return validationToModel(validationModel, validation);	
	}
	
	public Validation modelToValidation(ValidationModel validationModel, 
			Validation validation) {
		if(validation != null && validationModel != null) {
			validation = (Validation) CopyProperties.copyNotNullProperties(validationModel, validation);
		}
		//BeanUtils.copyProperties(validationModel, validation);
        return validation;
	}
	
	public ValidationModel validationToModel(ValidationModel validationModel, 
			Validation validation) {
        if(validation != null && validationModel != null) {
            validationModel = (ValidationModel) CopyProperties.copyNotNullProperties(validation, validationModel);
        }
		//BeanUtils.copyProperties(validation, validationModel);
        return validationModel;
	}
	
}

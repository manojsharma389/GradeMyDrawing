package application.com.dao;

import java.io.IOException;
import java.util.List;


import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import application.com.entities.StudentAssignments;
import application.com.genericHibernateClient.GenericHibernateClient;
import application.com.model.StudentAssignmentModel;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class StudentAssignmentDaoImpl extends GenericHibernateClient<StudentAssignments, String> implements IStudentAssignmentDao {
	
	@Transactional
	public void add(StudentAssignmentModel studentAssignmentModel) {
		StudentAssignments studentAssignments = new StudentAssignments();
		create(modelToStudentAssignments(studentAssignmentModel, studentAssignments));
	}
	
	@Transactional
	public void update(StudentAssignmentModel studentAssignmentModel) {
		StudentAssignments studentAssignments = fetchByUserIdAndAssignmentId(studentAssignmentModel.getUserId(), 
				studentAssignmentModel.getAssignmentId());
		update(modelToStudentAssignments(studentAssignmentModel, studentAssignments));
	}
	
	@Transactional
	public void delete(String userId, String assignmentId) {
		StudentAssignments studentAssignments = fetchByUserIdAndAssignmentId(userId, assignmentId);
		delete(studentAssignments);
	}

    @Transactional
    public void deleteAssignment(String userId, String assignmentId){
        StudentAssignments studentAssignment = fetchByUserIdAndAssignmentId(userId, assignmentId);
        studentAssignment.setStudentStepFile(null);
        update(studentAssignment);
    }

	public StudentAssignments fetchByUserIdAndAssignmentId(String userId, String assignmentId) {
		Criterion criterion1 =  Restrictions.eq("userId", userId);
		Criterion criterion2 =  Restrictions.eq("assignmentId", assignmentId);
        List<StudentAssignments> studentAssignmentsList = findByCriteria(criterion1, criterion2);
        return studentAssignmentsList!=null ? studentAssignmentsList.get(0): null;
	}
	
	public StudentAssignmentModel fetchByUserIdAndAssignmentId(String userId, 
			String assignmentId, StudentAssignmentModel StudentAssignmentModelList) {
		StudentAssignments studentAssignments = fetchByUserIdAndAssignmentId(userId, assignmentId);
		StudentAssignmentModel studentAssignmentModel = new StudentAssignmentModel();
		return studentAssignmentsToModel(studentAssignmentModel, studentAssignments);
		
	}

    public byte[] fetchStudentStepFile(String userId, String assignmentId){
        StudentAssignments studentAssignments = fetchByUserIdAndAssignmentId(userId, assignmentId);
        return null != studentAssignments ? studentAssignments.getStudentStepFile() : null;
    }
	
	public List<StudentAssignments> fetchByUserId(String userId) {
		Criterion criterion =  Restrictions.eq("userId", userId);
        List<StudentAssignments> studentAssignmentsList = findByCriteria(criterion);
        return studentAssignmentsList!=null ? studentAssignmentsList: null;
	}
	
	public List<StudentAssignmentModel> fetchByUserId(String userId, 
			List<StudentAssignmentModel> StudentAssignmentModelList) {
		
		List<StudentAssignments> studentAssignmentsList = fetchByUserId(userId);
		StudentAssignmentModel studentAssignmentModel = null;
		for (StudentAssignments studentAssignments : studentAssignmentsList) {
			studentAssignmentModel = new StudentAssignmentModel();
			StudentAssignmentModelList.add(studentAssignmentsToModel
					(studentAssignmentModel, studentAssignments));
		}
		return StudentAssignmentModelList;
	}
	
	public StudentAssignments modelToStudentAssignments(StudentAssignmentModel studentAssignmentModel, 
			StudentAssignments studentAssignments){
		try {
			if (null != studentAssignmentModel && null != studentAssignments) {
				studentAssignments = (StudentAssignments) CopyProperties.copyNotNullProperties
						(studentAssignmentModel, studentAssignments);
				//BeanUtils.copyProperties(studentAssignmentModel, studentAssignments);

				if (studentAssignmentModel.getStudentStepFile() != null) {
					studentAssignments.setStudentStepFile(studentAssignmentModel.
							getStudentStepFile().getBytes());
				}

			}
		} catch (IOException e) {
			throw new RuntimeException("Not able to read file from database", e);
		}
        return studentAssignments;
    }
	
	public StudentAssignmentModel studentAssignmentsToModel(StudentAssignmentModel studentAssignmentModel, 
			StudentAssignments studentAssignments){
		if(null != studentAssignmentModel && null != studentAssignments) {
			studentAssignmentModel = (StudentAssignmentModel) CopyProperties.copyNotNullProperties
					(studentAssignments, studentAssignmentModel);
			//BeanUtils.copyProperties(studentAssignments, studentAssignmentModel);
		}

        return studentAssignmentModel;
    }

}

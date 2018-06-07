package application.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import application.com.dao.IStudentAssignmentDao;
import application.com.model.StudentAssignmentModel;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class StudentAssignmentService implements IStudentAssignmentService{
	
	@Autowired
	IStudentAssignmentDao studentAssignmentDao;
	
	public void add(StudentAssignmentModel studentAssignmentModel) {
		studentAssignmentDao.add(studentAssignmentModel);
	}
	
	public void update(StudentAssignmentModel studentAssignmentModel) {
		studentAssignmentDao.update(studentAssignmentModel);
	}
	
	public void delete(String userId, String assignmentId) {
		studentAssignmentDao.delete(userId, assignmentId);
	}
	
	public List<StudentAssignmentModel> fetchByUserId(String userId, 
			List<StudentAssignmentModel> StudentAssignmentModelList){
		return studentAssignmentDao.fetchByUserId(userId, StudentAssignmentModelList);
	}
	
	public StudentAssignmentModel fetchByUserIdAndAssignmentId(String userId, 
			String assignmentId, StudentAssignmentModel StudentAssignmentModel){
		return studentAssignmentDao.fetchByUserIdAndAssignmentId(userId, 
				assignmentId, StudentAssignmentModel);
	}
	public void deleteAssignment(String userId, String assignmentId){
		studentAssignmentDao.deleteAssignment(userId, assignmentId);
	}

	public byte[] fetchStudentStepFile(String userId, String assignmentId){
		return studentAssignmentDao.fetchStudentStepFile(userId, assignmentId);
	}
	
}

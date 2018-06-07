package application.com.dao;

import java.io.IOException;
import java.util.List;

import application.com.model.StudentAssignmentModel;

public interface IStudentAssignmentDao {
	
	public void add(StudentAssignmentModel studentAssignmentModel);
	
	public void update(StudentAssignmentModel studentAssignmentModel);
	
	public void delete(String userId, String assignmentId);
	
	public List<StudentAssignmentModel> fetchByUserId(String userId, 
			List<StudentAssignmentModel> StudentAssignmentModelList);
	
	public StudentAssignmentModel fetchByUserIdAndAssignmentId(String userId, 
			String assignmentId, StudentAssignmentModel StudentAssignmentModelList);

	public void deleteAssignment(String userId, String assignmentId);

	public byte[] fetchStudentStepFile(String userId, String assignmentId);

}

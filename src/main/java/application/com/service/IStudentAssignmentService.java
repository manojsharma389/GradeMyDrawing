package application.com.service;

import java.util.List;

import application.com.model.StudentAssignmentModel;

public interface IStudentAssignmentService {

	public void add(StudentAssignmentModel studentAssignmentModel);
	
	public void update(StudentAssignmentModel studentAssignmentModel);
	
	public void delete(String userId, String assignmentId);
	
	public List<StudentAssignmentModel> fetchByUserId(String userId, 
			List<StudentAssignmentModel> StudentAssignmentModelList);
	
	public StudentAssignmentModel fetchByUserIdAndAssignmentId(String userId, 
			String assignmentId, StudentAssignmentModel StudentAssignmentModel);

	public void deleteAssignment(String userId, String assignmentId);

	public byte[] fetchStudentStepFile(String userId, String assignmentId);
	
}

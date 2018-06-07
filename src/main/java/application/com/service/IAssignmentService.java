package application.com.service;

import application.com.model.AssignmentModel;

import java.util.List;

public interface IAssignmentService {

    public void add(AssignmentModel assignmentModel);
    public void update(AssignmentModel assignmentModel);
    public void delete(String assignmentId);
    public AssignmentModel fetchByAssignmentId(String assignmentId,
                                               AssignmentModel assignmentModel);
    public List<AssignmentModel> fetchByClassId(String classId,
                                                List<AssignmentModel> assignmentModelList);
    public void deleteAssignment(String assignmentId);
    public byte[] fetchMasterStepFile(String assignmentId);

}

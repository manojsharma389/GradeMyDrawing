package application.com.service;

import application.com.dao.IAssignmentDao;
import application.com.model.AssignmentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AssignmentService implements IAssignmentService {
    @Autowired
    IAssignmentDao assignmentDao;

    public void add(AssignmentModel assignmentModel){
        assignmentDao.add(assignmentModel);
    }
    public void update(AssignmentModel assignmentModel){
        assignmentDao.update(assignmentModel);
    }
    public void delete(String assignmentId){
        assignmentDao.delete(assignmentId);
    }
    public AssignmentModel fetchByAssignmentId(String assignmentId,
                                               AssignmentModel assignmentModel){
        return assignmentDao.fetchByAssignmentId(assignmentId, assignmentModel);
    }

    public List<AssignmentModel> fetchByClassId(String classId,
                                                List<AssignmentModel> assignmentModelList){
        return assignmentDao.fetchByClassId(classId, assignmentModelList);
    }

    public void deleteAssignment(String assignmentId){
        assignmentDao.deleteAssignment(assignmentId);
    }

    public byte[] fetchMasterStepFile(String assignmentId){
        return assignmentDao.fetchMasterStepFile(assignmentId);
    }
}

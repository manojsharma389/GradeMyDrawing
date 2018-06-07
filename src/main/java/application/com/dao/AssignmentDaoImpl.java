package application.com.dao;

import application.com.entities.CADClass;
import application.com.genericHibernateClient.GenericHibernateClient;
import application.com.model.ClassModel;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import application.com.entities.Assignment;
import application.com.enums.AssignmentStatus;
import application.com.model.AssignmentModel;

import javax.imageio.IIOException;
import javax.transaction.Transactional;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Repository
public class AssignmentDaoImpl extends GenericHibernateClient<Assignment, String> implements IAssignmentDao {

    @Autowired
    ICadClassDao cadClassDao;

    @Transactional
    public void add(AssignmentModel assignmentModel){
        Assignment assignment = new Assignment();
        CADClass cadClass = cadClassDao.getByClassId(assignmentModel.getClassId());
        modelToAssignment(assignmentModel, assignment);
        assignment.setCadClass(cadClass);
        create(assignment);
    }

    @Transactional
    public void update(AssignmentModel assignmentModel){
        Assignment assignment = fetchByAssignmentId(assignmentModel.getAssignmentId());
        update(modelToAssignment(assignmentModel, assignment));
    }
    public void delete(String assignmentId){
        Assignment assignment = fetchByAssignmentId(assignmentId);
        delete(assignment);
    }

    public AssignmentModel fetchByAssignmentId(String assignmentId,
                                               AssignmentModel assignmentModel){
        Assignment assignment = fetchByAssignmentId(assignmentId);
        return assignmentToModel(assignmentModel, assignment);

    }

    public byte[] fetchMasterStepFile(String assignmentId){
        Assignment assignment = fetchByAssignmentId(assignmentId);
        return null != assignment ? assignment.getAssignmentMasterStep() : null;
    }

    public Assignment fetchByAssignmentId(String assignmentId){
        Criterion criterion =  Restrictions.eq("assignmentId", assignmentId);
        List<Assignment> assignmentList = findByCriteria(criterion);
        return assignmentList!=null ? assignmentList.get(0): null;
    }

    public List<AssignmentModel> fetchByClassId(String classId,
                                                List<AssignmentModel> assignmentModelList){
        Criterion criterion =  Restrictions.eq("classId", classId);
        List<Assignment> assignmentList = findByCriteria(criterion);
         AssignmentModel assignmentModel = null;
        for (Assignment assignment : assignmentList) {
            assignmentModel = new AssignmentModel();
            assignmentModelList.add(assignmentToModel(assignmentModel, assignment));
        }
        return assignmentModelList;
    }

    @Transactional
    public void deleteAssignment(String assignmentId){
        Assignment assignment = fetchByAssignmentId(assignmentId);
        assignment.setAssignmentMasterStep(null);
        update(assignment);
    }

    public AssignmentModel assignmentToModel(AssignmentModel assignmentModel, Assignment assignment){
        if(null != assignmentModel && null!= assignment) {
            assignmentModel = (AssignmentModel) CopyProperties.copyNotNullProperties(assignment, assignmentModel);
            //BeanUtils.copyProperties(assignment, assignmentModel);
            assignmentModel.setAssignmentStatus(assignment.getAssignmentStatus().toString());
        }
        return assignmentModel;
    }

    public Assignment modelToAssignment(AssignmentModel assignmentModel, Assignment assignment){
//        BeanUtils.copyProperties(assignmentModel, assignment);
        if(null != assignmentModel && null!= assignment) {
            try {
                assignment = (Assignment) CopyProperties.copyNotNullProperties(assignmentModel, assignment);

                if ("ACTIVE".equalsIgnoreCase(assignmentModel.getAssignmentStatus())) {
                    assignment.setAssignmentStatus(AssignmentStatus.ACTIVE);
                } else if ("INACTIVE".equalsIgnoreCase(assignmentModel.getAssignmentStatus())) {
                    assignment.setAssignmentStatus(AssignmentStatus.INACTIVE);
                } else if ("CANCELLED".equalsIgnoreCase(assignmentModel.getAssignmentStatus())) {
                    assignment.setAssignmentStatus(AssignmentStatus.CANCELLED);
                }
                if (assignmentModel.getAssignmentMasterStep() != null) {
                    assignment.setAssignmentMasterStep(assignmentModel.getAssignmentMasterStep().getBytes());
                }
            } catch (IOException e) {
                throw new RuntimeException("not able to read file from database", e);
            }
        }
        return assignment;
    }
}

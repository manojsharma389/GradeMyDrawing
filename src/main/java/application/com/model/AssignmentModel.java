package application.com.model;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.sql.Clob;
import java.util.Date;

public class AssignmentModel implements Serializable {

    @NotEmpty(message = "Assignment Id can not be empty")
    private String assignmentId;
    @NotEmpty(message = "Class Id can not be empty")
    private String classId;
    private String designationType;
    private String assignmentName;
    private String assignmentTopic;
    private String assignmentDescription;
    private Date assignmentDate;
    private Date assignmentDueDate;
    private Date assignmentLateDate;
    private int assignmentMaxPoints;
    private int assignmentMinPoints;
    private MultipartFile assignmentMasterStep;
    private String assignmentStatus;
    private Date createdDate;
    private String createdBy;
    private Date modifiedDate;
    private String modifiedBy;

    public String getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(String assignmentId) {
        this.assignmentId = assignmentId;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getDesignationType() {
        return designationType;
    }

    public void setDesignationType(String designationType) {
        this.designationType = designationType;
    }

    public String getAssignmentName() {
        return assignmentName;
    }

    public void setAssignmentName(String assignmentName) {
        this.assignmentName = assignmentName;
    }

    public String getAssignmentTopic() {
        return assignmentTopic;
    }

    public void setAssignmentTopic(String assignmentTopic) {
        this.assignmentTopic = assignmentTopic;
    }

    public String getAssignmentDescription() {
        return assignmentDescription;
    }

    public void setAssignmentDescription(String assignmentDescription) {
        this.assignmentDescription = assignmentDescription;
    }

    public Date getAssignmentDate() {
        return assignmentDate;
    }

    public void setAssignmentDate(Date assignmentDate) {
        this.assignmentDate = assignmentDate;
    }

    public Date getAssignmentDueDate() {
        return assignmentDueDate;
    }

    public void setAssignmentDueDate(Date assignmentDueDate) {
        this.assignmentDueDate = assignmentDueDate;
    }

    public Date getAssignmentLateDate() {
        return assignmentLateDate;
    }

    public void setAssignmentLateDate(Date assignmentLateDate) {
        this.assignmentLateDate = assignmentLateDate;
    }

    public int getAssignmentMaxPoints() {
        return assignmentMaxPoints;
    }

    public void setAssignmentMaxPoints(int assignmentMaxPoints) {
        this.assignmentMaxPoints = assignmentMaxPoints;
    }

    public int getAssignmentMinPoints() {
        return assignmentMinPoints;
    }

    public void setAssignmentMinPoints(int assignmentMinPoints) {
        this.assignmentMinPoints = assignmentMinPoints;
    }

    public MultipartFile getAssignmentMasterStep() {
        return assignmentMasterStep;
    }

    public void setAssignmentMasterStep(MultipartFile assignmentMasterStep) {
        this.assignmentMasterStep = assignmentMasterStep;
    }

    public String getAssignmentStatus() {
        return assignmentStatus;
    }

    public void setAssignmentStatus(String assignmentStatus) {
        this.assignmentStatus = assignmentStatus;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }
}

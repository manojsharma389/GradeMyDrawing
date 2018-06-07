package application.com.entities;


import application.com.enums.AssignmentStatus;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Clob;
import java.util.Date;

@Entity
@Table(name = "assignment_tbl")
public class Assignment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "assignment_rec_id", nullable = false)
    private  int recId;

    @Column(name = "assignment_id", unique = true)
    private String assignmentId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "class_id", referencedColumnName = "class_id")
    private CADClass cadClass;

    @Column(name = "designation_type")
    private String designationType;

    @Column(name = "assignment_name")
    private String assignmentName;

    @Column(name = "assignment_topic")
    private String assignmentTopic;

    @Column(name = "assignment_description")
    private String assignmentDescription;

    @Column(name = "assignment_date")
    private Date assignmentDate;

    @Column(name = "assignment_due_date")
    private Date assignmentDueDate;

    @Column(name = "assignment_late_date")
    private Date assignmentLateDate;

    @Column(name = "assignment_max_points")
    private int assignmentMaxPoints;

    @Column(name = "assignment_min_points")
    private int assignmentMinPoints;

    @Lob
    @Column(name = "assignment_master_step")
    private byte[] assignmentMasterStep;

    @Enumerated(EnumType.STRING)
    @Column(name = "assignment_status")
    private AssignmentStatus assignmentStatus;

    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "modified_date")
    private Date modifiedDate;

    @Column(name = "modified_by")
    private String modifiedBy;

    public int getRecId() {
        return recId;
    }

    public void setRecId(int recId) {
        this.recId = recId;
    }

    public String getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(String assignmentId) {
        this.assignmentId = assignmentId;
    }

    public CADClass getCadClass() {
        return cadClass;
    }

    public void setCadClass(CADClass cadClass) {
        this.cadClass = cadClass;
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

    public byte[] getAssignmentMasterStep() {
        return assignmentMasterStep;
    }

    public void setAssignmentMasterStep(byte[] assignmentMasterStep) {
        this.assignmentMasterStep = assignmentMasterStep;
    }

    public AssignmentStatus getAssignmentStatus() {
        return assignmentStatus;
    }

    public void setAssignmentStatus(AssignmentStatus assignmentStatus) {
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

package application.com.entities;


import javax.persistence.*;
import java.io.Serializable;
import java.sql.Clob;
import java.util.Date;

@Entity
@Table(name = "student_assignments_tbl")
public class StudentAssignments implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_assignments_rec_id", nullable = false)
    private int recId;

//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
//    private Student student;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "user_type")
    private String userType;

    @Column(name = "assignment_id")
    private String assignmentId;

    @Column(name = "sequence_number")
    private int sequenceNumber;

    @Lob
    @Column(name = "student_step_file")
    private byte[] studentStepFile;

    @Column(name = "submit_date")
    private Date submitDate;

    @Column(name = "compare_count")
    private int compareCount;

    @Column(name = "grade")
    private int grade;

    @Column(name = "teacher_comments")
    private String teacherComments;

    @Column(name = "student_comments")
    private String studentComments;

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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(String assignmentId) {
        this.assignmentId = assignmentId;
    }

    public int getSequenceNumber() {
        return sequenceNumber;
    }

    public void setSequenceNumber(int sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }

    public byte[] getStudentStepFile() {
        return studentStepFile;
    }

    public void setStudentStepFile(byte[] studentStepFile) {
        this.studentStepFile = studentStepFile;
    }

    public Date getSubmitDate() {
        return submitDate;
    }

    public void setSubmitDate(Date submitDate) {
        this.submitDate = submitDate;
    }

    public int getCompareCount() {
        return compareCount;
    }

    public void setCompareCount(int compareCount) {
        this.compareCount = compareCount;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getTeacherComments() {
        return teacherComments;
    }

    public void setTeacherComments(String teacherComments) {
        this.teacherComments = teacherComments;
    }

    public String getStudentComments() {
        return studentComments;
    }

    public void setStudentComments(String studentComments) {
        this.studentComments = studentComments;
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

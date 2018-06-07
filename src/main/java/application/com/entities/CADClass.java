package application.com.entities;


import application.com.enums.ClassStatus;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Clob;
import java.util.Date;

@Entity
@Table(name = "class_tbl")
public class CADClass implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "class_rec_id", nullable = false)
    private int recId;

//    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JoinColumn(name = "class_id", referencedColumnName = "class_id")
//    private ClassRegistryService classRegistry;

    @Column(name = "class_id", unique = true)
    private String classId;

    @Column(name = "school_id")
    private String schoolId;

    @Column(name = "class_name")
    private String className;

    @Column(name = "class_topic")
    private String classTopic;

    @Column(name = "class_description")
    private String classDescription;

    @Column(name = "class_syllabus")
    private Clob classSyllabus;

    @Column(name = "class_period")
    private String classPeriod;

    @Column(name = "class_time")
    private Date classTime;

    @Column(name = "enrolled_students")
    private int enrolledStudents;

    @Column(name = "registered_student")
    private int registeredStudent;

    @Enumerated(EnumType.STRING)
    @Column(name = "class_status")
    private ClassStatus classStatus;

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

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getClassTopic() {
        return classTopic;
    }

    public void setClassTopic(String classTopic) {
        this.classTopic = classTopic;
    }

    public String getClassDescription() {
        return classDescription;
    }

    public void setClassDescription(String classDescription) {
        this.classDescription = classDescription;
    }

    public Clob getClassSyllabus() {
        return classSyllabus;
    }

    public void setClassSyllabus(Clob classSyllabus) {
        this.classSyllabus = classSyllabus;
    }

    public String getClassPeriod() {
        return classPeriod;
    }

    public void setClassPeriod(String classPeriod) {
        this.classPeriod = classPeriod;
    }

    public Date getClassTime() {
        return classTime;
    }

    public void setClassTime(Date classTime) {
        this.classTime = classTime;
    }

    public int getEnrolledStudents() {
        return enrolledStudents;
    }

    public void setEnrolledStudents(int enrolledStudents) {
        this.enrolledStudents = enrolledStudents;
    }

    public int getRegisteredStudent() {
        return registeredStudent;
    }

    public void setRegisteredStudent(int registeredStudent) {
        this.registeredStudent = registeredStudent;
    }

    public ClassStatus getClassStatus() {
        return classStatus;
    }

    public void setClassStatus(ClassStatus classStatus) {
        this.classStatus = classStatus;
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

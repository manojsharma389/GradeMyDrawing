package application.com.entities;


import javax.persistence.*;
import java.io.Serializable;
import java.sql.Clob;
import java.util.Date;

@Entity
@Table(name = "audit_tbl")
public class Audit  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "audit_rec_id", nullable = false)
    private int recId;

    @Column(name = "sequence_number")
    private int sequenceNumber;

    @Column(name = "date_time")
    private Date dateTime;

    @Column(name = "class_id")
    private String classId;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "user_type")
    private String userType;

    @Column(name = "action_id")
    private String actionId;

    @Column(name = "action_type")
    private String actionType;

    @Lob
    @Column(name = "audit_data")
    private Clob auditDate;

    @Column(name = "audit_result")
    private String auditResult;

    @Column(name = "audit_result_details")
    private String auditResultDetails;

    public int getRecId() {
        return recId;
    }

    public void setRecId(int recId) {
        this.recId = recId;
    }

    public int getSequenceNumber() {
        return sequenceNumber;
    }

    public void setSequenceNumber(int sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
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

    public String getActionId() {
        return actionId;
    }

    public void setActionId(String actionId) {
        this.actionId = actionId;
    }

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    public Clob getAuditDate() {
        return auditDate;
    }

    public void setAuditDate(Clob auditDate) {
        this.auditDate = auditDate;
    }

    public String getAuditResult() {
        return auditResult;
    }

    public void setAuditResult(String auditResult) {
        this.auditResult = auditResult;
    }

    public String getAuditResultDetails() {
        return auditResultDetails;
    }

    public void setAuditResultDetails(String auditResultDetails) {
        this.auditResultDetails = auditResultDetails;
    }
}

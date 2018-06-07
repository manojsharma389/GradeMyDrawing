package application.com.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "user_preference_tbl")
public class UserPreference implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_preference_rec_id", nullable = false)
    private int recId;

    @Column(name = "preference_id", unique = true)
    private String preferenceId;

//    @Column(name = "preference_type")
//    private String preferenceType;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "preference_type", referencedColumnName = "look_up_key")
    private LookUp lookUp;

//    @Column(name = "user_id")
//    private String userId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private Teacher teacher;

    @Column(name = "user_type")
    private String userType;

    @Column(name = "preference_description")
    private String preferenceDescription;

    @Column(name = "preference_value")
    private String preferenceValue;

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

    public String getPreferenceId() {
        return preferenceId;
    }

    public void setPreferenceId(String preferenceId) {
        this.preferenceId = preferenceId;
    }

    public LookUp getLookUp() {
        return lookUp;
    }

    public void setLookUp(LookUp lookUp) {
        this.lookUp = lookUp;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getPreferenceDescription() {
        return preferenceDescription;
    }

    public void setPreferenceDescription(String preferenceDescription) {
        this.preferenceDescription = preferenceDescription;
    }

    public String getPreferenceValue() {
        return preferenceValue;
    }

    public void setPreferenceValue(String preferenceValue) {
        this.preferenceValue = preferenceValue;
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

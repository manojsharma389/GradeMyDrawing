package application.com.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "look_up_tbl")
public class LookUp implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "look_up_rec_id", nullable = false)
    private int recId;

    @Column(name = "look_up_key", unique = true)
    private String lookUpKey;

    @Column(name = "look_up_value")
    private String lookUpValue;

    @Column(name = "look_up_description")
    private String lookUpDescription;

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

    public String getLookUpKey() {
        return lookUpKey;
    }

    public void setLookUpKey(String lookUpKey) {
        this.lookUpKey = lookUpKey;
    }

    public String getLookUpValue() {
        return lookUpValue;
    }

    public void setLookUpValue(String lookUpValue) {
        this.lookUpValue = lookUpValue;
    }

    public String getLookUpDescription() {
        return lookUpDescription;
    }

    public void setLookUpDescription(String lookUpDescription) {
        this.lookUpDescription = lookUpDescription;
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

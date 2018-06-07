package application.com.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Clob;
import java.util.Date;

@Entity
@Table(name = "data_files_tbl")
public class DataFiles implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "data_files_rec_id", nullable = false)
    private int recId;

    @Column(name = "data_file_id", unique = true)
    private String dataFileId;

    @Column(name = "data_file_type")
    private String dataFileType;

    @Column(name = "sequence_number")
    private int sequenceNumber;

    @Lob
    @Column(name = "data_file")
    private Clob dataFile;

    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "modified_date")
    private Date modifiedDate;

    @Column(name = "modified_by")
    private String modifiedBy;

    @Column(name = "user_id")
    private String userId;

    public int getRecId() {
        return recId;
    }

    public void setRecId(int recId) {
        this.recId = recId;
    }

    public String getDataFileId() {
        return dataFileId;
    }

    public void setDataFileId(String dataFileId) {
        this.dataFileId = dataFileId;
    }

    public String getDataFileType() {
        return dataFileType;
    }

    public void setDataFileType(String dataFileType) {
        this.dataFileType = dataFileType;
    }

    public int getSequenceNumber() {
        return sequenceNumber;
    }

    public void setSequenceNumber(int sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }

    public Clob getDataFile() {
        return dataFile;
    }

    public void setDataFile(Clob dataFile) {
        this.dataFile = dataFile;
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}

package application.com.entities;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "pricing_tbl")
public class Pricing implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pricing_rec_id", nullable = false)
    private int recId;

    @Column(name = "pricing_key", unique = true)
    private String pricingKey;

    @Column(name = "pricing_value")
    private String pricingValue;

    @Column(name = "pricing_description")
    private String pricingDescription;

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

    public String getPricingKey() {
        return pricingKey;
    }

    public void setPricingKey(String pricingKey) {
        this.pricingKey = pricingKey;
    }

    public String getPricingValue() {
        return pricingValue;
    }

    public void setPricingValue(String pricingValue) {
        this.pricingValue = pricingValue;
    }

    public String getPricingDescription() {
        return pricingDescription;
    }

    public void setPricingDescription(String pricingDescription) {
        this.pricingDescription = pricingDescription;
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

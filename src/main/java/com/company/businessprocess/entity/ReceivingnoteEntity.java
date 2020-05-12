package com.company.businessprocess.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "receivingnote", schema = "companytest", catalog = "")
public class ReceivingnoteEntity {
    private Integer receiveId;
    private Date receiveDate;
    private Integer productOrderId;
    private StaffEntity staffByStaffId;
    private ProviderEntity providerByProviderId;
    private Collection<ReceivingnotedetailEntity> receivingnotedetailsByReceiveId;

    @Id
    @Column(name = "receiveId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getReceiveId() {
        return receiveId;
    }

    public void setReceiveId(Integer receiveId) {
        this.receiveId = receiveId;
    }

    @Basic
    @Column(name = "receiveDate")
    public Date getReceiveDate() {
        return receiveDate;
    }

    public void setReceiveDate(Date receiveDate) {
        this.receiveDate = receiveDate;
    }

    @Basic
    @Column(name = "productOrderId", nullable = false, unique = true)

    public Integer getProductOrderId() {
        return productOrderId;
    }

    public void setProductOrderId(Integer productId) {
        this.productOrderId = productId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReceivingnoteEntity that = (ReceivingnoteEntity) o;
        return Objects.equals(receiveId, that.receiveId) &&
                Objects.equals(receiveDate, that.receiveDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(receiveId, receiveDate);
    }

    @ManyToOne
    @JoinColumn(name = "staffId", referencedColumnName = "staffId", nullable = false)
    public StaffEntity getStaffByStaffId() {
        return staffByStaffId;
    }

    public void setStaffByStaffId(StaffEntity staffByStaffId) {
        this.staffByStaffId = staffByStaffId;
    }

    @ManyToOne
    @JoinColumn(name = "providerId", referencedColumnName = "providerId", nullable = false)
    public ProviderEntity getProviderByProviderId() {
        return providerByProviderId;
    }

    public void setProviderByProviderId(ProviderEntity providerByProviderId) {
        this.providerByProviderId = providerByProviderId;
    }

    @OneToMany(mappedBy = "receivingnoteByReceiveId")
    public Collection<ReceivingnotedetailEntity> getReceivingnotedetailsByReceiveId() {
        return receivingnotedetailsByReceiveId;
    }

    public void setReceivingnotedetailsByReceiveId(Collection<ReceivingnotedetailEntity> receivingnotedetailsByReceiveId) {
        this.receivingnotedetailsByReceiveId = receivingnotedetailsByReceiveId;
    }
}

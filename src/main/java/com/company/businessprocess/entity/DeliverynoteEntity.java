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
@Table(name = "deliverynote", schema = "companytest", catalog = "")
public class DeliverynoteEntity {
    private Integer deliveryId;
    private Date saleDate;
    private CustomerEntity customerByCustomerId;
    private StaffEntity staffByStaffId;
    private Collection<DeliverynotedetailEntity> deliverynotedetailsByDeliveryId;

    @Id
    @Column(name = "deliveryId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(Integer deliveryId) {
        this.deliveryId = deliveryId;
    }

    @Basic
    @Column(name = "saleDate")
    public Date getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeliverynoteEntity that = (DeliverynoteEntity) o;
        return Objects.equals(deliveryId, that.deliveryId) &&
                Objects.equals(saleDate, that.saleDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deliveryId, saleDate);
    }


    @ManyToOne
    @JoinColumn(name = "customerId", referencedColumnName = "customerId", nullable = false)
    public CustomerEntity getCustomerByCustomerId() {
        return customerByCustomerId;
    }

    public void setCustomerByCustomerId(CustomerEntity customerByCustomerId) {
        this.customerByCustomerId = customerByCustomerId;
    }

    @ManyToOne
    @JoinColumn(name = "staffId", referencedColumnName = "staffId", nullable = false)
    public StaffEntity getStaffByStaffId() {
        return staffByStaffId;
    }

    public void setStaffByStaffId(StaffEntity staffByStaffId) {
        this.staffByStaffId = staffByStaffId;
    }

    @OneToMany(mappedBy = "deliverynoteByDeliveryId")
    public Collection<DeliverynotedetailEntity> getDeliverynotedetailsByDeliveryId() {
        return deliverynotedetailsByDeliveryId;
    }

    public void setDeliverynotedetailsByDeliveryId(Collection<DeliverynotedetailEntity> deliverynotedetailsByDeliveryId) {
        this.deliverynotedetailsByDeliveryId = deliverynotedetailsByDeliveryId;
    }
}

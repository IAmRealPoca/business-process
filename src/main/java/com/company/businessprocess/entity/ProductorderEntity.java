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
@Table(name = "productorder", schema = "companytest", catalog = "")
public class ProductorderEntity {
    private Integer orderId;
    private Date orderDate;
    private ProviderEntity providerByProviderId;
    private StaffEntity staffByStaffId;
    private Collection<ProductorderdetailEntity> productorderdetailsByOrderId;

    @Id
    @Column(name = "orderID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "orderDate")
    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductorderEntity that = (ProductorderEntity) o;
        return Objects.equals(orderId, that.orderId) &&
                Objects.equals(orderDate, that.orderDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, orderDate);
    }

    @ManyToOne
    @JoinColumn(name = "providerId", referencedColumnName = "providerId", nullable = false)
    public ProviderEntity getProviderByProviderId() {
        return providerByProviderId;
    }

    public void setProviderByProviderId(ProviderEntity providerByProviderId) {
        this.providerByProviderId = providerByProviderId;
    }

    @ManyToOne
    @JoinColumn(name = "staffId", referencedColumnName = "staffId", nullable = false)
    public StaffEntity getStaffByStaffId() {
        return staffByStaffId;
    }

    public void setStaffByStaffId(StaffEntity staffByStaffId) {
        this.staffByStaffId = staffByStaffId;
    }

    @OneToMany(mappedBy = "productorderByOrderId")
    public Collection<ProductorderdetailEntity> getProductorderdetailsByOrderId() {
        return productorderdetailsByOrderId;
    }

    public void setProductorderdetailsByOrderId(Collection<ProductorderdetailEntity> productorderdetailsByOrderId) {
        this.productorderdetailsByOrderId = productorderdetailsByOrderId;
    }
}

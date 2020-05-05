package com.company.businessprocess.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "deliverynote", schema = "company", catalog = "")
public class DeliverynoteEntity {
    private Integer deliveryId;
    private Integer quantity;
    private ProductEntity productByProductId;
    private CustomerEntity customerByCustomerId;
    private StaffEntity staffByStaffId;

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
    @Column(name = "quantity")
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeliverynoteEntity that = (DeliverynoteEntity) o;
        return Objects.equals(deliveryId, that.deliveryId) &&
                Objects.equals(quantity, that.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deliveryId, quantity);
    }

    @ManyToOne
    @JoinColumn(name = "productId", referencedColumnName = "productId", nullable = false)
    public ProductEntity getProductByProductId() {
        return productByProductId;
    }

    public void setProductByProductId(ProductEntity productByProductId) {
        this.productByProductId = productByProductId;
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
}

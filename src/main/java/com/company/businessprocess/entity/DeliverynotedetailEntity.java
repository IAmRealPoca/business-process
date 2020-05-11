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
@Table(name = "deliverynotedetail", schema = "companytest", catalog = "")
public class DeliverynotedetailEntity {
    private Integer deliveryDetailId;
    private Integer quantity;
    private Double price;
    private DeliverynoteEntity deliverynoteByDeliveryId;
    private ProductEntity productByProductId;

    @Id
    @Column(name = "deliveryDetailId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getDeliveryDetailId() {
        return deliveryDetailId;
    }

    public void setDeliveryDetailId(Integer deliveryDetailId) {
        this.deliveryDetailId = deliveryDetailId;
    }

    @Basic
    @Column(name = "quantity")
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Basic
    @Column(name = "price")
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeliverynotedetailEntity that = (DeliverynotedetailEntity) o;
        return Objects.equals(deliveryDetailId, that.deliveryDetailId) &&
                Objects.equals(quantity, that.quantity) &&
                Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deliveryDetailId, quantity, price);
    }

    @ManyToOne
    @JoinColumn(name = "deliveryId", referencedColumnName = "deliveryId", nullable = false)
    public DeliverynoteEntity getDeliverynoteByDeliveryId() {
        return deliverynoteByDeliveryId;
    }

    public void setDeliverynoteByDeliveryId(DeliverynoteEntity deliverynoteByDeliveryId) {
        this.deliverynoteByDeliveryId = deliverynoteByDeliveryId;
    }

    @ManyToOne
    @JoinColumn(name = "productId", referencedColumnName = "productId", nullable = false)
    public ProductEntity getProductByProductId() {
        return productByProductId;
    }

    public void setProductByProductId(ProductEntity productByProductId) {
        this.productByProductId = productByProductId;
    }
}

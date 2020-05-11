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
@Table(name = "productorderdetail", schema = "companytest", catalog = "")
public class ProductorderdetailEntity {
    private Integer productOrderDetailId;
    private Integer quantity;
    private Double price;
    private ProductEntity productByProductId;
    private ProductorderEntity productorderByOrderId;

    @Id
    @Column(name = "productOrderDetailId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getProductOrderDetailId() {
        return productOrderDetailId;
    }

    public void setProductOrderDetailId(Integer productOrderDetailId) {
        this.productOrderDetailId = productOrderDetailId;
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
        ProductorderdetailEntity that = (ProductorderdetailEntity) o;
        return Objects.equals(productOrderDetailId, that.productOrderDetailId) &&
                Objects.equals(quantity, that.quantity) &&
                Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productOrderDetailId, quantity, price);
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
    @JoinColumn(name = "orderId", referencedColumnName = "orderID", nullable = false)
    public ProductorderEntity getProductorderByOrderId() {
        return productorderByOrderId;
    }

    public void setProductorderByOrderId(ProductorderEntity productorderByOrderId) {
        this.productorderByOrderId = productorderByOrderId;
    }
}

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
@Table(name = "receivingnotedetail", schema = "companytest", catalog = "")
public class ReceivingnotedetailEntity {
    private Integer receiveDetailId;
    private Integer quantity;
    private Double price;
    private ReceivingnoteEntity receivingnoteByReceiveId;
    private ProductEntity productByProductid;

    @Id
    @Column(name = "receiveDetailId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getReceiveDetailId() {
        return receiveDetailId;
    }

    public void setReceiveDetailId(Integer receiveDetailId) {
        this.receiveDetailId = receiveDetailId;
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
        ReceivingnotedetailEntity that = (ReceivingnotedetailEntity) o;
        return Objects.equals(receiveDetailId, that.receiveDetailId) &&
                Objects.equals(quantity, that.quantity) &&
                Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(receiveDetailId, quantity, price);
    }

    @ManyToOne
    @JoinColumn(name = "receiveId", referencedColumnName = "receiveId", nullable = false)
    public ReceivingnoteEntity getReceivingnoteByReceiveId() {
        return receivingnoteByReceiveId;
    }

    public void setReceivingnoteByReceiveId(ReceivingnoteEntity receivingnoteByReceiveId) {
        this.receivingnoteByReceiveId = receivingnoteByReceiveId;
    }

    @ManyToOne
    @JoinColumn(name = "productid", referencedColumnName = "productId", nullable = false)
    public ProductEntity getProductByProductid() {
        return productByProductid;
    }

    public void setProductByProductid(ProductEntity productByProductid) {
        this.productByProductid = productByProductid;
    }
}

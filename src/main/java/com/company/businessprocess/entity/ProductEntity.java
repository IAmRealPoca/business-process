package com.company.businessprocess.entity;

import com.company.businessprocess.dto.request.ProductRequest;
import com.company.businessprocess.utils.BusinessProcessStringUtils;

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
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "product", schema = "companytest", catalog = "")
public class ProductEntity {
    private Integer productId;
    private String name;
    private String model;
    private String brand;
    private String description;
    private Double price;
    private ProviderEntity providerByCompany;
    private CategoryEntity categoryByCategoryId;
    private Collection<DeliverynotedetailEntity> deliverynotedetailsByProductId;
    private Collection<ProductorderdetailEntity> productorderdetailsByProductId;
    private Collection<ReceivingnotedetailEntity> receivingnotedetailsByProductId;

    @Id
    @Column(name = "productId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "model")
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Basic
    @Column(name = "brand")
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Basic
    @Column(name = "description", length = 20000)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        ProductEntity that = (ProductEntity) o;
        return Objects.equals(productId, that.productId) &&
                Objects.equals(name, that.name) &&
                Objects.equals(model, that.model) &&
                Objects.equals(brand, that.brand) &&
                Objects.equals(description, that.description) &&
                Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, name, model, brand, description, price);
    }

    @ManyToOne
    @JoinColumn(name = "company", referencedColumnName = "providerId", nullable = false)
    public ProviderEntity getProviderByCompany() {
        return providerByCompany;
    }

    public void setProviderByCompany(ProviderEntity providerByCompany) {
        this.providerByCompany = providerByCompany;
    }

    @ManyToOne
    @JoinColumn(name = "categoryId", referencedColumnName = "categoryId", nullable = false)
    public CategoryEntity getCategoryByCategoryId() {
        return categoryByCategoryId;
    }

    public void setCategoryByCategoryId(CategoryEntity categoryByCategoryId) {
        this.categoryByCategoryId = categoryByCategoryId;
    }

    public void mergeToUpdate(Object updateObject) {
        if (!(updateObject instanceof ProductRequest)) {
            return;
        }
        ProductRequest productRequest = (ProductRequest) updateObject;
        this.name = !BusinessProcessStringUtils.isBlankAndEmpty(productRequest.getName()) ? productRequest.getName() : this.name;
        this.model = !BusinessProcessStringUtils.isBlankAndEmpty(productRequest.getModel()) ? productRequest.getModel() : this.model;
        this.brand = !BusinessProcessStringUtils.isBlankAndEmpty(productRequest.getBrand()) ? productRequest.getBrand() : this.brand;
        this.description = !BusinessProcessStringUtils.isBlankAndEmpty(productRequest.getDescription()) ? productRequest.getDescription() : this.description;
        this.price = productRequest.getPrice() != null ? productRequest.getPrice() : this.price;
    }

    @OneToMany(mappedBy = "productByProductId")
    public Collection<DeliverynotedetailEntity> getDeliverynotedetailsByProductId() {
        return deliverynotedetailsByProductId;
    }

    public void setDeliverynotedetailsByProductId(Collection<DeliverynotedetailEntity> deliverynotedetailsByProductId) {
        this.deliverynotedetailsByProductId = deliverynotedetailsByProductId;
    }

    @OneToMany(mappedBy = "productByProductId")
    public Collection<ProductorderdetailEntity> getProductorderdetailsByProductId() {
        return productorderdetailsByProductId;
    }

    public void setProductorderdetailsByProductId(Collection<ProductorderdetailEntity> productorderdetailsByProductId) {
        this.productorderdetailsByProductId = productorderdetailsByProductId;
    }

    @OneToMany(mappedBy = "productByProductid")
    public Collection<ReceivingnotedetailEntity> getReceivingnotedetailsByProductId() {
        return receivingnotedetailsByProductId;
    }

    public void setReceivingnotedetailsByProductId(Collection<ReceivingnotedetailEntity> receivingnotedetailsByProductId) {
        this.receivingnotedetailsByProductId = receivingnotedetailsByProductId;
    }
}

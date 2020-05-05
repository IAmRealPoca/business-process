package com.company.businessprocess.entity;

import com.company.businessprocess.dto.request.CategoryRequest;
import com.company.businessprocess.utils.BusinessProcessStringUtils;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "category", schema = "company", catalog = "")
public class CategoryEntity {
    private Integer categoryId;
    private String name;
    private Collection<ProductEntity> productsByCategoryId;

    @Id
    @Column(name = "categoryId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoryEntity that = (CategoryEntity) o;
        return Objects.equals(categoryId, that.categoryId) &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryId, name);
    }

    @OneToMany(mappedBy = "categoryByCategoryId")
    public Collection<ProductEntity> getProductsByCategoryId() {
        return productsByCategoryId;
    }

    public void setProductsByCategoryId(Collection<ProductEntity> productsByCategoryId) {
        this.productsByCategoryId = productsByCategoryId;
    }

    public void mergeToUpdate(Object updateObject) {
        if (!(updateObject instanceof CategoryEntity) || !(updateObject instanceof CategoryRequest)) {
            return;
        }
        CategoryRequest categoryRequest = (CategoryRequest) updateObject;
        this.name = !BusinessProcessStringUtils.isBlankAndEmpty(categoryRequest.getName()) ? categoryRequest.getName() : this.name;
    }
}

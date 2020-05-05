package com.company.businessprocess.entity;

import com.company.businessprocess.dto.request.ProviderRequest;
import com.company.businessprocess.dto.request.StaffRequest;
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
@Table(name = "provider", schema = "company", catalog = "")
public class ProviderEntity {
    private Integer providerId;
    private String name;
    private String address;
    private Integer phone;
    private Integer fax;
    private String email;
    private String contactPerson;
    private Collection<ProductEntity> productsByProviderId;

    @Id
    @Column(name = "providerId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getProviderId() {
        return providerId;
    }

    public void setProviderId(Integer providerId) {
        this.providerId = providerId;
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
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "phone")
    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "fax")
    public Integer getFax() {
        return fax;
    }

    public void setFax(Integer fax) {
        this.fax = fax;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "contactPerson")
    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProviderEntity that = (ProviderEntity) o;
        return Objects.equals(providerId, that.providerId) &&
                Objects.equals(name, that.name) &&
                Objects.equals(address, that.address) &&
                Objects.equals(phone, that.phone) &&
                Objects.equals(fax, that.fax) &&
                Objects.equals(email, that.email) &&
                Objects.equals(contactPerson, that.contactPerson);
    }

    @Override
    public int hashCode() {
        return Objects.hash(providerId, name, address, phone, fax, email, contactPerson);
    }

    @OneToMany(mappedBy = "providerByCompany")
    public Collection<ProductEntity> getProductsByProviderId() {
        return productsByProviderId;
    }

    public void setProductsByProviderId(Collection<ProductEntity> productsByProviderId) {
        this.productsByProviderId = productsByProviderId;
    }

    public void mergeToUpdate(Object updateObject) {
        if (!(updateObject instanceof ProviderRequest)) {
            return;
        }
        ProviderRequest providerRequest = (ProviderRequest) updateObject;
        this.name = !BusinessProcessStringUtils.isBlankAndEmpty(providerRequest.getName()) ? providerRequest.getName() : this.name;
        this.address = !BusinessProcessStringUtils.isBlankAndEmpty(providerRequest.getAddress()) ? providerRequest.getAddress() : this.address;
        this.phone = providerRequest.getPhone() != null ? providerRequest.getPhone() : this.phone;
        this.email = !BusinessProcessStringUtils.isBlankAndEmpty(providerRequest.getEmail()) ? providerRequest.getEmail() : this.email;
        this.fax = providerRequest.getFax() != null ? providerRequest.getFax() : this.fax;
        this.contactPerson = !BusinessProcessStringUtils.isBlankAndEmpty(providerRequest.getContactPerson()) ? providerRequest.getContactPerson() : this.contactPerson;
    }
}

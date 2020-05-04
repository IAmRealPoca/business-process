package com.company.businessprocess.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "customer", schema = "company", catalog = "")
public class CustomerEntity {
    private Integer customerId;
    private String name;
    private String address;
    private Integer phone;
    private Integer fax;
    private String email;
    private String contactPerson;
    private Collection<DeliverynoteEntity> deliverynotesByCustomerId;
    private Collection<SaleinvoiceEntity> saleinvoicesByCustomerId;

    @Id
    @Column(name = "customerId")
    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
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
        CustomerEntity that = (CustomerEntity) o;
        return Objects.equals(customerId, that.customerId) &&
                Objects.equals(name, that.name) &&
                Objects.equals(address, that.address) &&
                Objects.equals(phone, that.phone) &&
                Objects.equals(fax, that.fax) &&
                Objects.equals(email, that.email) &&
                Objects.equals(contactPerson, that.contactPerson);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, name, address, phone, fax, email, contactPerson);
    }

    @OneToMany(mappedBy = "customerByCustomerId")
    public Collection<DeliverynoteEntity> getDeliverynotesByCustomerId() {
        return deliverynotesByCustomerId;
    }

    public void setDeliverynotesByCustomerId(Collection<DeliverynoteEntity> deliverynotesByCustomerId) {
        this.deliverynotesByCustomerId = deliverynotesByCustomerId;
    }

    @OneToMany(mappedBy = "customerByCustomerId")
    public Collection<SaleinvoiceEntity> getSaleinvoicesByCustomerId() {
        return saleinvoicesByCustomerId;
    }

    public void setSaleinvoicesByCustomerId(Collection<SaleinvoiceEntity> saleinvoicesByCustomerId) {
        this.saleinvoicesByCustomerId = saleinvoicesByCustomerId;
    }
}
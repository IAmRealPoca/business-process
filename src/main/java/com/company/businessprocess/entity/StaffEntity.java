package com.company.businessprocess.entity;

import com.company.businessprocess.dto.request.CategoryRequest;
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
@Table(name = "staff", schema = "company", catalog = "")
public class StaffEntity {
    private Integer staffId;
    private String name;
    private String address;
    private Integer phone;
    private String email;
    private Collection<DeliverynoteEntity> deliverynotesByStaffId;
    private Collection<ProductorderEntity> productordersByStaffId;
    private Collection<ReceivingnoteEntity> receivingnotesByStaffId;
    private Collection<SaleinvoiceEntity> saleinvoicesByStaffId;

    @Id
    @Column(name = "staffId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
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
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StaffEntity that = (StaffEntity) o;
        return Objects.equals(staffId, that.staffId) &&
                Objects.equals(name, that.name) &&
                Objects.equals(address, that.address) &&
                Objects.equals(phone, that.phone) &&
                Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(staffId, name, address, phone, email);
    }

    @OneToMany(mappedBy = "staffByStaffId")
    public Collection<DeliverynoteEntity> getDeliverynotesByStaffId() {
        return deliverynotesByStaffId;
    }

    public void setDeliverynotesByStaffId(Collection<DeliverynoteEntity> deliverynotesByStaffId) {
        this.deliverynotesByStaffId = deliverynotesByStaffId;
    }

    @OneToMany(mappedBy = "staffByStaffId")
    public Collection<ProductorderEntity> getProductordersByStaffId() {
        return productordersByStaffId;
    }

    public void setProductordersByStaffId(Collection<ProductorderEntity> productordersByStaffId) {
        this.productordersByStaffId = productordersByStaffId;
    }

    @OneToMany(mappedBy = "staffByStaffId")
    public Collection<ReceivingnoteEntity> getReceivingnotesByStaffId() {
        return receivingnotesByStaffId;
    }

    public void setReceivingnotesByStaffId(Collection<ReceivingnoteEntity> receivingnotesByStaffId) {
        this.receivingnotesByStaffId = receivingnotesByStaffId;
    }

    @OneToMany(mappedBy = "staffByStaffId")
    public Collection<SaleinvoiceEntity> getSaleinvoicesByStaffId() {
        return saleinvoicesByStaffId;
    }

    public void setSaleinvoicesByStaffId(Collection<SaleinvoiceEntity> saleinvoicesByStaffId) {
        this.saleinvoicesByStaffId = saleinvoicesByStaffId;
    }

    public void mergeToUpdate(Object updateObject) {
        if (!(updateObject instanceof StaffEntity) || !(updateObject instanceof StaffRequest)) {
            return;
        }
        StaffRequest staffRequest = (StaffRequest) updateObject;
        this.name = !BusinessProcessStringUtils.isBlankAndEmpty(staffRequest.getName()) ? staffRequest.getName() : this.name;
        this.address = !BusinessProcessStringUtils.isBlankAndEmpty(staffRequest.getAddress()) ? staffRequest.getAddress() : this.address;
        this.phone = staffRequest.getPhone() != null ? staffRequest.getPhone() : this.phone;
        this.email = !BusinessProcessStringUtils.isBlankAndEmpty(staffRequest.getEmail()) ? staffRequest.getEmail() : this.email;
    }
}

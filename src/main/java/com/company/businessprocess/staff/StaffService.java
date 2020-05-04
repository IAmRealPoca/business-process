package com.company.businessprocess.staff;

import com.company.businessprocess.entity.SaleinvoiceEntity;
import com.company.businessprocess.entity.StaffEntity;

import java.util.Collection;

public interface StaffService {
    Collection<StaffEntity> getAllStaff();
    StaffEntity addStaff(StaffEntity newEntity);
    StaffEntity updateStaff (Integer id, StaffEntity updateEntity);
    void deleteStaff (Integer id);
}

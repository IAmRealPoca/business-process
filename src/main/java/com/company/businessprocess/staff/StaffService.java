package com.company.businessprocess.staff;

import com.company.businessprocess.dto.response.StaffResponse;
import com.company.businessprocess.entity.StaffEntity;

import java.util.Collection;

public interface StaffService {
    Collection<StaffResponse> getAllStaff();
    StaffResponse addStaff(StaffEntity newEntity);
    StaffResponse updateStaff (Integer id, StaffEntity updateEntity);
    void deleteStaff (Integer id);
}

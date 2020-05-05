package com.company.businessprocess.staff;

import com.company.businessprocess.dto.request.StaffRequest;
import com.company.businessprocess.dto.response.StaffResponse;
import com.company.businessprocess.entity.StaffEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StaffService {
    Page<StaffResponse> getAllStaff(Pageable pageable);
    StaffResponse addStaff(StaffEntity newEntity);
    StaffResponse updateStaff (Integer id, StaffRequest updateEntity);
    void deleteStaff (Integer id);
}

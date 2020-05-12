package com.company.businessprocess.staff;


import com.company.businessprocess.dto.request.StaffRequest;
import com.company.businessprocess.dto.response.StaffResponse;
import com.company.businessprocess.entity.StaffEntity;
import com.company.businessprocess.mapper.StaffMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StaffServiceImpl implements StaffService {
    private StaffRepository staffRepository;
    private StaffMapper staffMapper;

    @Autowired
    public StaffServiceImpl(StaffRepository staffRepository, StaffMapper staffMapper) {
        this.staffRepository = staffRepository;
        this.staffMapper = staffMapper;
    }

    @Override
    public Page<StaffResponse> getAllStaff(Pageable pageable) {
        Page<StaffEntity> staffEntities = staffRepository.findAll(pageable);
        Page<StaffResponse> responses = staffEntities.map(staffEntity ->
                staffMapper.fromEntityToResponse(staffEntity));
        return responses;
    }

    @Override
    public StaffResponse addStaff(StaffRequest newStaffRequest) {
        StaffEntity newStaff = staffMapper.fromRequestToEntity(newStaffRequest);
        return staffMapper.fromEntityToResponse(staffRepository.save(newStaff));
    }

    @Override
    public StaffResponse updateStaff(Integer id, StaffRequest updateEntity) {
        Optional<StaffEntity> optionalStaffEntity = staffRepository.findById(id);
        if (optionalStaffEntity.isPresent()) {
            StaffEntity currentStaff = optionalStaffEntity.get();
            currentStaff.mergeToUpdate(updateEntity);
            return staffMapper.fromEntityToResponse(staffRepository.save(currentStaff));
        }
        return null;
    }

    @Override
    public void deleteStaff(Integer id) {
        Optional<StaffEntity> optionalStaffEntity = staffRepository.findById(id);
        if (optionalStaffEntity.isPresent()) {
            staffRepository.deleteById(id);
        }
    }
}

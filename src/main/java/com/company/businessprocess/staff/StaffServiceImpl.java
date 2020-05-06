package com.company.businessprocess.staff;


import com.company.businessprocess.dto.request.StaffRequest;
import com.company.businessprocess.dto.response.StaffResponse;
import com.company.businessprocess.entity.StaffEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StaffServiceImpl implements StaffService {
    private StaffRepository staffRepository;
    private ModelMapper mapper;

    @Autowired
    public StaffServiceImpl(StaffRepository staffRepository, ModelMapper mapper) {
        this.staffRepository = staffRepository;
        this.mapper = mapper;
    }

    @Override
    public Page<StaffResponse> getAllStaff(Pageable pageable) {
        Page<StaffEntity> staffEntities = staffRepository.findAll(pageable);
        Page<StaffResponse> responses = staffEntities.map(staffEntity -> mapper.map(staffEntity, StaffResponse.class));
        return responses;
    }

    @Override
    public StaffResponse addStaff(StaffRequest newStaffRequest) {
        StaffEntity newStaff = mapper.map(newStaffRequest, StaffEntity.class);
        return mapper.map(staffRepository.save(newStaff), StaffResponse.class);
    }

    @Override
    public StaffResponse updateStaff(Integer id, StaffRequest updateEntity) {
        Optional<StaffEntity> optionalStaffEntity = staffRepository.findById(id);
        if (optionalStaffEntity.isPresent()) {
            StaffEntity currentStaff = optionalStaffEntity.get();
            currentStaff.mergeToUpdate(updateEntity);
            return mapper.map(staffRepository.save(currentStaff), StaffResponse.class);
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

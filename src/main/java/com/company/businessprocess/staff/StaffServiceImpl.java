package com.company.businessprocess.staff;


import com.company.businessprocess.dto.request.StaffRequest;
import com.company.businessprocess.dto.response.StaffResponse;
import com.company.businessprocess.entity.StaffEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public Collection<StaffResponse> getAllStaff() {
        Collection<StaffResponse> responses =
                staffRepository.findAll().stream()
                        .map(staffEntity -> mapper.map(staffEntity, StaffResponse.class))
                        .collect(Collectors.toList());
        return responses;
    }

    @Override
    public StaffResponse addStaff(StaffEntity newEntity) {
        return mapper.map(staffRepository.save(newEntity), StaffResponse.class);
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

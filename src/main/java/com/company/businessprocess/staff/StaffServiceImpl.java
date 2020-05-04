package com.company.businessprocess.staff;


import com.company.businessprocess.dto.StaffResponse;
import com.company.businessprocess.entity.StaffEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
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
    public StaffEntity addStaff(StaffEntity newEntity) {
        return staffRepository.save(newEntity);
    }

    @Override
    public StaffEntity updateStaff(Integer id, StaffEntity updateEntity) {
        return staffRepository.save(updateEntity);
    }

    @Override
    public void deleteStaff(Integer id) {
        staffRepository.deleteById(id);
    }
}

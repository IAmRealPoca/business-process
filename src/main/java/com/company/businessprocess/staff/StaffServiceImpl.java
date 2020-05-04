package com.company.businessprocess.staff;

import com.company.businessprocess.entity.StaffEntity;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class StaffServiceImpl implements StaffService {
    private StaffRepository staffRepository;

    public StaffServiceImpl(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    @Override
    public Collection<StaffEntity> getAllStaff() {
        return staffRepository.findAll();
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

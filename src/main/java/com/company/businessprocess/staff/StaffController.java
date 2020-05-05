package com.company.businessprocess.staff;

import com.company.businessprocess.dto.request.StaffRequest;
import com.company.businessprocess.dto.response.StaffResponse;
import com.company.businessprocess.entity.StaffEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/Staff")
public class StaffController {
    private StaffService staffService;

    @Autowired
    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }

    @GetMapping("/get-all-staff")
    public ResponseEntity<Collection<StaffResponse>> getAllStaff() {
        return ResponseEntity.ok(staffService.getAllStaff());
    }

    @PostMapping
    public ResponseEntity<StaffResponse> insertStaff(StaffEntity newEntity) {
        return ResponseEntity.ok(staffService.addStaff(newEntity));
    }

    @PutMapping
    public ResponseEntity<StaffResponse> updateStaff(Integer id, StaffRequest updateEntity) {
        return ResponseEntity.ok(staffService.updateStaff(id, updateEntity));
    }

    @DeleteMapping
    public ResponseEntity<String> deleteStaff(Integer id) {
        staffService.deleteStaff(id);
        return ResponseEntity.ok("Deleted");
    }
}

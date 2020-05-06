package com.company.businessprocess.staff;

import com.company.businessprocess.dto.request.StaffRequest;
import com.company.businessprocess.dto.response.StaffResponse;
import com.company.businessprocess.entity.StaffEntity;
import com.company.businessprocess.utils.PagingAndSortingBuilder;
import com.company.businessprocess.utils.PagingAndSortingOption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Staff")
public class StaffController {
    private StaffService staffService;

    @Autowired
    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }

    @GetMapping("/get-all-staff")
    public ResponseEntity<Page<StaffResponse>> getAllStaff(PagingAndSortingOption pagingOption) {
        return ResponseEntity.ok(staffService.getAllStaff(PagingAndSortingBuilder.buildPageableObj(pagingOption)));
    }

    @PostMapping
    public ResponseEntity<StaffResponse> insertStaff(StaffRequest newEntity) {
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

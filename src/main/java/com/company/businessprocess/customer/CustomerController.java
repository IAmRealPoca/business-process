package com.company.businessprocess.customer;

import com.company.businessprocess.dto.request.CustomerRequest;
import com.company.businessprocess.dto.response.CustomerResponse;
import com.company.businessprocess.entity.CustomerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping ("/Customer")
public class CustomerController {
    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping ("/get-all-customer")
    public ResponseEntity<Collection<CustomerResponse>> getAllCustomer() {
        return ResponseEntity.ok(customerService.getAllCustomer());
    }
    @PostMapping
    public ResponseEntity<CustomerResponse> insertCustomer(CustomerRequest newCustomer) {
        return ResponseEntity.ok(customerService.addCustomer(newCustomer));
    }

    @PutMapping
    public ResponseEntity<CustomerResponse> updateCustomer(Integer id, CustomerEntity updateEntity) {
        return ResponseEntity.ok(customerService.updateCustomer(id, updateEntity));
    }

    @DeleteMapping
    public ResponseEntity<String> deleteCustomer(Integer id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.ok("Deleted");
    }
}

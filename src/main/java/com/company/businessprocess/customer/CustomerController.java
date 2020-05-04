package com.company.businessprocess.customer;

import com.company.businessprocess.entity.CustomerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<Collection<CustomerEntity>> getAllCustomer() {
        return ResponseEntity.ok(customerService.getAllCustomer());
    }
}

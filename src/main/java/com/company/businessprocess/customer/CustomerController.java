package com.company.businessprocess.customer;

import com.company.businessprocess.dto.request.CustomerRequest;
import com.company.businessprocess.dto.response.CustomerResponse;
import com.company.businessprocess.entity.CustomerEntity;
import com.company.businessprocess.utils.PagingAndSortingBuilder;
import com.company.businessprocess.utils.PagingAndSortingOption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping ("/customers")
public class CustomerController {
    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping ("/get-all")
    public ResponseEntity<Page<CustomerResponse>> getAllCustomer(PagingAndSortingOption pagingOption) {
        return ResponseEntity.ok(customerService.getAllCustomer(PagingAndSortingBuilder.buildPageableObj(pagingOption)));
    }

    @GetMapping("/search")
    public ResponseEntity<Page<CustomerResponse>> searchCustomer(CustomerRequest request, PagingAndSortingOption pagingOption) {
        return ResponseEntity.ok(customerService.searchCustomer(request, PagingAndSortingBuilder.buildPageableObj(pagingOption)));
    }

    @PostMapping
    public ResponseEntity<CustomerResponse> insertCustomer(
            @RequestBody CustomerRequest newCustomer) {
        return ResponseEntity.ok(customerService.addCustomer(newCustomer));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerResponse> updateCustomer(
            @PathVariable("id") Integer id,
            @RequestBody CustomerRequest updateEntity) {
        return ResponseEntity.ok(customerService.updateCustomer(id, updateEntity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable("id") Integer id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.ok("Deleted");
    }
}

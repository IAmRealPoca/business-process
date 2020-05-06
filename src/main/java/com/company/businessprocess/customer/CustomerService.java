package com.company.businessprocess.customer;

import com.company.businessprocess.dto.request.CustomerRequest;
import com.company.businessprocess.dto.response.CustomerResponse;
import com.company.businessprocess.entity.CustomerEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Collection;

public interface CustomerService {
    Page<CustomerResponse> getAllCustomer(Pageable pageable);
    Page<CustomerResponse> searchCustomer(CustomerRequest request, Pageable pageable);
    CustomerResponse addCustomer(CustomerRequest newCustomer);
    CustomerResponse updateCustomer (Integer id, CustomerRequest updateEntity);
    void deleteCustomer (Integer id);

}

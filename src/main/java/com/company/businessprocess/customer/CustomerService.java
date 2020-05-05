package com.company.businessprocess.customer;

import com.company.businessprocess.dto.request.CustomerRequest;
import com.company.businessprocess.dto.response.CustomerResponse;
import com.company.businessprocess.entity.CustomerEntity;

import java.util.Collection;

public interface CustomerService {
    Collection<CustomerResponse> getAllCustomer();
    CustomerResponse addCustomer(CustomerRequest newCustomer);
    CustomerResponse updateCustomer (Integer id, CustomerEntity updateEntity);
    void deleteCustomer (Integer id);

}

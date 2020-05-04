package com.company.businessprocess.customer;

import com.company.businessprocess.dto.CustomerResponse;
import com.company.businessprocess.entity.CustomerEntity;

import java.util.Collection;

public interface CustomerService {
    Collection<CustomerResponse> getAllCustomer();
    CustomerEntity addCustomer(CustomerEntity newEntity);
    CustomerEntity updateCustomer (Integer id, CustomerEntity updateEntity);
    void deleteCustomer (Integer id);

}

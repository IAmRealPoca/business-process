package com.company.businessprocess.customer;

import com.company.businessprocess.entity.CustomerEntity;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Collection<CustomerEntity> getAllCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public CustomerEntity addCustomer(CustomerEntity newEntity) {
        return customerRepository.save(newEntity);
    }

    @Override
    public CustomerEntity updateCustomer(Integer Id, CustomerEntity updateEntity) {
        return customerRepository.save(updateEntity);
    }

    @Override
    public void deleteCustomer(Integer id) {
        customerRepository.deleteById(id);
    }
}

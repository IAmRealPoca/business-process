package com.company.businessprocess.customer;

import com.company.businessprocess.dto.CustomerResponse;
import com.company.businessprocess.entity.CustomerEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;
    private ModelMapper mapper;

    public CustomerServiceImpl(CustomerRepository customerRepository, ModelMapper mapper) {
        this.customerRepository = customerRepository;
        this.mapper = mapper;
    }

    @Override
    public Collection<CustomerResponse> getAllCustomer() {
        Collection<CustomerResponse> customerResponses =
                customerRepository.findAll().stream()
                .map(customerEntity -> mapper.map(customerEntity, CustomerResponse.class))
                .collect(Collectors.toList());
        return customerResponses;
    }

    @Override
    public CustomerEntity addCustomer(CustomerEntity newEntity) {
        return customerRepository.save(newEntity);
    }

    @Override
    public CustomerEntity updateCustomer(Integer id, CustomerEntity updateEntity) {
        return customerRepository.save(updateEntity);
    }

    @Override
    public void deleteCustomer(Integer id) {
        customerRepository.deleteById(id);
    }
}

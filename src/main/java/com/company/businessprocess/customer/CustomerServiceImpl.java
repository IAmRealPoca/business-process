package com.company.businessprocess.customer;

import com.company.businessprocess.dto.request.CustomerRequest;
import com.company.businessprocess.dto.response.CustomerResponse;
import com.company.businessprocess.entity.CustomerEntity;
import com.company.businessprocess.entity.ProductEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
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
    public CustomerResponse addCustomer(CustomerRequest newCustomer) {
        CustomerEntity newEntity = mapper.map(newCustomer, CustomerEntity.class);
        return mapper.map(customerRepository.save(newEntity), CustomerResponse.class);
    }

    @Override
    public CustomerResponse updateCustomer(Integer id, CustomerEntity updateEntity) {
        Optional<CustomerEntity> optionalCustomerEntity = customerRepository.findById(id);
        if (optionalCustomerEntity.isPresent()) {
            CustomerEntity currentCustomer = optionalCustomerEntity.get();
            currentCustomer.mergeToUpdate(updateEntity);
            return mapper.map(customerRepository.save(updateEntity), CustomerResponse.class);
        }
        return null;
    }

    @Override
    public void deleteCustomer(Integer id) {
        Optional<CustomerEntity> optionalCustomerEntity = customerRepository.findById(id);
        if (optionalCustomerEntity.isPresent()) {
            customerRepository.deleteById(id);
        }
    }
}

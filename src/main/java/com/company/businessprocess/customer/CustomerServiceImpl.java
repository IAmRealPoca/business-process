package com.company.businessprocess.customer;

import com.company.businessprocess.dto.request.CustomerRequest;
import com.company.businessprocess.dto.response.CustomerResponse;
import com.company.businessprocess.entity.CustomerEntity;
import com.company.businessprocess.entity.ProductEntity;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public Page<CustomerResponse> getAllCustomer(Pageable pageable) {
        Page<CustomerEntity> customerResponses =                customerRepository.findAll(pageable);
        Page<CustomerResponse> responses = customerResponses.map(customerEntity -> mapper.map(customerEntity, CustomerResponse.class));
        return responses;
    }

    @Override
    public CustomerResponse addCustomer(CustomerRequest newCustomer) {
        CustomerEntity newEntity = mapper.map(newCustomer, CustomerEntity.class);
        return mapper.map(customerRepository.save(newEntity), CustomerResponse.class);
    }

    @Override
    public CustomerResponse updateCustomer(Integer id, CustomerRequest updateEntity) {
        Optional<CustomerEntity> optionalCustomerEntity = customerRepository.findById(id);
        if (optionalCustomerEntity.isPresent()) {
            CustomerEntity currentCustomer = optionalCustomerEntity.get();
            currentCustomer.mergeToUpdate(updateEntity);
            return mapper.map(customerRepository.save(currentCustomer), CustomerResponse.class);
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

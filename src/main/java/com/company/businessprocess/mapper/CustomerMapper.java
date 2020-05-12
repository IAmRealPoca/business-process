package com.company.businessprocess.mapper;

import com.company.businessprocess.dto.request.CustomerRequest;
import com.company.businessprocess.dto.response.CustomerResponse;
import com.company.businessprocess.entity.CustomerEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class CustomerMapper {
    public abstract CustomerResponse fromEntityToResponse(CustomerEntity customerEntity);
    public abstract List<CustomerResponse> fromEntitiesToResponses(List<CustomerEntity> customerEntities);
    public abstract CustomerEntity fromRequestToEntity(CustomerRequest customerRequest);
}

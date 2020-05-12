package com.company.businessprocess.mapper;

import com.company.businessprocess.dto.request.ProductRequest;
import com.company.businessprocess.dto.response.ProductResponse;
import com.company.businessprocess.entity.ProductEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class ProductMapper {
    public abstract ProductResponse fromEntityToResponse(ProductEntity productEntity);
    public abstract ProductEntity fromRequestToEntity(ProductRequest productRequest);
}

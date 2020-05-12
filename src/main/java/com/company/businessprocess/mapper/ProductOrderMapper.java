package com.company.businessprocess.mapper;

import com.company.businessprocess.dto.request.ProductOrderRequest;
import com.company.businessprocess.dto.response.ProductOrderResponse;
import com.company.businessprocess.entity.ProductorderEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class ProductOrderMapper {
    public abstract ProductOrderResponse fromEntityToResponse(ProductorderEntity productorderEntity);
    public abstract ProductorderEntity fromRequestToEntity(ProductOrderRequest productOrderRequest);
}

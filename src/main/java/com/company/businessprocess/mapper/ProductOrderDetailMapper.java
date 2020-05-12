package com.company.businessprocess.mapper;

import com.company.businessprocess.dto.request.ProductOrderDetailRequest;
import com.company.businessprocess.dto.request.ProductOrderRequest;
import com.company.businessprocess.dto.response.ProductOrderDetailResponse;
import com.company.businessprocess.dto.response.ProductOrderResponse;
import com.company.businessprocess.entity.ProductorderEntity;
import com.company.businessprocess.entity.ProductorderdetailEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class ProductOrderDetailMapper {
    public abstract ProductOrderDetailResponse fromEntityToResponse(ProductorderdetailEntity productorderdetailEntity);
    public abstract ProductorderdetailEntity fromRequestToEntity(ProductOrderDetailRequest productOrderDetailRequest);
}

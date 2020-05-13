package com.company.businessprocess.mapper;

import com.company.businessprocess.dto.request.ProductOrderDetailRequest;
import com.company.businessprocess.dto.request.ProductOrderRequest;
import com.company.businessprocess.dto.response.ProductOrderDetailResponse;
import com.company.businessprocess.dto.response.ProductOrderResponse;
import com.company.businessprocess.entity.ProductorderEntity;
import com.company.businessprocess.entity.ProductorderdetailEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public abstract class ProductOrderDetailMapper {
    @Mappings({
            @Mapping(target = "productInfo", source = "productByProductId")
    })
    public abstract ProductOrderDetailResponse fromEntityToResponse(ProductorderdetailEntity productorderdetailEntity);
    public abstract ProductorderdetailEntity fromRequestToEntity(ProductOrderDetailRequest productOrderDetailRequest);
}

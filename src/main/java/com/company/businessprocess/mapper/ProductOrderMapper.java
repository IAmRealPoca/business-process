package com.company.businessprocess.mapper;

import com.company.businessprocess.dto.request.ProductOrderRequest;
import com.company.businessprocess.dto.response.ProductOrderResponse;
import com.company.businessprocess.entity.ProductorderEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {ProductOrderDetailMapper.class})
public abstract class ProductOrderMapper {
    @Mappings({
            @Mapping(target = "productOrderDetails", source = "productorderdetailsByOrderId"),
            @Mapping(target = "staffInfo", source = "staffByStaffId"),
            @Mapping(target = "providerInfo", source = "providerByProviderId")
    })
    public abstract ProductOrderResponse fromEntityToResponse(ProductorderEntity productorderEntity);
    public abstract ProductorderEntity fromRequestToEntity(ProductOrderRequest productOrderRequest);
}

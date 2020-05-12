package com.company.businessprocess.mapper;

import com.company.businessprocess.entity.ProductorderdetailEntity;
import com.company.businessprocess.entity.ReceivingnotedetailEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class ReceivingNoteDetailMapper {
//    public abstract ProductOrderDetailResponse fromEntityToResponse(ProductorderdetailEntity productorderdetailEntity);
//    public abstract ProductorderdetailEntity fromRequestToEntity(ProductOrderDetailRequest productOrderDetailRequest);
    public abstract ReceivingnotedetailEntity fromProdOrderDetailEntToReceivingNoteDetailEnt(ProductorderdetailEntity productorderdetailEntity);
}

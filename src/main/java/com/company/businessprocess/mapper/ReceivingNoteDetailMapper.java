package com.company.businessprocess.mapper;

import com.company.businessprocess.dto.response.ReceivingNoteDetailResponse;
import com.company.businessprocess.entity.ProductorderdetailEntity;
import com.company.businessprocess.entity.ReceivingnotedetailEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class ReceivingNoteDetailMapper {
    public abstract ReceivingNoteDetailResponse fromEntityToResponse(ReceivingnotedetailEntity receivingnotedetailEntity);
    public abstract List<ReceivingNoteDetailResponse> fromEntitiesToResponses(List<ReceivingnotedetailEntity> receivingnotedetailEntities);
//    public abstract ReceivingnotedetailEntity fromRequestToEntity(ReceivingNoteDetailREq productOrderDetailRequest);
    public abstract ReceivingnotedetailEntity fromProdOrderDetailEntToReceivingNoteDetailEnt(ProductorderdetailEntity productorderdetailEntity);
}

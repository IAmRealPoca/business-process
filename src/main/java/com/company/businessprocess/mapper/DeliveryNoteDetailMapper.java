package com.company.businessprocess.mapper;

import com.company.businessprocess.dto.response.DeliveryNoteDetailResponse;
import com.company.businessprocess.entity.DeliverynotedetailEntity;
import com.company.businessprocess.entity.SaleinvoiceEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = ProductMapper.class)
public abstract class DeliveryNoteDetailMapper {
    @Mappings({
            @Mapping(target = "productResponse", source = "productByProductId")
    })
    public abstract DeliveryNoteDetailResponse fromEntityToResponse(DeliverynotedetailEntity deliverynotedetailEntity);
    public abstract List<DeliveryNoteDetailResponse> fromEntitiesToResponses(List<DeliverynotedetailEntity> deliverynotedetailEntities);
    public abstract DeliverynotedetailEntity fromSaleInvoiceEntToDeliveryNoteEnt(SaleinvoiceEntity saleinvoiceEntity);
}

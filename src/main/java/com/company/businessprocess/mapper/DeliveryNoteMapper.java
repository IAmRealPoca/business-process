package com.company.businessprocess.mapper;

import com.company.businessprocess.dto.request.DeliveryNoteRequest;
import com.company.businessprocess.dto.response.DeliveryNoteResponse;
import com.company.businessprocess.entity.DeliverynoteEntity;
import com.company.businessprocess.entity.SaleinvoiceEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

@Mapper(componentModel = "spring", uses = DeliveryNoteDetailMapper.class)
public abstract class DeliveryNoteMapper {
    @Mappings({
            @Mapping(target = "deliveryNoteDetailResponses", source = "deliverynotedetailsByDeliveryId")
    })
    public abstract DeliveryNoteResponse fromEntityToResponse(DeliverynoteEntity deliverynoteEntity);
    public abstract List<DeliveryNoteResponse> fromEntitiesToResponses(List<DeliverynoteEntity> deliverynoteEntities);
    public abstract DeliverynoteEntity fromRequestToEntity(DeliveryNoteRequest deliveryNoteRequest);
    public abstract DeliverynoteEntity fromSaleInvoiceEntToDeliveryNoteEnt(SaleinvoiceEntity saleinvoiceEntity);
}

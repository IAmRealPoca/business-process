package com.company.businessprocess.mapper;

import com.company.businessprocess.dto.request.DeliveryNoteRequest;
import com.company.businessprocess.dto.response.DeliveryNoteResponse;
import com.company.businessprocess.entity.DeliverynoteEntity;
import com.company.businessprocess.entity.SaleinvoiceEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class DeliveryNoteMapper {
    public abstract DeliveryNoteResponse fromEntityToResponse(DeliverynoteEntity deliverynoteEntity);
    public abstract List<DeliveryNoteResponse> fromEntitiesToResponses(List<DeliverynoteEntity> deliverynoteEntities);
    public abstract DeliverynoteEntity fromRequestToEntity(DeliveryNoteRequest deliveryNoteRequest);
    public abstract DeliverynoteEntity fromSaleInvoiceEntToDeliveryNoteEnt(SaleinvoiceEntity saleinvoiceEntity);
}

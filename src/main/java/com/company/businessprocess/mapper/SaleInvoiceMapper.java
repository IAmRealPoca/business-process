package com.company.businessprocess.mapper;

import com.company.businessprocess.dto.request.ReceivingNoteRequest;
import com.company.businessprocess.dto.request.SaleInvoiceRequest;
import com.company.businessprocess.dto.response.ReceivingNoteResponse;
import com.company.businessprocess.dto.response.SaleInvoiceResponse;
import com.company.businessprocess.entity.ProductorderEntity;
import com.company.businessprocess.entity.ReceivingnoteEntity;
import com.company.businessprocess.entity.SaleinvoiceEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class SaleInvoiceMapper {
    public abstract SaleInvoiceResponse fromEntityToResponse(SaleinvoiceEntity saleinvoiceEntity);

    public abstract SaleinvoiceEntity fromRequestToEntity(SaleInvoiceRequest receivingNoteRequest);

}

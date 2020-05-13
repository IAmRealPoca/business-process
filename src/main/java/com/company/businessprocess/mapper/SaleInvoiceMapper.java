package com.company.businessprocess.mapper;

import com.company.businessprocess.dto.request.ReceivingNoteRequest;
import com.company.businessprocess.dto.request.SaleInvoiceRequest;
import com.company.businessprocess.dto.response.ReceivingNoteResponse;
import com.company.businessprocess.dto.response.SaleInvoiceResponse;
import com.company.businessprocess.entity.ProductorderEntity;
import com.company.businessprocess.entity.ReceivingnoteEntity;
import com.company.businessprocess.entity.SaleinvoiceEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {ProductMapper.class, StaffMapper.class, CustomerMapper.class})
public abstract class SaleInvoiceMapper {
    @Mappings({
            @Mapping(target = "productResponse", source = "productByProductId"),
            @Mapping(target = "staffResponse", source = "staffByStaffId"),
            @Mapping(target = "customerResponse", source = "customerByCustomerId")
    })
    public abstract SaleInvoiceResponse fromEntityToResponse(SaleinvoiceEntity saleinvoiceEntity);

    public abstract SaleinvoiceEntity fromRequestToEntity(SaleInvoiceRequest receivingNoteRequest);

}

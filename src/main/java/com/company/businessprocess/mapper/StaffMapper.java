package com.company.businessprocess.mapper;

import com.company.businessprocess.dto.request.SaleInvoiceRequest;
import com.company.businessprocess.dto.request.StaffRequest;
import com.company.businessprocess.dto.response.SaleInvoiceResponse;
import com.company.businessprocess.dto.response.StaffResponse;
import com.company.businessprocess.entity.SaleinvoiceEntity;
import com.company.businessprocess.entity.StaffEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class StaffMapper {
    public abstract StaffResponse fromEntityToResponse(StaffEntity staffEntity);

    public abstract StaffEntity fromRequestToEntity(StaffRequest staffRequest);

}

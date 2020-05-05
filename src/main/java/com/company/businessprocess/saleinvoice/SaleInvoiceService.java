package com.company.businessprocess.saleinvoice;

import com.company.businessprocess.dto.request.SaleInvoiceRequest;
import com.company.businessprocess.dto.response.SaleInvoiceResponse;
import com.company.businessprocess.entity.SaleinvoiceEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SaleInvoiceService {
    Page<SaleInvoiceResponse> getAllSaleInvoice(Pageable pageable);
    SaleInvoiceResponse addSaleInvoice(SaleInvoiceRequest newSaleInvoice);
    SaleinvoiceEntity updateSaleInvoice (Integer id, SaleinvoiceEntity updateEntity);
    void deleteSaleInvoice (Integer id);
}

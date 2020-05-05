package com.company.businessprocess.saleinvoice;

import com.company.businessprocess.dto.request.SaleInvoiceRequest;
import com.company.businessprocess.dto.response.SaleInvoiceResponse;
import com.company.businessprocess.entity.SaleinvoiceEntity;

import java.util.Collection;

public interface SaleInvoiceService {
    Collection<SaleInvoiceResponse> getAllSaleInvoice();
    SaleinvoiceEntity addSaleInvoice(SaleInvoiceRequest newSaleInvoice);
    SaleinvoiceEntity updateSaleInvoice (Integer id, SaleinvoiceEntity updateEntity);
    void deleteSaleInvoice (Integer id);
}

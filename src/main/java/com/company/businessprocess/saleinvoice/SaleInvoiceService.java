package com.company.businessprocess.saleinvoice;

import com.company.businessprocess.dto.SaleInvoiceResponse;
import com.company.businessprocess.entity.SaleinvoiceEntity;

import java.util.Collection;

public interface SaleInvoiceService {
    Collection<SaleInvoiceResponse> getAllSaleInvoice();
    SaleinvoiceEntity addSaleInvoice(SaleinvoiceEntity newEntity);
    SaleinvoiceEntity updateSaleInvoice (Integer id, SaleinvoiceEntity updateEntity);
    void deleteSaleInvoice (Integer id);
}

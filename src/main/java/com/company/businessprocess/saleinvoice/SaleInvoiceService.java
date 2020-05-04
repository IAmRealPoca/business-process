package com.company.businessprocess.saleinvoice;

import com.company.businessprocess.entity.ReceivingnoteEntity;
import com.company.businessprocess.entity.SaleinvoiceEntity;

import java.util.Collection;

public interface SaleInvoiceService {
    Collection<SaleinvoiceEntity> getAllSaleInvoice();
    SaleinvoiceEntity addSaleInvoice(SaleinvoiceEntity newEntity);
    SaleinvoiceEntity updateSaleInvoice (Integer id, SaleinvoiceEntity updateEntity);
    void deleteSaleInvoice (Integer id);
}

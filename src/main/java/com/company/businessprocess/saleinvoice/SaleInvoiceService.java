package com.company.businessprocess.saleinvoice;

import com.company.businessprocess.dto.request.SaleInvoiceRequest;
import com.company.businessprocess.dto.response.DeliveryNoteResponse;
import com.company.businessprocess.dto.response.SaleInvoiceResponse;
import com.company.businessprocess.entity.SaleinvoiceEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.sql.Date;

public interface SaleInvoiceService {
    Page<SaleInvoiceResponse> getAllSaleInvoice(Pageable pageable);
    Page<SaleInvoiceResponse> searchSaleInvoice(Date beginDate, Date endDate, Pageable pageable);
    Page<SaleInvoiceResponse> reportSaleInvoiceByCustomerAndStaffInDate(String customerName, String staffName,
                                                                        Date beginDate, Date endDate, Pageable pageable);
    SaleInvoiceResponse addSaleInvoice(SaleInvoiceRequest newSaleInvoice);
    SaleInvoiceResponse updateSaleInvoicePrice(Integer id, Double price);
    void deleteSaleInvoice (Integer id);
}

package com.company.businessprocess.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SaleInvoiceRequest {
    private Integer productId;
    private Integer customerId;
    private Integer staffId;
    private Date saleDate;
    private Integer quantity;
    private Integer totalValue;
}
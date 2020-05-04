package com.company.businessprocess.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SaleInvoiceResponse {
    private Integer saleId;
    private Date saleDate;
    private Integer quantity;
    private Integer totalValue;
}

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
public class ProductOrderRequest {
    private Integer productId;
    private Integer staffId;
    private Date orderDate;
    private Integer quantity;
}
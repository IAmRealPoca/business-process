package com.company.businessprocess.dto.response;

import com.company.businessprocess.entity.CustomerEntity;
import com.company.businessprocess.entity.ProductEntity;
import com.company.businessprocess.entity.StaffEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.util.CollectionUtils;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SaleInvoiceResponse {
    private Integer saleId;
    private Date saleDate;
    private Double price;
    private Integer quantity;
    private Double totalValue;
    private ProductResponse productResponse;
    private StaffResponse staffResponse;
    private CustomerResponse customerResponse;

}

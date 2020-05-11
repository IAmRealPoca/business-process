package com.company.businessprocess.dto.request;

import com.company.businessprocess.entity.ProductEntity;
import com.company.businessprocess.entity.ProductorderEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductOrderDetailRequest {
    private Integer quantity;
    private Double price;
    private Integer productId;
//    private Integer productOrderId;
}

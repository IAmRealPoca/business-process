package com.company.businessprocess.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductOrderDetailResponse {
    private Integer productOrderDetailId;
    private Integer quantity;
    private Double price;
    private Map<String, Object> productInfo;
    private Map<String, Object> productOrderInfo;
}

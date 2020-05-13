package com.company.businessprocess.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryNoteDetailResponse {
    private Integer deliveryDetailId;
    private Integer quantity;
    private Double price;
    private ProductResponse productResponse;
}

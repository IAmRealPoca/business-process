package com.company.businessprocess.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryNoteRequest {
    private Integer productId;
    private Integer customerId;
    private Integer staffId;
    private Integer quantity;
}

package com.company.businessprocess.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReceivingNoteDetailResponse {
    private Integer receiveDetailId;
    private Integer quantity;
    private Double price;
    private ProductResponse productResponse;
}

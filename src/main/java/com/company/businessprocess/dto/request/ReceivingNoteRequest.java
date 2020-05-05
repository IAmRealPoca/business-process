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
public class ReceivingNoteRequest {
    private Integer staffId;
    private Integer productId;
    private Date receiveDate;
    private Integer quantity;
}

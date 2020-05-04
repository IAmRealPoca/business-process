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
public class ReceivingNoteResponse {
    private Integer receiveId;
    private Date receiveDate;
    private Integer quantity;
}

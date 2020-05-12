package com.company.businessprocess.dto.response;

import com.company.businessprocess.entity.ProductEntity;
import com.company.businessprocess.entity.ReceivingnotedetailEntity;
import com.company.businessprocess.entity.StaffEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.util.CollectionUtils;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReceivingNoteResponse {
    private Integer receiveId;
    private Date receiveDate;

    private List<ReceivingNoteDetailResponse> receivingNoteDetailResponses;
}

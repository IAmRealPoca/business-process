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

    private Map<String, Object> staffInfo;
    private List<Object> receivingNoteDetailInfo;

    public void mapReceivingNoteDetailInfo(Collection<ReceivingnotedetailEntity> source) {
        if (CollectionUtils.isEmpty(receivingNoteDetailInfo)) {
            receivingNoteDetailInfo = new ArrayList<>();
        }
        for (ReceivingnotedetailEntity entity : source) {
            Map<String, Object> receivingNoteDetail = new HashMap<>();
            receivingNoteDetail.put("receiveDetailId", entity.getReceiveDetailId());
            receivingNoteDetail.put("quantity", entity.getQuantity());
            receivingNoteDetail.put("price", entity.getPrice());

            ProductEntity productEntity = entity.getProductByProductid();
            Map<String, Object> productInfo = new HashMap<>();
            productInfo.put("productId", productEntity.getProductId());
            productInfo.put("name", productEntity.getName());
//            productInfo.put("")
            receivingNoteDetail.put("product", productInfo);
            receivingNoteDetailInfo.add(receivingNoteDetail);
        }
    }

    public void mapStaffInfo(StaffEntity source) {
        if (CollectionUtils.isEmpty(staffInfo)) {
            staffInfo = new HashMap<>();
        }
        staffInfo.put("staffId", source.getStaffId());
        staffInfo.put("name", source.getName());
    }
}

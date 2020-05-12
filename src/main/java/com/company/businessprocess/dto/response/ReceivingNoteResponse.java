package com.company.businessprocess.dto.response;

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
public class ReceivingNoteResponse {
    private Integer receiveId;
    private Date receiveDate;
    private Integer quantity;

    private Map<String, Object> staffInfo;


    public void mapStaffInfo(StaffEntity source) {
        if (CollectionUtils.isEmpty(staffInfo)) {
            staffInfo = new HashMap<>();
        }
        staffInfo.put("staffId", source.getStaffId());
        staffInfo.put("name", source.getName());
    }
}

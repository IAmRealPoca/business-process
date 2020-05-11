package com.company.businessprocess.dto.response;

import com.company.businessprocess.entity.ProductEntity;
import com.company.businessprocess.entity.ProductorderdetailEntity;
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
public class ProductOrderResponse {
    private Integer orderId;
    private Date orderDate;
    private Integer quantity;

//    private Map<String, Object> productOrderDetails;
    private List<Object> productOrderDetails;
    private Map<String, Object> productInfo;
    private Map<String, Object> staffInfo;

    public void mapProductOrderDetail(Collection<ProductorderdetailEntity> source) {
        if (CollectionUtils.isEmpty(productOrderDetails)) {
            productOrderDetails = new ArrayList<>();
        }
        for (ProductorderdetailEntity entity : source) {
            Map<String, Object> productOrderDetail = new HashMap<>();
            productOrderDetail.put("productOrderDetailId", entity.getProductOrderDetailId());
            productOrderDetail.put("quantity", entity.getQuantity());
            productOrderDetail.put("price", entity.getPrice());
            productOrderDetails.add(productOrderDetail);
        }

    }

    public void mapProductInfo(ProductEntity source) {
        if (CollectionUtils.isEmpty(productInfo)) {
            productInfo = new HashMap<>();
        }
        productInfo.put("productId", source.getProductId());
        productInfo.put("name", source.getName());
        productInfo.put("price", source.getPrice());
    }

    public void mapStaffInfo(StaffEntity source) {
        if (CollectionUtils.isEmpty(staffInfo)) {
            staffInfo = new HashMap<>();
        }
        staffInfo.put("staffId", source.getStaffId());
        staffInfo.put("name", source.getName());
    }
}

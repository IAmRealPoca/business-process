package com.company.businessprocess.productorder.productorderdetail;

import com.company.businessprocess.dto.request.ProductOrderDetailRequest;
import com.company.businessprocess.dto.response.ProductOrderDetailResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductOrderDetailService {
    Page<ProductOrderDetailResponse> getAllProductOrderDetail(Pageable pageable);
//    Page<ProductOrderDetailResponse> searchProductOrderDetail()
    ProductOrderDetailResponse addProductOrderDetail(Integer productOrderId, ProductOrderDetailRequest request);
    void deleteProductOrderDetail(Integer id);
}

package com.company.businessprocess.deliverynote.deliverynotedetail;

import com.company.businessprocess.dto.request.ProductOrderDetailRequest;
import com.company.businessprocess.dto.response.ProductOrderDetailResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DeliveryNoteDetailService {
    Page<ProductOrderDetailResponse> getAllProductOrderDetail(Pageable pageable);
//    Page<ProductOrderDetailResponse> searchProductOrderDetail()
    ProductOrderDetailResponse addProductOrderDetail(Integer productOrderId, ProductOrderDetailRequest request);
    void deleteProductOrderDetail(Integer id);
}

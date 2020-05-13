package com.company.businessprocess.deliverynote.deliverynotedetail;

import com.company.businessprocess.dto.request.DeliveryNoteDetailRequest;
import com.company.businessprocess.dto.response.DeliveryNoteDetailResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DeliveryNoteDetailService {
    Page<DeliveryNoteDetailResponse> getAllDeliveryNoteDetail(Pageable pageable);

    //    Page<ProductOrderDetailResponse> searchProductOrderDetail()
    DeliveryNoteDetailResponse addDeliveryNoteDetail(Integer deliveryNoteId, DeliveryNoteDetailRequest request);

    void deleteDeliveryNoteDetail(Integer id);
}

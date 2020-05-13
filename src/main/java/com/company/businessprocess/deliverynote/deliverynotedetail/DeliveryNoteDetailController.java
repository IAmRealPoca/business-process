package com.company.businessprocess.deliverynote.deliverynotedetail;

import com.company.businessprocess.dto.request.DeliveryNoteDetailRequest;
import com.company.businessprocess.dto.response.DeliveryNoteDetailResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/delivery-notes/{id}/delivery-note-details")
public class DeliveryNoteDetailController {
    private DeliveryNoteDetailService productOrderDetailService;

    public DeliveryNoteDetailController(DeliveryNoteDetailService productOrderDetailService) {
        this.productOrderDetailService = productOrderDetailService;
    }

    @PostMapping
    public ResponseEntity<DeliveryNoteDetailResponse> addNewDeliveryNoteDetail(
            @PathVariable("id") Integer deliveryNoteId,
            @RequestBody DeliveryNoteDetailRequest request) {
        return ResponseEntity.ok(productOrderDetailService.addDeliveryNoteDetail(deliveryNoteId, request));
    }

    @DeleteMapping("/{deliveryNoteDetailId}")
    public ResponseEntity<String> deleteProductOrderDetail(
            @PathVariable("id") Integer deliveryNoteId,
            @PathVariable("deliveryNoteDetailId") Integer productOrderDetailId
    ) {
        productOrderDetailService.deleteDeliveryNoteDetail(productOrderDetailId);
        return ResponseEntity.ok("Deleted");
    }
}

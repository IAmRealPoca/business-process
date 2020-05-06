package com.company.businessprocess.deliverynote;

import com.company.businessprocess.dto.request.DeliveryNoteRequest;
import com.company.businessprocess.dto.response.DeliveryNoteResponse;
import com.company.businessprocess.entity.DeliverynoteEntity;
import com.company.businessprocess.utils.PagingAndSortingBuilder;
import com.company.businessprocess.utils.PagingAndSortingOption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/DeliveryNote")
public class DeliveryNoteController {
    private DeliveryNoteService deliveryNoteService;

    @Autowired
    public DeliveryNoteController(DeliveryNoteService deliveryNoteService) {
        this.deliveryNoteService = deliveryNoteService;
    }

    @GetMapping("/get-all-deliverynote")
    public ResponseEntity<Page<DeliveryNoteResponse>> getAllDeliveryNote(PagingAndSortingOption pagingOption) {
        return ResponseEntity.ok(deliveryNoteService.getAllDeliveryNote(PagingAndSortingBuilder.buildPageableObj(pagingOption)));
    }
    @PostMapping
    public ResponseEntity<DeliveryNoteResponse> insertDeliveryNote(DeliveryNoteRequest newDeliveryNote) {
        return ResponseEntity.ok(deliveryNoteService.addDeliveryNote(newDeliveryNote));
    }
//
//    @PutMapping
//    public ResponseEntity<DeliverynoteEntity> updateDeliveryNote(Integer id, DeliverynoteEntity updateEntity) {
//        return ResponseEntity.ok(deliveryNoteService.updateDeliveryNote(id, updateEntity));
//    }

    @DeleteMapping
    public ResponseEntity<String> deleteDeliveryNote(Integer id) {
        deliveryNoteService.deleteDeliveryNote(id);
        return ResponseEntity.ok("Deleted");
    }
}
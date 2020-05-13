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

import java.sql.Date;
import java.util.Collection;

@RestController
@RequestMapping("/delivery-notes")
public class DeliveryNoteController {
    private DeliveryNoteService deliveryNoteService;

    @Autowired
    public DeliveryNoteController(DeliveryNoteService deliveryNoteService) {
        this.deliveryNoteService = deliveryNoteService;
    }

    @GetMapping("/get-all")
    public ResponseEntity<Page<DeliveryNoteResponse>> getAllDeliveryNote(PagingAndSortingOption pagingOption) {
        return ResponseEntity.ok(deliveryNoteService.getAllDeliveryNote(PagingAndSortingBuilder.buildPageableObj(pagingOption)));
    }

    @GetMapping("/search")
    public ResponseEntity<Page<DeliveryNoteResponse>> searchDeliveryNote(Date beginDate, Date endDate, PagingAndSortingOption pagingOption) {
        return ResponseEntity.ok(deliveryNoteService.searchDeliveryNote(beginDate, endDate, PagingAndSortingBuilder.buildPageableObj(pagingOption)));
    }
    @PostMapping
    public ResponseEntity<DeliveryNoteResponse> insertDeliveryNote(
            @RequestBody DeliveryNoteRequest newDeliveryNote) {
        return ResponseEntity.ok(deliveryNoteService.addDeliveryNote(newDeliveryNote));
    }
//
//    @PutMapping
//    public ResponseEntity<DeliverynoteEntity> updateDeliveryNote(Integer id, DeliverynoteEntity updateEntity) {
//        return ResponseEntity.ok(deliveryNoteService.updateDeliveryNote(id, updateEntity));
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDeliveryNote(@PathVariable("id") Integer id) {
        deliveryNoteService.deleteDeliveryNote(id);
        return ResponseEntity.ok("Deleted");
    }
}
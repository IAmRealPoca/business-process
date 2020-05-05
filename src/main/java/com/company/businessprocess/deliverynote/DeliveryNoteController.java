package com.company.businessprocess.deliverynote;

import com.company.businessprocess.dto.request.DeliveryNoteRequest;
import com.company.businessprocess.dto.response.DeliveryNoteResponse;
import com.company.businessprocess.entity.DeliverynoteEntity;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity<Collection<DeliveryNoteResponse>> getAllDeliveryNote() {
        return ResponseEntity.ok(deliveryNoteService.getAllDeliveryNote());
    }
    @PostMapping
    public ResponseEntity<DeliverynoteEntity> insertDeliveryNote(DeliveryNoteRequest newDeliveryNote) {
        return ResponseEntity.ok(deliveryNoteService.addDeliveryNote(newDeliveryNote));
    }

    @PutMapping
    public ResponseEntity<DeliverynoteEntity> updateDeliveryNote(Integer id, DeliverynoteEntity updateEntity) {
        return ResponseEntity.ok(deliveryNoteService.updateDeliveryNote(id, updateEntity));
    }

    @DeleteMapping
    public ResponseEntity<String> deleteDeliveryNote(Integer id) {
        deliveryNoteService.deleteDeliveryNote(id);
        return ResponseEntity.ok("Deleted");
    }
}
package com.company.businessprocess.deliverynote;

import com.company.businessprocess.customer.CustomerService;
import com.company.businessprocess.entity.CustomerEntity;
import com.company.businessprocess.entity.DeliverynoteEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<Collection<DeliverynoteEntity>> getAllDeliveryNote() {
        return ResponseEntity.ok(deliveryNoteService.getAllDeliveryNote());
    }
}
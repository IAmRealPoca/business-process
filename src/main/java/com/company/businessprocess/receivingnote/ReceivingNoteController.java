package com.company.businessprocess.receivingnote;

import com.company.businessprocess.entity.ProductorderEntity;
import com.company.businessprocess.entity.ReceivingnoteEntity;
import com.company.businessprocess.productorder.ProductOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/ReceivingNote")
public class ReceivingNoteController {
    private ReceivingNoteService receivingNoteService;

    @Autowired
    public ReceivingNoteController(ReceivingNoteService receivingNoteService) {
        this.receivingNoteService = receivingNoteService;
    }

    @GetMapping("/get-all-receivingnote")
    public ResponseEntity<Collection<ReceivingnoteEntity>> getAllReceivingNote() {
        return ResponseEntity.ok(receivingNoteService.getAllReceivingNote());
    }
}
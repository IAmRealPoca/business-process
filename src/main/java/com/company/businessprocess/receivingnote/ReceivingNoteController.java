package com.company.businessprocess.receivingnote;

import com.company.businessprocess.dto.request.ReceivingNoteRequest;
import com.company.businessprocess.dto.response.ReceivingNoteResponse;
import com.company.businessprocess.entity.ReceivingnoteEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<Collection<ReceivingNoteResponse>> getAllReceivingNote() {
        return ResponseEntity.ok(receivingNoteService.getAllReceivingNote());
    }
    @PostMapping
    public ResponseEntity<ReceivingnoteEntity> insertReceivingNote(ReceivingNoteRequest newReceivingNote) {
        return ResponseEntity.ok(receivingNoteService.addReceivingNote(newReceivingNote));
    }

    @PutMapping
    public ResponseEntity<ReceivingnoteEntity> updateReceivingNote(Integer id, ReceivingnoteEntity updateEntity) {
        return ResponseEntity.ok(receivingNoteService.updateReceivingNote(id, updateEntity));
    }

    @DeleteMapping
    public ResponseEntity<String> deleteReceivingNote(Integer id) {
        receivingNoteService.deleteReceivingNote(id);
        return ResponseEntity.ok("Deleted");
    }
}
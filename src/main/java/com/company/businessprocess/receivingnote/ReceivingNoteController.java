package com.company.businessprocess.receivingnote;

import com.company.businessprocess.dto.request.ReceivingNoteRequest;
import com.company.businessprocess.dto.response.ReceivingNoteResponse;
import com.company.businessprocess.entity.ReceivingnoteEntity;
import com.company.businessprocess.utils.PagingAndSortingBuilder;
import com.company.businessprocess.utils.PagingAndSortingOption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.Collection;

@RestController
@RequestMapping("/receiving-notes")
public class ReceivingNoteController {
    private ReceivingNoteService receivingNoteService;

    @Autowired
    public ReceivingNoteController(ReceivingNoteService receivingNoteService) {
        this.receivingNoteService = receivingNoteService;
    }

    @GetMapping("/get-all")
    public ResponseEntity<Page<ReceivingNoteResponse>> getAllReceivingNote(PagingAndSortingOption pagingOption) {
        return ResponseEntity.ok(receivingNoteService.getAllReceivingNote(PagingAndSortingBuilder.buildPageableObj(pagingOption)));
    }

    @GetMapping("/search")
    public ResponseEntity<Page<ReceivingNoteResponse>> searchReceivingNote(Date beginDate, Date endDate, PagingAndSortingOption pagingOption) {
        return ResponseEntity.ok(receivingNoteService.searchReceivingNote(beginDate, endDate, PagingAndSortingBuilder.buildPageableObj(pagingOption)));
    }

    @PostMapping
    public ResponseEntity<ReceivingNoteResponse> insertReceivingNote(
            @RequestBody ReceivingNoteRequest newReceivingNote) {
        return ResponseEntity.ok(receivingNoteService.addReceivingNote(newReceivingNote));
    }

//    @PutMapping
//    public ResponseEntity<ReceivingnoteEntity> updateReceivingNote(Integer id, ReceivingnoteEntity updateEntity) {
//        return ResponseEntity.ok(receivingNoteService.updateReceivingNote(id, updateEntity));
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteReceivingNote(@PathVariable("id")Integer id) {
        receivingNoteService.deleteReceivingNote(id);
        return ResponseEntity.ok("Deleted");
    }
}
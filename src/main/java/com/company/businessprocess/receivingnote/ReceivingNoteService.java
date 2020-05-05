package com.company.businessprocess.receivingnote;

import com.company.businessprocess.dto.request.ReceivingNoteRequest;
import com.company.businessprocess.dto.response.ReceivingNoteResponse;
import com.company.businessprocess.entity.ReceivingnoteEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Collection;

public interface ReceivingNoteService {
    Page<ReceivingNoteResponse> getAllReceivingNote(Pageable pageable);
    ReceivingNoteResponse addReceivingNote(ReceivingNoteRequest newReceivingNote);
    ReceivingnoteEntity updateReceivingNote (Integer id, ReceivingnoteEntity updateEntity);
    void deleteReceivingNote (Integer Id);
}

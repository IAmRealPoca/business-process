package com.company.businessprocess.receivingnote;

import com.company.businessprocess.dto.response.ReceivingNoteResponse;
import com.company.businessprocess.entity.ReceivingnoteEntity;

import java.util.Collection;

public interface ReceivingNoteService {
    Collection<ReceivingNoteResponse> getAllReceivingNote();
    ReceivingnoteEntity addReceivingNote(ReceivingnoteEntity newEntity);
    ReceivingnoteEntity updateReceivingNote (Integer id, ReceivingnoteEntity updateEntity);
    void deleteReceivingNote (Integer Id);
}

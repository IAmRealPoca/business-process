package com.company.businessprocess.receivingnote;

import com.company.businessprocess.entity.ProductorderEntity;
import com.company.businessprocess.entity.ReceivingnoteEntity;

import java.util.Collection;

public interface ReceivingNoteService {
    Collection<ReceivingnoteEntity> getAllReceivingNote();
    ReceivingnoteEntity addReceivingNote(ReceivingnoteEntity newEntity);
    ReceivingnoteEntity updateReceivingNote (Integer id, ReceivingnoteEntity updateEntity);
    void deleteReceivingNote (Integer Id);
}

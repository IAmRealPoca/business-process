package com.company.businessprocess.receivingnote;

import com.company.businessprocess.entity.ReceivingnoteEntity;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ReceivingNoteServiceImpl implements ReceivingNoteService {

    private ReceivingNoteRepository receivingNoteRepository;

    public ReceivingNoteServiceImpl(ReceivingNoteRepository receivingNoteRepository) {
        this.receivingNoteRepository = receivingNoteRepository;
    }

    @Override
    public Collection<ReceivingnoteEntity> getAllReceivingNote() {
        return receivingNoteRepository.findAll();
    }

    @Override
    public ReceivingnoteEntity addReceivingNote(ReceivingnoteEntity newEntity) {
        return receivingNoteRepository.save(newEntity);
    }

    @Override
    public ReceivingnoteEntity updateReceivingNote(Integer id, ReceivingnoteEntity updateEntity) {
        return receivingNoteRepository.save(updateEntity);
    }

    @Override
    public void deleteReceivingNote(Integer id) {
        receivingNoteRepository.deleteById(id);
    }
}

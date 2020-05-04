package com.company.businessprocess.receivingnote;

import com.company.businessprocess.dto.ReceivingNoteResponse;
import com.company.businessprocess.entity.ReceivingnoteEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class ReceivingNoteServiceImpl implements ReceivingNoteService {

    private ReceivingNoteRepository receivingNoteRepository;
    private ModelMapper mapper;

    public ReceivingNoteServiceImpl(ReceivingNoteRepository receivingNoteRepository, ModelMapper mapper) {
        this.receivingNoteRepository = receivingNoteRepository;
        this.mapper = mapper;
    }

    @Override
    public Collection<ReceivingNoteResponse> getAllReceivingNote() {
        Collection<ReceivingNoteResponse> receivingNoteResponses =
                receivingNoteRepository.findAll().stream()
                        .map(receivingnoteEntity -> mapper.map(receivingnoteEntity, ReceivingNoteResponse.class))
                        .collect(Collectors.toList());
        return receivingNoteResponses;
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

package com.company.businessprocess.deliverynote;


import com.company.businessprocess.dto.request.DeliveryNoteRequest;
import com.company.businessprocess.dto.response.DeliveryNoteResponse;
import com.company.businessprocess.entity.DeliverynoteEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class DeliveryNoteServiceImpl implements DeliveryNoteService {
    private DeliveryNoteRepository deliveryNoteRepository;
    private ModelMapper mapper;

    public DeliveryNoteServiceImpl(DeliveryNoteRepository deliveryNoteRepository, ModelMapper mapper) {
        this.deliveryNoteRepository = deliveryNoteRepository;
        this.mapper = mapper;
    }

    @Override
    public Collection<DeliveryNoteResponse> getAllDeliveryNote() {
        Collection<DeliveryNoteResponse> deliveryNoteResponses =
                deliveryNoteRepository.findAll().stream()
                        .map(deliverynoteEntity -> mapper.map(deliverynoteEntity, DeliveryNoteResponse.class))
                        .collect(Collectors.toList());
        return deliveryNoteResponses;
    }

    @Override
    public DeliverynoteEntity addDeliveryNote(DeliveryNoteRequest newDeliveryNote) {
        DeliverynoteEntity newEntity = mapper.map(newDeliveryNote, DeliverynoteEntity.class);
        return deliveryNoteRepository.save(newEntity);
    }

    @Override
    public DeliverynoteEntity updateDeliveryNote(Integer id, DeliverynoteEntity updateEntity) {
        return deliveryNoteRepository.save(updateEntity);
    }

    @Override
    public void deleteDeliveryNote(Integer id) {
        deliveryNoteRepository.deleteById(id);
    }
}

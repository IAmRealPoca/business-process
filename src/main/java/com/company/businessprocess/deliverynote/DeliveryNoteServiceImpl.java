package com.company.businessprocess.deliverynote;


import com.company.businessprocess.entity.DeliverynoteEntity;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class DeliveryNoteServiceImpl implements DeliveryNoteService {
    private DeliveryNoteRepository deliveryNoteRepository;

    public DeliveryNoteServiceImpl(DeliveryNoteRepository deliveryNoteRepository) {
        this.deliveryNoteRepository = deliveryNoteRepository;
    }

    @Override
    public Collection<DeliverynoteEntity> getAllDeliveryNote() {
        return deliveryNoteRepository.findAll();
    }

    @Override
    public DeliverynoteEntity addDeliveryNote(DeliverynoteEntity newEntity) {
        return deliveryNoteRepository.save(newEntity);
    }

    @Override
    public DeliverynoteEntity updateDeliveryNote(Integer Id, DeliverynoteEntity updateEntity) {
        return deliveryNoteRepository.save(updateEntity);
    }

    @Override
    public void deleteDeliveryNote(Integer id) {
        deliveryNoteRepository.deleteById(id);
    }
}

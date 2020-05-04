package com.company.businessprocess.deliverynote;

import com.company.businessprocess.entity.DeliverynoteEntity;

import java.util.Collection;

public interface DeliveryNoteService {
    Collection<DeliverynoteEntity> getAllDeliveryNote();
    DeliverynoteEntity addDeliveryNote(DeliverynoteEntity newEntity);
    DeliverynoteEntity updateDeliveryNote (Integer id, DeliverynoteEntity updateEntity);
    void deleteDeliveryNote (Integer id);
}

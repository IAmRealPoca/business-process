package com.company.businessprocess.deliverynote;

import com.company.businessprocess.dto.request.DeliveryNoteRequest;
import com.company.businessprocess.dto.response.DeliveryNoteResponse;
import com.company.businessprocess.entity.DeliverynoteEntity;

import java.util.Collection;

public interface DeliveryNoteService {
    Collection<DeliveryNoteResponse> getAllDeliveryNote();
    DeliveryNoteResponse addDeliveryNote(DeliveryNoteRequest newDeliveryNote);
    DeliverynoteEntity updateDeliveryNote (Integer id, DeliverynoteEntity updateEntity);
    void deleteDeliveryNote (Integer id);
}

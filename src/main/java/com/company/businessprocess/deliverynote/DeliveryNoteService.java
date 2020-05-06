package com.company.businessprocess.deliverynote;

import com.company.businessprocess.dto.request.DeliveryNoteRequest;
import com.company.businessprocess.dto.response.DeliveryNoteResponse;
import com.company.businessprocess.entity.DeliverynoteEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.sql.Date;
import java.util.Collection;

public interface DeliveryNoteService {
    Page<DeliveryNoteResponse> getAllDeliveryNote(Pageable pageable);
    Page<DeliveryNoteResponse> searchDeliveryNote(Date beginDate, Date endDate, Pageable pageable);
    DeliveryNoteResponse addDeliveryNote(DeliveryNoteRequest newDeliveryNote);
    DeliverynoteEntity updateDeliveryNote (Integer id, DeliverynoteEntity updateEntity);
    void deleteDeliveryNote (Integer id);
}

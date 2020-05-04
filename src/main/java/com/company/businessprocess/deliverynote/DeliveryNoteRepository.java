package com.company.businessprocess.deliverynote;

import com.company.businessprocess.entity.DeliverynoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryNoteRepository extends JpaRepository<DeliverynoteEntity, Integer> {

}

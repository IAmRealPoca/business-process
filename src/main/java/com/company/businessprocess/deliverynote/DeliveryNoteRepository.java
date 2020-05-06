package com.company.businessprocess.deliverynote;

import com.company.businessprocess.entity.DeliverynoteEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;

@Repository
public interface DeliveryNoteRepository extends JpaRepository<DeliverynoteEntity, Integer> {
    Page<DeliverynoteEntity> findAllBySaleDateBetween(Date beginDate, Date endDate, Pageable pageable);
    Page<DeliverynoteEntity> findAllBySaleDateAfter(Date beginDate, Pageable pageable);
    Page<DeliverynoteEntity> findAllBySaleDateBefore(Date endDate, Pageable pageable);
}

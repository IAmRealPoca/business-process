package com.company.businessprocess.receivingnote;


import com.company.businessprocess.entity.ProductorderEntity;
import com.company.businessprocess.entity.ReceivingnoteEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;

@Repository
public interface ReceivingNoteRepository extends JpaRepository<ReceivingnoteEntity, Integer> {
    Page<ReceivingnoteEntity> findAllByReceiveDateBetween(Date beginDate, Date endDate, Pageable pageable);
    Page<ReceivingnoteEntity> findAllByReceiveDateAfter(Date beginDate, Pageable pageable);
    Page<ReceivingnoteEntity> findAllByReceiveDateBefore(Date endDate, Pageable pageable);

//    ReceivingnoteEntity findBy
}
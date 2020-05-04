package com.company.businessprocess.receivingnote;


import com.company.businessprocess.entity.ReceivingnoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceivingNoteRepository extends JpaRepository<ReceivingnoteEntity, Integer> {

}
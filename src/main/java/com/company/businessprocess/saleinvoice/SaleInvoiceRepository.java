package com.company.businessprocess.saleinvoice;

import com.company.businessprocess.entity.ReceivingnoteEntity;
import com.company.businessprocess.entity.SaleinvoiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleInvoiceRepository extends JpaRepository<SaleinvoiceEntity, Integer> {

}

package com.company.businessprocess.saleinvoice;

import com.company.businessprocess.entity.DeliverynoteEntity;
import com.company.businessprocess.entity.ReceivingnoteEntity;
import com.company.businessprocess.entity.SaleinvoiceEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Date;

@Repository
public interface SaleInvoiceRepository extends JpaRepository<SaleinvoiceEntity, Integer> {
    Page<SaleinvoiceEntity> findAllBySaleDateBetween(Date beginDate, Date endDate, Pageable pageable);
    Page<SaleinvoiceEntity> findAllBySaleDateAfter(Date beginDate, Pageable pageable);
    Page<SaleinvoiceEntity> findAllBySaleDateBefore(Date endDate, Pageable pageable);

    @Query(value = "SELECT SI.*, CUS.NAME, S.NAME " +
            "FROM SALEINVOICE SI " +
            "INNER JOIN CUSTOMER CUS ON CUS.CUSTOMERID = SI.CUSTOMERID " +
            "INNER JOIN STAFF S ON S.STAFFID = SI.STAFFID " +
            "WHERE SI.SALEDATE BETWEEN :#{#beginDate} AND :#{#endDate} " +
            "AND CUS.NAME LIKE CONCAT('%',:#{#customerName},'%') " +
            "    AND S.NAME LIKE CONCAT('%',:#{#staffName} ,'%')"
    , nativeQuery = true)
    Page<SaleinvoiceEntity> customFindAllByCustomerAndStaffAndDate(String customerName, String staffName,
                                                                   Date beginDate, Date endDate, Pageable pageable);
}

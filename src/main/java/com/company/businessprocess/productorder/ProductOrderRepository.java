package com.company.businessprocess.productorder;

import com.company.businessprocess.entity.ProductorderEntity;
import com.company.businessprocess.entity.SaleinvoiceEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;

@Repository
public interface ProductOrderRepository extends JpaRepository<ProductorderEntity, Integer> {
    Page<ProductorderEntity> findAllByOrderDateBetween(Date beginDate, Date endDate, Pageable pageable);
    Page<ProductorderEntity> findAllByOrderDateAfter(Date beginDate, Pageable pageable);
    Page<ProductorderEntity> findAllByOrderDateBefore(Date endDate, Pageable pageable);
}
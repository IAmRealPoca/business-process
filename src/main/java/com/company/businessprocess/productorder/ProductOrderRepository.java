package com.company.businessprocess.productorder;

import com.company.businessprocess.entity.ProductorderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductOrderRepository extends JpaRepository<ProductorderEntity, Integer> {

}
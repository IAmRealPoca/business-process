package com.company.businessprocess.productorder.productorderdetail;

import com.company.businessprocess.entity.ProductorderdetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductOrderDetailRepository extends JpaRepository<ProductorderdetailEntity, Integer> {
}

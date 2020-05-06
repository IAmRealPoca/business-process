package com.company.businessprocess.customer;

import com.company.businessprocess.entity.CustomerEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer> {

    Page<CustomerEntity> findAllByNameLikeAndAddressLikeAndPhone(String name, String address, Integer phone, Pageable pageable);

    Page<CustomerEntity> findAllByNameLikeAndAddressLike(String name, String address, Pageable pageable);
}

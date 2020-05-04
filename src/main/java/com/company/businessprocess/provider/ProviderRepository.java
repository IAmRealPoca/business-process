package com.company.businessprocess.provider;

import com.company.businessprocess.entity.ProviderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProviderRepository extends JpaRepository<ProviderEntity, Integer> {
}

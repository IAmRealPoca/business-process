package com.company.businessprocess.provider;

import com.company.businessprocess.entity.ProductorderEntity;
import com.company.businessprocess.entity.ProviderEntity;

import java.util.Collection;

public interface ProviderService {
    Collection<ProviderEntity> getAllProvider();
    ProviderEntity addProvider(ProviderEntity newEntity);
    ProviderEntity updateProvider (Integer id, ProviderEntity updateEntity);
    void deleteProvider (Integer id);
}

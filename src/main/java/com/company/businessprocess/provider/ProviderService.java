package com.company.businessprocess.provider;

import com.company.businessprocess.dto.ProviderResponse;
import com.company.businessprocess.entity.ProviderEntity;

import java.util.Collection;

public interface ProviderService {
    Collection<ProviderResponse> getAllProvider();
    ProviderEntity addProvider(ProviderEntity newEntity);
    ProviderEntity updateProvider (Integer id, ProviderEntity updateEntity);
    void deleteProvider (Integer id);
}

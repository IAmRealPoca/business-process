package com.company.businessprocess.provider;

import com.company.businessprocess.dto.request.ProviderRequest;
import com.company.businessprocess.dto.response.ProviderResponse;
import com.company.businessprocess.entity.ProviderEntity;

import java.util.Collection;

public interface ProviderService {
    Collection<ProviderResponse> getAllProvider();
    ProviderResponse addProvider(ProviderRequest newProvider);
    ProviderResponse updateProvider (Integer id, ProviderEntity updateEntity);
    void deleteProvider (Integer id);
}

package com.company.businessprocess.provider;

import com.company.businessprocess.dto.request.ProviderRequest;
import com.company.businessprocess.dto.response.ProviderResponse;
import com.company.businessprocess.entity.ProviderEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Collection;

public interface ProviderService {
    Page<ProviderResponse> getAllProvider(Pageable pageable);
    ProviderResponse addProvider(ProviderRequest newProvider);
    ProviderResponse updateProvider (Integer id, ProviderRequest updateEntity);
    void deleteProvider (Integer id);
}

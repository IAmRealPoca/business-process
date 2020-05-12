package com.company.businessprocess.provider;

import com.company.businessprocess.dto.request.ProviderRequest;
import com.company.businessprocess.dto.response.ProviderResponse;
import com.company.businessprocess.entity.ProviderEntity;
import com.company.businessprocess.mapper.ProviderMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProviderServiceImpl implements ProviderService {

    private ProviderRepository providerRepository;
    private ProviderMapper providerMapper;

    public ProviderServiceImpl(ProviderRepository providerRepository, ProviderMapper providerMapper) {
        this.providerRepository = providerRepository;
        this.providerMapper = providerMapper;
    }

    @Override
    public Page<ProviderResponse> getAllProvider(Pageable pageable) {
        Page<ProviderEntity> providerEntities = providerRepository.findAll(pageable);
        Page<ProviderResponse> providerResponses =providerEntities.map(providerEntity -> providerMapper.fromEntityToResponse(providerEntity));
        return providerResponses;
    }

    @Override
    public ProviderResponse addProvider(ProviderRequest newProvider) {
        ProviderEntity newEntity = providerMapper.fromRequestToEntity(newProvider);
        return providerMapper.fromEntityToResponse(providerRepository.save(newEntity));
    }

    @Override
    public ProviderResponse updateProvider(Integer id, ProviderRequest updateEntity) {
        Optional<ProviderEntity> optionalProviderEntity = providerRepository.findById(id);
        if (optionalProviderEntity.isPresent()) {
            ProviderEntity currentProvider = optionalProviderEntity.get();
            currentProvider.mergeToUpdate(updateEntity);
            return providerMapper.fromEntityToResponse(providerRepository.save(currentProvider));
        }
        return null;
    }

    @Override
    public void deleteProvider(Integer id) {
        Optional<ProviderEntity> optionalProviderEntity = providerRepository.findById(id);
        if (optionalProviderEntity.isPresent()) {
            providerRepository.deleteById(id);
        }
    }
}

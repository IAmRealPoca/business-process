package com.company.businessprocess.provider;

import com.company.businessprocess.dto.request.ProviderRequest;
import com.company.businessprocess.dto.response.ProviderResponse;
import com.company.businessprocess.entity.ProductEntity;
import com.company.businessprocess.entity.ProviderEntity;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProviderServiceImpl implements ProviderService {

    private ProviderRepository providerRepository;
    private ModelMapper mapper;

    public ProviderServiceImpl(ProviderRepository providerRepository, ModelMapper mapper) {
        this.providerRepository = providerRepository;
        this.mapper = mapper;
    }

    @Override
    public Page<ProviderResponse> getAllProvider(Pageable pageable) {
        Page<ProviderEntity> providerEntities = providerRepository.findAll(pageable);
        Page<ProviderResponse> providerResponses =providerEntities.map(providerEntity -> mapper.map(providerEntity, ProviderResponse.class));
        return providerResponses;
    }

    @Override
    public ProviderResponse addProvider(ProviderRequest newProvider) {
        ProviderEntity newEntity = mapper.map(newProvider, ProviderEntity.class);
        return mapper.map(providerRepository.save(newEntity), ProviderResponse.class);
    }

    @Override
    public ProviderResponse updateProvider(Integer id, ProviderRequest updateEntity) {
        Optional<ProviderEntity> optionalProviderEntity = providerRepository.findById(id);
        if (optionalProviderEntity.isPresent()) {
            ProviderEntity currentProvider = optionalProviderEntity.get();
            currentProvider.mergeToUpdate(updateEntity);
            return mapper.map(providerRepository.save(currentProvider), ProviderResponse.class);
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

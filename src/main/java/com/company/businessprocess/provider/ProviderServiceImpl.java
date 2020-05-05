package com.company.businessprocess.provider;

import com.company.businessprocess.dto.request.ProviderRequest;
import com.company.businessprocess.dto.response.ProviderResponse;
import com.company.businessprocess.entity.ProductEntity;
import com.company.businessprocess.entity.ProviderEntity;
import org.modelmapper.ModelMapper;
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
    public Collection<ProviderResponse> getAllProvider() {
        Collection<ProviderResponse> providerResponses =
                providerRepository.findAll().stream()
                        .map(providerEntity -> mapper.map(providerEntity, ProviderResponse.class))
                        .collect(Collectors.toList());
        return providerResponses;
    }

    @Override
    public ProviderEntity addProvider(ProviderRequest newProvider) {
        ProviderEntity newEntity = mapper.map(newProvider, ProviderEntity.class);
        return providerRepository.save(newEntity);
    }

    @Override
    public ProviderEntity updateProvider(Integer id, ProviderEntity updateEntity) {
        return providerRepository.save(updateEntity);
    }

    @Override
    public void deleteProvider(Integer id) {
        Optional<ProviderEntity> optionalProviderEntity = providerRepository.findById(id);
        if (optionalProviderEntity.isPresent()) {
            providerRepository.deleteById(id);
        }
    }
}

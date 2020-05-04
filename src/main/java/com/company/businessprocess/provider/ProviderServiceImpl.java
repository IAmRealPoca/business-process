package com.company.businessprocess.provider;

import com.company.businessprocess.entity.ProviderEntity;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ProviderServiceImpl implements ProviderService {

    private ProviderRepository providerRepository;

    public ProviderServiceImpl(ProviderRepository providerRepository) {
        this.providerRepository = providerRepository;
    }

    @Override
    public Collection<ProviderEntity> getAllProvider() {
        return providerRepository.findAll();
    }

    @Override
    public ProviderEntity addProvider(ProviderEntity newEntity) {
        return providerRepository.save(newEntity);
    }

    @Override
    public ProviderEntity updateProvider(Integer id, ProviderEntity updateEntity) {
        return providerRepository.save(updateEntity);
    }

    @Override
    public void deleteProvider(Integer id) {
        providerRepository.deleteById(id);
    }
}

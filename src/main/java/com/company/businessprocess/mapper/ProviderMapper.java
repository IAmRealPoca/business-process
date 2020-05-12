package com.company.businessprocess.mapper;

import com.company.businessprocess.dto.request.ProviderRequest;
import com.company.businessprocess.dto.response.ProviderResponse;
import com.company.businessprocess.entity.ProviderEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class ProviderMapper {
    public abstract ProviderResponse fromEntityToResponse(ProviderEntity categoryEntity);

    public abstract List<ProviderResponse> fromEntitiesToResponses(List<ProviderEntity> categoryEntities);

    public abstract ProviderEntity fromRequestToEntity(ProviderRequest categoryRequest);
}

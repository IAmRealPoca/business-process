package com.company.businessprocess.mapper;

import com.company.businessprocess.dto.request.ProductRequest;
import com.company.businessprocess.dto.response.ProductResponse;
import com.company.businessprocess.entity.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class, ProviderMapper.class})
public abstract class ProductMapper {
    @Mappings({
            @Mapping(target = "providerResponse", source = "providerByCompany"),
            @Mapping(target = "categoryResponse", source ="categoryByCategoryId")
    })
    public abstract ProductResponse fromEntityToResponse(ProductEntity productEntity);
    public abstract ProductEntity fromRequestToEntity(ProductRequest productRequest);
}

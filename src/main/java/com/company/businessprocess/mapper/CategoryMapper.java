package com.company.businessprocess.mapper;

import com.company.businessprocess.dto.request.CategoryRequest;
import com.company.businessprocess.dto.response.CategoryResponse;
import com.company.businessprocess.entity.CategoryEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class CategoryMapper {
    public abstract CategoryResponse fromEntityToResponse(CategoryEntity categoryEntity);
    public abstract List<CategoryResponse> fromEntitiesToResponses(List<CategoryEntity> categoryEntities);
    public abstract CategoryEntity fromRequestToEntity(CategoryRequest categoryRequest);
}

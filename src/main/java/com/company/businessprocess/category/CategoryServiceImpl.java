package com.company.businessprocess.category;

import com.company.businessprocess.dto.request.CategoryRequest;
import com.company.businessprocess.dto.response.CategoryResponse;
import com.company.businessprocess.dto.response.ProductResponse;
import com.company.businessprocess.entity.CategoryEntity;
import com.company.businessprocess.entity.ProductEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {
    private CategoryRepository categoryRepository;
    private ModelMapper mapper;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper mapper) {
        this.categoryRepository = categoryRepository;
        this.mapper = mapper;
    }

    @Override
    public Collection<CategoryResponse> getAllCategory() {
        Collection<CategoryResponse> categoryResponses =
                categoryRepository.findAll().stream()
                        .map(categoryEntity -> mapper.map(categoryEntity, CategoryResponse.class))
                        .collect(Collectors.toList());
        return categoryResponses;
    }

    @Override
    public CategoryResponse addCategory(CategoryRequest newCategory) {
        CategoryEntity newEntity = mapper.map(newCategory, CategoryEntity.class);
        return mapper.map(categoryRepository.save(newEntity), CategoryResponse.class);
    }

    @Override
    public CategoryResponse updateCategory(Integer id, CategoryEntity updateEntity) {
        Optional<CategoryEntity> optionalCategoryEntity = categoryRepository.findById(id);
        if (optionalCategoryEntity.isPresent()) {
            CategoryEntity currentCategory = optionalCategoryEntity.get();
            currentCategory.mergeToUpdate(updateEntity);
            return mapper.map(categoryRepository.save(updateEntity), CategoryResponse.class);
        }
        return null;
    }

    @Override
    public void deleteCategory(Integer id) {
        Optional<CategoryEntity> optionalCategoryEntity = categoryRepository.findById(id);
        if (optionalCategoryEntity.isPresent()) {
            categoryRepository.deleteById(id);
        }
    }
}

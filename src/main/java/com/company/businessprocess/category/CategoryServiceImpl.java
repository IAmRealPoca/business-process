package com.company.businessprocess.category;

import com.company.businessprocess.dto.CategoryResponse;
import com.company.businessprocess.entity.CategoryEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
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
    public CategoryEntity addCategory(CategoryEntity newEntity) {
        return categoryRepository.save(newEntity);
    }

    @Override
    public CategoryEntity updateCategory(Integer id, CategoryEntity updateEntity) {
        return categoryRepository.save(updateEntity);
    }

    @Override
    public void deleteCategory(Integer id) {
        categoryRepository.deleteById(id);
    }
}

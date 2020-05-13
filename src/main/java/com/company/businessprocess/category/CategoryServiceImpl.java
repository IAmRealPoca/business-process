package com.company.businessprocess.category;

import com.company.businessprocess.dto.request.CategoryRequest;
import com.company.businessprocess.dto.response.CategoryResponse;
import com.company.businessprocess.entity.CategoryEntity;
import com.company.businessprocess.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    private CategoryRepository categoryRepository;
    private CategoryMapper categoryMapper;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    @Override
    public Page<CategoryResponse> getAllCategory(Pageable pageable) {
        Page<CategoryEntity> categoryResponses = categoryRepository.findAll(pageable);
        Page<CategoryResponse> responses = categoryResponses.map(categoryEntity -> categoryMapper.fromEntityToResponse(categoryEntity));
        return responses;
    }

    @Override
    public CategoryResponse addCategory(CategoryRequest newCategory) {
        CategoryEntity newEntity = categoryMapper.fromRequestToEntity(newCategory);
        return categoryMapper.fromEntityToResponse(categoryRepository.save(newEntity));
    }

    @Override
    public CategoryResponse updateCategory(Integer id, CategoryRequest updateEntity) {
        Optional<CategoryEntity> optionalCategoryEntity = categoryRepository.findById(id);
        if (optionalCategoryEntity.isPresent()) {
            CategoryEntity currentCategory = optionalCategoryEntity.get();
            currentCategory.mergeToUpdate(updateEntity);
            return categoryMapper.fromEntityToResponse(categoryRepository.save(currentCategory));
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

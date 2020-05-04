package com.company.businessprocess.category;

import com.company.businessprocess.entity.CategoryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class CategoryServiceImpl implements CategoryService {
    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Collection<CategoryEntity> getAllCategory() {
        return categoryRepository.findAll();
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

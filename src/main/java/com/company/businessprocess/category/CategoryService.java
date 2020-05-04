package com.company.businessprocess.category;

import com.company.businessprocess.entity.CategoryEntity;

import java.util.Collection;

public interface CategoryService {
    Collection<CategoryEntity> getAllCategory();

    CategoryEntity addCategory(CategoryEntity newEntity);

    CategoryEntity updateCategory(Integer id, CategoryEntity updateEntity);

    void deleteCategory(Integer id);
}

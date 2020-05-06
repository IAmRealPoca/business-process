package com.company.businessprocess.category;

import com.company.businessprocess.dto.request.CategoryRequest;
import com.company.businessprocess.dto.response.CategoryResponse;
import com.company.businessprocess.entity.CategoryEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Collection;

public interface CategoryService {
    Page<CategoryResponse> getAllCategory(Pageable pageable);

    CategoryResponse addCategory(CategoryRequest newCategory);

    CategoryResponse updateCategory(Integer id, CategoryRequest updateEntity);

    void deleteCategory(Integer id);
}

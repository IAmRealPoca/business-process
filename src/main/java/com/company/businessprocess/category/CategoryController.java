package com.company.businessprocess.category;

import com.company.businessprocess.dto.request.CategoryRequest;
import com.company.businessprocess.dto.response.CategoryResponse;
import com.company.businessprocess.entity.CategoryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(path = "/category")
public class CategoryController {

    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/get-all-category")
    public ResponseEntity<Collection<CategoryResponse>> getAllCategories() {
        return ResponseEntity.ok(categoryService.getAllCategory());
    }
    @PostMapping
    public ResponseEntity<CategoryResponse> insertCategory(CategoryRequest newCategory) {
        return ResponseEntity.ok(categoryService.addCategory(newCategory));
    }

    @PutMapping

    public ResponseEntity<CategoryResponse> updateCategory(Integer id, CategoryRequest updateEntity) {
        return ResponseEntity.ok(categoryService.updateCategory(id, updateEntity));
    }

    @DeleteMapping
    public ResponseEntity<String> deleteCategory(Integer id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.ok("Deleted");
    }
}

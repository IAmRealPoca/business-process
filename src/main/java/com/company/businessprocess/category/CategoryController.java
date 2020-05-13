package com.company.businessprocess.category;

import com.company.businessprocess.dto.request.CategoryRequest;
import com.company.businessprocess.dto.response.CategoryResponse;
import com.company.businessprocess.entity.CategoryEntity;
import com.company.businessprocess.utils.PagingAndSortingBuilder;
import com.company.businessprocess.utils.PagingAndSortingOption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(path = "/categories")
public class CategoryController {

    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/get-all")
    public ResponseEntity<Page<CategoryResponse>> getAllCategories(PagingAndSortingOption pagingOption) {
        return ResponseEntity.ok(categoryService.getAllCategory(PagingAndSortingBuilder.buildPageableObj(pagingOption)));
    }

    @PostMapping
    public ResponseEntity<CategoryResponse> insertCategory(
            @RequestBody CategoryRequest newCategory) {
        return ResponseEntity.ok(categoryService.addCategory(newCategory));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryResponse> updateCategory(
            @PathVariable("id") Integer id,
            @RequestBody CategoryRequest updateEntity) {
        return ResponseEntity.ok(categoryService.updateCategory(id, updateEntity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategory(
            @PathVariable("id") Integer id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.ok("Deleted");
    }
}

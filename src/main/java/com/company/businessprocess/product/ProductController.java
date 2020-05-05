package com.company.businessprocess.product;

import com.company.businessprocess.dto.request.ProductRequest;
import com.company.businessprocess.dto.response.ProductResponse;
import com.company.businessprocess.utils.PagingAndSortingBuilder;
import com.company.businessprocess.utils.PagingAndSortingOption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/get-all-products")
    public ResponseEntity<Page<ProductResponse>> getAllProducts(PagingAndSortingOption pagingOption) {
        return ResponseEntity.ok(productService.getAllProduct(PagingAndSortingBuilder.buildPageableObj(pagingOption)));
    }

    @PostMapping
    public ResponseEntity<ProductResponse> insertProduct(ProductRequest newProduct) {
        return ResponseEntity.ok(productService.addProduct(newProduct));
    }

    @PutMapping
    public ResponseEntity<ProductResponse> updateProduct(Integer id, ProductRequest updateRequest) {
        return ResponseEntity.ok(productService.updateProduct(id, updateRequest));
    }

    @DeleteMapping
    public ResponseEntity<String> deleteProduct(Integer id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok("Deleted");
    }
}

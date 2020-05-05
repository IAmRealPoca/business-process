package com.company.businessprocess.product;

import com.company.businessprocess.dto.response.ProductResponse;
import com.company.businessprocess.entity.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/get-all-products")
    public ResponseEntity<Collection<ProductResponse>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProduct());
    }

    @PostMapping
    public ResponseEntity<ProductEntity> insertProduct(ProductEntity newEntity) {
        return ResponseEntity.ok(productService.addProduct(newEntity));
    }

    @PutMapping
    public ResponseEntity<ProductEntity> updateProduct(Integer id, ProductEntity updateEntity) {
        return ResponseEntity.ok(productService.updateProduct(id, updateEntity));
    }

    @DeleteMapping
    public ResponseEntity<String> deleteProduct(Integer id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok("Deleted");
    }
}

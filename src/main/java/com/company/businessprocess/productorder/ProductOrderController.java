package com.company.businessprocess.productorder;

import com.company.businessprocess.dto.response.ProductOrderResponse;
import com.company.businessprocess.entity.ProductorderEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/ProductOrder")
public class ProductOrderController {
    private ProductOrderService productOrderService;

    @Autowired
    public ProductOrderController(ProductOrderService productOrderService) {
        this.productOrderService = productOrderService;
    }

    @GetMapping("/get-all-productorder")
    public ResponseEntity<Collection<ProductOrderResponse>> getAllProductOrder() {
        return ResponseEntity.ok(productOrderService.getAllProductOrder());
    }

    @PostMapping
    public ResponseEntity<ProductorderEntity> insertProductOrder(ProductorderEntity newEntity) {
        return ResponseEntity.ok(productOrderService.addProductOrder(newEntity));
    }

    @PutMapping
    public ResponseEntity<ProductorderEntity> updateProductOrder(Integer id, ProductorderEntity updateEntity) {
        return ResponseEntity.ok(productOrderService.updateProductOrder(id, updateEntity));
    }

    @DeleteMapping
    public ResponseEntity<String> deleteProductOrder(Integer id) {
        productOrderService.deleteProductOrder(id);
        return ResponseEntity.ok("Deleted");
    }
}
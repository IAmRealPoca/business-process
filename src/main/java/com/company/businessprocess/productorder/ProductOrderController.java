package com.company.businessprocess.productorder;

import com.company.businessprocess.dto.request.ProductOrderRequest;
import com.company.businessprocess.dto.response.ProductOrderResponse;
import com.company.businessprocess.entity.ProductorderEntity;
import com.company.businessprocess.utils.PagingAndSortingBuilder;
import com.company.businessprocess.utils.PagingAndSortingOption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
    public ResponseEntity<Page<ProductOrderResponse>> getAllProductOrder(PagingAndSortingOption pagingOption) {
        return ResponseEntity.ok(productOrderService.getAllProductOrder(PagingAndSortingBuilder.buildPageableObj(pagingOption)));
    }

    @PostMapping
    public ResponseEntity<ProductOrderResponse> insertProductOrder(ProductOrderRequest newProductOrder) {
        return ResponseEntity.ok(productOrderService.addProductOrder(newProductOrder));
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
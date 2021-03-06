package com.company.businessprocess.productorder;

import com.company.businessprocess.dto.request.ProductOrderDetailRequest;
import com.company.businessprocess.dto.request.ProductOrderRequest;
import com.company.businessprocess.dto.response.ProductOrderDetailResponse;
import com.company.businessprocess.dto.response.ProductOrderResponse;
import com.company.businessprocess.productorder.productorderdetail.ProductOrderDetailService;
import com.company.businessprocess.utils.PagingAndSortingBuilder;
import com.company.businessprocess.utils.PagingAndSortingOption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;

@RestController
@RequestMapping("/product-orders")
public class ProductOrderController {
    private ProductOrderService productOrderService;

    @Autowired
    public ProductOrderController(ProductOrderService productOrderService) {
        this.productOrderService = productOrderService;
    }

    @GetMapping("/get-all")
    public ResponseEntity<Page<ProductOrderResponse>> getAllProductOrder(PagingAndSortingOption pagingOption) {
        return ResponseEntity.ok(productOrderService.getAllProductOrder(PagingAndSortingBuilder.buildPageableObj(pagingOption)));
    }

    @GetMapping("/search")
    public ResponseEntity<Page<ProductOrderResponse>> searchProductOrder(Date beginDate, Date endDate, PagingAndSortingOption pagingOption) {
        return ResponseEntity.ok(productOrderService.searchProductOrder(beginDate, endDate, PagingAndSortingBuilder.buildPageableObj(pagingOption)));
    }

    @PostMapping
    public ResponseEntity<ProductOrderResponse> insertProductOrder(
            @RequestBody ProductOrderRequest newProductOrder) {
        return ResponseEntity.ok(productOrderService.addProductOrder(newProductOrder));
    }

//    @PutMapping
//    public ResponseEntity<ProductorderEntity> updateProductOrder(Integer id, ProductorderEntity updateEntity) {
//        return ResponseEntity.ok(productOrderService.updateProductOrder(id, updateEntity));
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProductOrder(@PathVariable("id") Integer id) {
        productOrderService.deleteProductOrder(id);
        return ResponseEntity.ok("Deleted");
    }
}
package com.company.businessprocess.productorder.productorderdetail;

import com.company.businessprocess.dto.request.ProductOrderDetailRequest;
import com.company.businessprocess.dto.response.ProductOrderDetailResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/productOrder/{id}/productOrderDetail")
public class ProductOrderDetailController {
    private ProductOrderDetailService productOrderDetailService;

    public ProductOrderDetailController(ProductOrderDetailService productOrderDetailService) {
        this.productOrderDetailService = productOrderDetailService;
    }

    @PostMapping
    public ResponseEntity<ProductOrderDetailResponse> addNewProductOrderDetail(
            @PathVariable("id") Integer productOrderId,
            @RequestBody ProductOrderDetailRequest request) {
        return ResponseEntity.ok(productOrderDetailService.addProductOrderDetail(productOrderId, request));
    }

    @DeleteMapping("/{productOrderDetailId}")
    public ResponseEntity<String> deleteProductOrderDetail(
            @PathVariable("id") Integer productOrderId,
            @PathVariable("productOrderDetailId") Integer productOrderDetailId
    ) {
        productOrderDetailService.deleteProductOrderDetail(productOrderDetailId);
        return ResponseEntity.ok("Deleted");
    }
}

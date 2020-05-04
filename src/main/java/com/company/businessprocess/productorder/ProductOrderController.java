package com.company.businessprocess.productorder;

import com.company.businessprocess.deliverynote.DeliveryNoteService;
import com.company.businessprocess.entity.DeliverynoteEntity;
import com.company.businessprocess.entity.ProductorderEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<Collection<ProductorderEntity>> getAllProductOrder() {
        return ResponseEntity.ok(productOrderService.getAllProductOrder());
    }
}
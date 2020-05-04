package com.company.businessprocess.provider;

import com.company.businessprocess.entity.ProductorderEntity;
import com.company.businessprocess.entity.ProviderEntity;
import com.company.businessprocess.productorder.ProductOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/Provider")
public class ProviderController {
    private ProviderService providerService;

    @Autowired
    public ProviderController(ProviderService providerService) {
        this.providerService = providerService;
    }

    @GetMapping("/get-all-provider")
    public ResponseEntity<Collection<ProviderEntity>> getAllProvider() {
        return ResponseEntity.ok(providerService.getAllProvider());
    }
}
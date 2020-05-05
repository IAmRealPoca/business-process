package com.company.businessprocess.provider;

import com.company.businessprocess.dto.response.ProviderResponse;
import com.company.businessprocess.entity.ProviderEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<Collection<ProviderResponse>> getAllProvider() {
        return ResponseEntity.ok(providerService.getAllProvider());
    }
    @PostMapping
    public ResponseEntity<ProviderEntity> insertProvider(ProviderEntity newEntity) {
        return ResponseEntity.ok(providerService.addProvider(newEntity));
    }

    @PutMapping
    public ResponseEntity<ProviderEntity> updateProvider(Integer id, ProviderEntity updateEntity) {
        return ResponseEntity.ok(providerService.updateProvider(id, updateEntity));
    }

    @DeleteMapping
    public ResponseEntity<String> deleteProvider(Integer id) {
        providerService.deleteProvider(id);
        return ResponseEntity.ok("Deleted");
    }
}
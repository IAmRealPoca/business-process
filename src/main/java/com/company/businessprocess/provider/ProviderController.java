package com.company.businessprocess.provider;

import com.company.businessprocess.dto.request.ProviderRequest;
import com.company.businessprocess.dto.response.ProviderResponse;
import com.company.businessprocess.entity.ProviderEntity;
import com.company.businessprocess.utils.PagingAndSortingBuilder;
import com.company.businessprocess.utils.PagingAndSortingOption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/providers")
public class ProviderController {
    private ProviderService providerService;

    @Autowired
    public ProviderController(ProviderService providerService) {
        this.providerService = providerService;
    }

    @GetMapping("/get-all")
    public ResponseEntity<Page<ProviderResponse>> getAllProvider(PagingAndSortingOption option) {
        return ResponseEntity.ok(providerService.getAllProvider(PagingAndSortingBuilder.buildPageableObj(option)));
    }
    @PostMapping
    public ResponseEntity<ProviderResponse> insertProvider(
            @RequestBody ProviderRequest newProvider) {
        return ResponseEntity.ok(providerService.addProvider(newProvider));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProviderResponse> updateProvider(
            @PathVariable("id") Integer id,
            @RequestBody ProviderRequest updateEntity) {
        return ResponseEntity.ok(providerService.updateProvider(id, updateEntity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProvider(@PathVariable("id") Integer id) {
        providerService.deleteProvider(id);
        return ResponseEntity.ok("Deleted");
    }
}
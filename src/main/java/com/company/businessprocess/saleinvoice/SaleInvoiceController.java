package com.company.businessprocess.saleinvoice;

import com.company.businessprocess.dto.response.SaleInvoiceResponse;
import com.company.businessprocess.entity.SaleinvoiceEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/SaleInvoice")
public class SaleInvoiceController {
    private SaleInvoiceService saleInvoiceService;

    @Autowired
    public SaleInvoiceController(SaleInvoiceService saleInvoiceService) {
        this.saleInvoiceService = saleInvoiceService;
    }

    @GetMapping("/get-all-saleinvoice")
    public ResponseEntity<Collection<SaleInvoiceResponse>> getAllSaleInvoice() {
        return ResponseEntity.ok(saleInvoiceService.getAllSaleInvoice());
    }
    @PostMapping
    public ResponseEntity<SaleinvoiceEntity> insertSaleInvoice(SaleinvoiceEntity newEntity) {
        return ResponseEntity.ok(saleInvoiceService.addSaleInvoice(newEntity));
    }

    @PutMapping
    public ResponseEntity<SaleinvoiceEntity> udpateSaleInvoice(Integer id, SaleinvoiceEntity updateEntity) {
        return ResponseEntity.ok(saleInvoiceService.updateSaleInvoice(id, updateEntity));
    }

    @DeleteMapping
    public ResponseEntity<String> deleteSaleInvoice(Integer id) {
        saleInvoiceService.deleteSaleInvoice(id);
        return ResponseEntity.ok("Deleted");
    }
}

package com.company.businessprocess.saleinvoice;

import com.company.businessprocess.entity.ReceivingnoteEntity;
import com.company.businessprocess.entity.SaleinvoiceEntity;
import com.company.businessprocess.receivingnote.ReceivingNoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<Collection<SaleinvoiceEntity>> getAllSaleInvoice() {
        return ResponseEntity.ok(saleInvoiceService.getAllSaleInvoice());
    }
}

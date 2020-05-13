package com.company.businessprocess.saleinvoice;

import com.company.businessprocess.dto.request.SaleInvoiceRequest;
import com.company.businessprocess.dto.response.SaleInvoiceResponse;
import com.company.businessprocess.mybatis.CategoryMybatis;
import com.company.businessprocess.utils.PagingAndSortingBuilder;
import com.company.businessprocess.utils.PagingAndSortingOption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;

@RestController
@RequestMapping("/SaleInvoice")
public class SaleInvoiceController {
    private SaleInvoiceService saleInvoiceService;
    private CategoryMybatis categoryMybatis;

    @Autowired
    public SaleInvoiceController(SaleInvoiceService saleInvoiceService, CategoryMybatis categoryMybatis) {
        this.saleInvoiceService = saleInvoiceService;
        this.categoryMybatis = categoryMybatis;
    }

    @GetMapping("/test-mybatis")
    public ResponseEntity<?> testMybatis(@RequestParam String name) {
        return ResponseEntity.ok(categoryMybatis.findByName(name));
    }

    @GetMapping("/get-all-saleinvoice")
    public ResponseEntity<Page<SaleInvoiceResponse>> getAllSaleInvoice(PagingAndSortingOption pagingOption) {
        return ResponseEntity.ok(saleInvoiceService.getAllSaleInvoice(PagingAndSortingBuilder.buildPageableObj(pagingOption)));
    }

    @GetMapping("/report-sale-invoice")
    public ResponseEntity<Page<SaleInvoiceResponse>> reportSaleInvoice(
            String customerName,
            String staffName,
            Date beginDate,
            Date endDate,
            PagingAndSortingOption pagingOption) {
        return ResponseEntity.ok(saleInvoiceService.reportSaleInvoiceByCustomerAndStaffInDate(
                customerName,
                staffName,
                beginDate,
                endDate,
                PagingAndSortingBuilder.buildPageableObj(pagingOption)));
    }

    @GetMapping("/search")
    public ResponseEntity<Page<SaleInvoiceResponse>> searchSaleInvoice(Date beginDate, Date endDate, PagingAndSortingOption pagingOption) {
        return ResponseEntity.ok(saleInvoiceService.searchSaleInvoice(beginDate, endDate, PagingAndSortingBuilder.buildPageableObj(pagingOption)));
    }

    @PostMapping
    public ResponseEntity<SaleInvoiceResponse> insertSaleInvoice(SaleInvoiceRequest newSaleInvoice) {
        return ResponseEntity.ok(saleInvoiceService.addSaleInvoice(newSaleInvoice));
    }

//    @PutMapping
//    public ResponseEntity<SaleinvoiceEntity> udpateSaleInvoice(Integer id, SaleinvoiceEntity updateEntity) {
//        return ResponseEntity.ok(saleInvoiceService.updateSaleInvoice(id, updateEntity));
//    }

    @DeleteMapping
    public ResponseEntity<String> deleteSaleInvoice(Integer id) {
        saleInvoiceService.deleteSaleInvoice(id);
        return ResponseEntity.ok("Deleted");
    }
}

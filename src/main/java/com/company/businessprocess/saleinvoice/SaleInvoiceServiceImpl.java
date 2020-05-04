package com.company.businessprocess.saleinvoice;

import com.company.businessprocess.entity.SaleinvoiceEntity;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class SaleInvoiceServiceImpl implements SaleInvoiceService {

    private SaleInvoiceRepository saleInvoiceRepository;

    public SaleInvoiceServiceImpl(SaleInvoiceRepository saleInvoiceRepository) {
        this.saleInvoiceRepository = saleInvoiceRepository;
    }

    @Override
    public Collection<SaleinvoiceEntity> getAllSaleInvoice() {
        return saleInvoiceRepository.findAll();
    }

    @Override
    public SaleinvoiceEntity addSaleInvoice(SaleinvoiceEntity newEntity) {
        return saleInvoiceRepository.save(newEntity);
    }

    @Override
    public SaleinvoiceEntity updateSaleInvoice(Integer id, SaleinvoiceEntity updateEntity) {
        return saleInvoiceRepository.save(updateEntity);
    }

    @Override
    public void deleteSaleInvoice(Integer id) {
        saleInvoiceRepository.deleteById(id);
    }

}

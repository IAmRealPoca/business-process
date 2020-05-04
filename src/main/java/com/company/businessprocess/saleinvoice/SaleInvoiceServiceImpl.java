package com.company.businessprocess.saleinvoice;

import com.company.businessprocess.dto.SaleInvoiceResponse;
import com.company.businessprocess.entity.SaleinvoiceEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class SaleInvoiceServiceImpl implements SaleInvoiceService {

    private SaleInvoiceRepository saleInvoiceRepository;
    private ModelMapper mapper;

    public SaleInvoiceServiceImpl(SaleInvoiceRepository saleInvoiceRepository, ModelMapper mapper) {
        this.saleInvoiceRepository = saleInvoiceRepository;
        this.mapper = mapper;
    }

    @Override
    public Collection<SaleInvoiceResponse> getAllSaleInvoice() {
        Collection<SaleInvoiceResponse> saleInvoiceResponses =
                saleInvoiceRepository.findAll().stream()
                        .map(saleinvoiceEntity -> mapper.map(saleinvoiceEntity, SaleInvoiceResponse.class))
                        .collect(Collectors.toList());
        return saleInvoiceResponses;
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

package com.company.businessprocess.saleinvoice;

import com.company.businessprocess.customer.CustomerRepository;
import com.company.businessprocess.deliverynote.DeliveryNoteRepository;
import com.company.businessprocess.dto.request.SaleInvoiceRequest;
import com.company.businessprocess.dto.response.SaleInvoiceResponse;
import com.company.businessprocess.entity.CustomerEntity;
import com.company.businessprocess.entity.DeliverynoteEntity;
import com.company.businessprocess.entity.ProductEntity;
import com.company.businessprocess.entity.SaleinvoiceEntity;
import com.company.businessprocess.entity.StaffEntity;
import com.company.businessprocess.product.ProductRepository;
import com.company.businessprocess.staff.StaffRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SaleInvoiceServiceImpl implements SaleInvoiceService {

    private SaleInvoiceRepository saleInvoiceRepository;
    private ProductRepository productRepository;
    private CustomerRepository customerRepository;
    private StaffRepository staffRepository;
    private ModelMapper mapper;

    private DeliveryNoteRepository deliveryNoteRepository;

    public SaleInvoiceServiceImpl(SaleInvoiceRepository saleInvoiceRepository, ProductRepository productRepository, CustomerRepository customerRepository, StaffRepository staffRepository, ModelMapper mapper, DeliveryNoteRepository deliveryNoteRepository) {
        this.saleInvoiceRepository = saleInvoiceRepository;
        this.productRepository = productRepository;
        this.customerRepository = customerRepository;
        this.staffRepository = staffRepository;
        this.mapper = mapper;
        this.deliveryNoteRepository = deliveryNoteRepository;
    }

    @Override
    public Page<SaleInvoiceResponse> getAllSaleInvoice(Pageable pageable) {
        Page<SaleinvoiceEntity> saleinvoiceEntities = saleInvoiceRepository.findAll(pageable);
        Page<SaleInvoiceResponse> saleInvoiceResponses = saleinvoiceEntities.map(saleinvoiceEntity -> mapper.map(saleinvoiceEntity, SaleInvoiceResponse.class));
        return saleInvoiceResponses;
    }

    @Override
    public SaleInvoiceResponse addSaleInvoice(SaleInvoiceRequest newSaleInvoice) {
        SaleinvoiceEntity newEntity = mapper.map(newSaleInvoice, SaleinvoiceEntity.class);
        ProductEntity product = productRepository.getOne(newSaleInvoice.getProductId());
        newEntity.setProductByProductId(product);
        StaffEntity staff = staffRepository.getOne(newSaleInvoice.getStaffId());
        newEntity.setStaffByStaffId(staff);
        CustomerEntity customer = customerRepository.getOne(newSaleInvoice.getCustomerId());
        newEntity.setCustomerByCustomerId(customer);

        //calculate total price
        ProductEntity productEntity = productRepository.getOne(newSaleInvoice.getProductId());
        newEntity.setTotalValue(productEntity.getPrice() * newSaleInvoice.getQuantity());

        DeliverynoteEntity deliverynoteEntity = mapper.map(newEntity, DeliverynoteEntity.class);
        deliveryNoteRepository.save(deliverynoteEntity);

        return mapper.map(saleInvoiceRepository.save(newEntity), SaleInvoiceResponse.class);
    }

    @Override
    public SaleinvoiceEntity updateSaleInvoice(Integer id, SaleinvoiceEntity updateEntity) {

        return saleInvoiceRepository.save(updateEntity);
    }

    @Override
    public void deleteSaleInvoice(Integer id) {
        Optional<SaleinvoiceEntity> optionalSaleinvoiceEntity = saleInvoiceRepository.findById(id);
        if (optionalSaleinvoiceEntity.isPresent()) {
            saleInvoiceRepository.deleteById(id);
        }
    }

}

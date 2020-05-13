package com.company.businessprocess.saleinvoice;

import com.company.businessprocess.customer.CustomerRepository;
import com.company.businessprocess.deliverynote.DeliveryNoteRepository;
import com.company.businessprocess.deliverynote.deliverynotedetail.DeliveryNoteDetailRepository;
import com.company.businessprocess.dto.request.SaleInvoiceRequest;
import com.company.businessprocess.dto.response.SaleInvoiceResponse;
import com.company.businessprocess.entity.CustomerEntity;
import com.company.businessprocess.entity.DeliverynoteEntity;
import com.company.businessprocess.entity.DeliverynotedetailEntity;
import com.company.businessprocess.entity.ProductEntity;
import com.company.businessprocess.entity.SaleinvoiceEntity;
import com.company.businessprocess.entity.StaffEntity;
import com.company.businessprocess.mapper.DeliveryNoteDetailMapper;
import com.company.businessprocess.mapper.DeliveryNoteMapper;
import com.company.businessprocess.mapper.SaleInvoiceMapper;
import com.company.businessprocess.product.ProductRepository;
import com.company.businessprocess.staff.StaffRepository;
import com.company.businessprocess.utils.BusinessProcessStringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.sql.Date;
import java.util.Optional;

@Service
public class SaleInvoiceServiceImpl implements SaleInvoiceService {

    private SaleInvoiceRepository saleInvoiceRepository;
    private ProductRepository productRepository;
    private CustomerRepository customerRepository;
    private StaffRepository staffRepository;
    private SaleInvoiceMapper saleInvoiceMapper;
    private DeliveryNoteMapper deliveryNoteMapper;
    private DeliveryNoteDetailMapper deliveryNoteDetailMapper;

    private DeliveryNoteRepository deliveryNoteRepository;
    private DeliveryNoteDetailRepository deliveryNoteDetailRepository;

    public SaleInvoiceServiceImpl(SaleInvoiceRepository saleInvoiceRepository, ProductRepository productRepository, CustomerRepository customerRepository, StaffRepository staffRepository, SaleInvoiceMapper saleInvoiceMapper, DeliveryNoteMapper deliveryNoteMapper, DeliveryNoteDetailMapper deliveryNoteDetailMapper, DeliveryNoteRepository deliveryNoteRepository, DeliveryNoteDetailRepository deliveryNoteDetailRepository) {
        this.saleInvoiceRepository = saleInvoiceRepository;
        this.productRepository = productRepository;
        this.customerRepository = customerRepository;
        this.staffRepository = staffRepository;
        this.saleInvoiceMapper = saleInvoiceMapper;
        this.deliveryNoteMapper = deliveryNoteMapper;
        this.deliveryNoteDetailMapper = deliveryNoteDetailMapper;
        this.deliveryNoteRepository = deliveryNoteRepository;
        this.deliveryNoteDetailRepository = deliveryNoteDetailRepository;
    }

    @Override
    public Page<SaleInvoiceResponse> getAllSaleInvoice(Pageable pageable) {
        Page<SaleinvoiceEntity> saleinvoiceEntities = saleInvoiceRepository.findAll(pageable);
        Page<SaleInvoiceResponse> saleInvoiceResponses = saleinvoiceEntities
                .map(saleinvoiceEntity -> saleInvoiceMapper.fromEntityToResponse(saleinvoiceEntity));
        return saleInvoiceResponses;
    }

    @Override
    public Page<SaleInvoiceResponse> searchSaleInvoice(Date beginDate, Date endDate, Pageable pageable) {
        Page<SaleinvoiceEntity> saleinvoiceEntities;
        if (!ObjectUtils.isEmpty(beginDate)) {
            saleinvoiceEntities = saleInvoiceRepository.findAllBySaleDateAfter(beginDate, pageable);
        } else if (!ObjectUtils.isEmpty(endDate)) {
            saleinvoiceEntities = saleInvoiceRepository.findAllBySaleDateBefore(endDate, pageable);
        } else {
            saleinvoiceEntities = saleInvoiceRepository.findAllBySaleDateBetween(beginDate, endDate, pageable);
        }
        Page<SaleInvoiceResponse> saleInvoiceResponses =
                saleinvoiceEntities.map(saleinvoiceEntity ->
                        saleInvoiceMapper.fromEntityToResponse(saleinvoiceEntity));
        return saleInvoiceResponses;
    }

    @Override
    public Page<SaleInvoiceResponse> reportSaleInvoiceByCustomerAndStaffInDate(String customerName, String staffName, Date beginDate, Date endDate, Pageable pageable) {
        if (BusinessProcessStringUtils.isBlankAndEmpty(customerName)) {
            customerName = "";
        }
        if (BusinessProcessStringUtils.isBlankAndEmpty(staffName)) {
            staffName = "";
        }
        if (ObjectUtils.isEmpty(beginDate)) {
            beginDate = new Date(0);
        }
        if (ObjectUtils.isEmpty(endDate)) {
            endDate = new Date(System.currentTimeMillis());
        }
        Page<SaleinvoiceEntity> saleinvoiceEntities = saleInvoiceRepository.customFindAllByCustomerAndStaffAndDate(customerName, staffName,
                beginDate, endDate, pageable);
        Page<SaleInvoiceResponse> saleInvoiceResponses = saleinvoiceEntities.map(saleinvoiceEntity ->
                saleInvoiceMapper.fromEntityToResponse(saleinvoiceEntity));
        return saleInvoiceResponses;
    }

    @Override
    public SaleInvoiceResponse addSaleInvoice(SaleInvoiceRequest newSaleInvoice) {
        SaleinvoiceEntity newEntity = saleInvoiceMapper.fromRequestToEntity(newSaleInvoice);
        ProductEntity product = productRepository.getOne(newSaleInvoice.getProductId());
        newEntity.setProductByProductId(product);
        StaffEntity staff = staffRepository.getOne(newSaleInvoice.getStaffId());
        newEntity.setStaffByStaffId(staff);
        CustomerEntity customer = customerRepository.getOne(newSaleInvoice.getCustomerId());
        newEntity.setCustomerByCustomerId(customer);

        //calculate total price
        ProductEntity productEntity = productRepository.getOne(newSaleInvoice.getProductId());
        newEntity.setPrice(productEntity.getPrice());
        newEntity.setTotalValue(productEntity.getPrice() * newSaleInvoice.getQuantity());

        DeliverynoteEntity deliverynoteEntity = deliveryNoteMapper
                .fromSaleInvoiceEntToDeliveryNoteEnt(newEntity);
        DeliverynoteEntity savedDeliverynoteEntity = deliveryNoteRepository.save(deliverynoteEntity);
        DeliverynotedetailEntity deliverynotedetailEntity =
                deliveryNoteDetailMapper.fromSaleInvoiceEntToDeliveryNoteEnt(newEntity);
        deliverynotedetailEntity.setDeliverynoteByDeliveryId(savedDeliverynoteEntity);
        deliveryNoteDetailRepository.save(deliverynotedetailEntity);
        return saleInvoiceMapper.fromEntityToResponse(saleInvoiceRepository.save(newEntity));
    }

    @Override
    public SaleInvoiceResponse updateSaleInvoicePrice(Integer id, Double price) {
        Optional<SaleinvoiceEntity> optionalSaleinvoiceEntity = saleInvoiceRepository.findById(id);
        if (optionalSaleinvoiceEntity.isPresent()) {
            SaleinvoiceEntity saleinvoiceEntity = optionalSaleinvoiceEntity.get();
            saleinvoiceEntity.setPrice(price);
            return saleInvoiceMapper.fromEntityToResponse(saleInvoiceRepository.save(saleinvoiceEntity));
        }
        return null;
    }

    @Override
    public void deleteSaleInvoice(Integer id) {
        Optional<SaleinvoiceEntity> optionalSaleinvoiceEntity = saleInvoiceRepository.findById(id);
        if (optionalSaleinvoiceEntity.isPresent()) {
            saleInvoiceRepository.deleteById(id);
        }
    }

}

package com.company.businessprocess.deliverynote;


import com.company.businessprocess.customer.CustomerRepository;
import com.company.businessprocess.dto.request.DeliveryNoteRequest;
import com.company.businessprocess.dto.response.DeliveryNoteResponse;
import com.company.businessprocess.dto.response.ProductOrderResponse;
import com.company.businessprocess.entity.CustomerEntity;
import com.company.businessprocess.entity.DeliverynoteEntity;
import com.company.businessprocess.entity.ProductEntity;
import com.company.businessprocess.entity.StaffEntity;
import com.company.businessprocess.product.ProductRepository;
import com.company.businessprocess.staff.StaffRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.sql.Date;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DeliveryNoteServiceImpl implements DeliveryNoteService {
    private DeliveryNoteRepository deliveryNoteRepository;
    private ProductRepository productRepository;
    private CustomerRepository customerRepository;
    private StaffRepository staffRepository;
    private ModelMapper mapper;

    public DeliveryNoteServiceImpl(DeliveryNoteRepository deliveryNoteRepository, ProductRepository productRepository, CustomerRepository customerRepository, StaffRepository staffRepository, ModelMapper mapper) {
        this.deliveryNoteRepository = deliveryNoteRepository;
        this.productRepository = productRepository;
        this.customerRepository = customerRepository;
        this.staffRepository = staffRepository;
        this.mapper = mapper;
    }

    @Override
    public Page<DeliveryNoteResponse> getAllDeliveryNote(Pageable pageable) {
        Page<DeliverynoteEntity> deliverynoteEntities = deliveryNoteRepository.findAll(pageable);
        Page<DeliveryNoteResponse> deliveryNoteResponses =
                        deliverynoteEntities.map(deliverynoteEntity -> mapper.map(deliverynoteEntity, DeliveryNoteResponse.class));
        return deliveryNoteResponses;
    }

    @Override
    public Page<DeliveryNoteResponse> searchDeliveryNote(Date beginDate, Date endDate, Pageable pageable) {
        Page<DeliverynoteEntity> deliverynoteEntities;
        if (!ObjectUtils.isEmpty(beginDate)) {
            deliverynoteEntities = deliveryNoteRepository.findAllBySaleDateAfter(beginDate, pageable);
        } else if (!ObjectUtils.isEmpty(endDate)) {
            deliverynoteEntities = deliveryNoteRepository.findAllBySaleDateBefore(endDate, pageable);
        } else {
            deliverynoteEntities = deliveryNoteRepository.findAllBySaleDateBetween(beginDate, endDate, pageable);
        }
        Page<DeliveryNoteResponse> deliveryNoteResponses =
                deliverynoteEntities.map(deliverynoteEntity -> mapper.map(deliverynoteEntity, DeliveryNoteResponse.class));
        return deliveryNoteResponses;
    }

    @Override
    public DeliveryNoteResponse addDeliveryNote(DeliveryNoteRequest newDeliveryNote) {
        DeliverynoteEntity newEntity = mapper.map(newDeliveryNote, DeliverynoteEntity.class);
        ProductEntity product = productRepository.getOne(newDeliveryNote.getProductId());
        StaffEntity staff = staffRepository.getOne(newDeliveryNote.getStaffId());
        newEntity.setStaffByStaffId(staff);
        CustomerEntity customer = customerRepository.getOne(newDeliveryNote.getCustomerId());
        newEntity.setCustomerByCustomerId(customer);
        return mapper.map(deliveryNoteRepository.save(newEntity), DeliveryNoteResponse.class);
    }

    @Override
    public DeliverynoteEntity updateDeliveryNote(Integer id, DeliverynoteEntity updateEntity) {
        return deliveryNoteRepository.save(updateEntity);
    }

    @Override
    public void deleteDeliveryNote(Integer id) {
        Optional<DeliverynoteEntity> optionalDeliverynoteEntity = deliveryNoteRepository.findById(id);
        if (optionalDeliverynoteEntity.isPresent()) {
            deliveryNoteRepository.deleteById(id);
        }
    }
}

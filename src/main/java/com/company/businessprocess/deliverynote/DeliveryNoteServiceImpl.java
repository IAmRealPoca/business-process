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
import org.springframework.stereotype.Service;

import java.util.Collection;
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
    public Collection<DeliveryNoteResponse> getAllDeliveryNote() {
        Collection<DeliveryNoteResponse> deliveryNoteResponses =
                deliveryNoteRepository.findAll().stream()
                        .map(deliverynoteEntity -> mapper.map(deliverynoteEntity, DeliveryNoteResponse.class))
                        .collect(Collectors.toList());
        return deliveryNoteResponses;
    }

    @Override
    public DeliveryNoteResponse addDeliveryNote(DeliveryNoteRequest newDeliveryNote) {
        DeliverynoteEntity newEntity = mapper.map(newDeliveryNote, DeliverynoteEntity.class);
        ProductEntity product = productRepository.getOne(newDeliveryNote.getProductId());
        newEntity.setProductByProductId(product);
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
        deliveryNoteRepository.deleteById(id);
    }
}

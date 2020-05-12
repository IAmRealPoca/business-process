package com.company.businessprocess.deliverynote;


import com.company.businessprocess.customer.CustomerRepository;
import com.company.businessprocess.dto.request.DeliveryNoteRequest;
import com.company.businessprocess.dto.response.DeliveryNoteResponse;
import com.company.businessprocess.entity.CustomerEntity;
import com.company.businessprocess.entity.DeliverynoteEntity;
import com.company.businessprocess.entity.StaffEntity;
import com.company.businessprocess.mapper.DeliveryNoteMapper;
import com.company.businessprocess.product.ProductRepository;
import com.company.businessprocess.staff.StaffRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.sql.Date;
import java.util.Optional;

@Service
public class DeliveryNoteServiceImpl implements DeliveryNoteService {
    private DeliveryNoteRepository deliveryNoteRepository;
    private CustomerRepository customerRepository;
    private StaffRepository staffRepository;
    private DeliveryNoteMapper deliveryNoteMapper;

    public DeliveryNoteServiceImpl(DeliveryNoteRepository deliveryNoteRepository, CustomerRepository customerRepository, StaffRepository staffRepository, DeliveryNoteMapper deliveryNoteMapper) {
        this.deliveryNoteRepository = deliveryNoteRepository;
        this.customerRepository = customerRepository;
        this.staffRepository = staffRepository;
        this.deliveryNoteMapper = deliveryNoteMapper;
    }

    @Override
    public Page<DeliveryNoteResponse> getAllDeliveryNote(Pageable pageable) {
        Page<DeliverynoteEntity> deliverynoteEntities = deliveryNoteRepository.findAll(pageable);
        Page<DeliveryNoteResponse> deliveryNoteResponses =
                deliverynoteEntities.map(deliverynoteEntity -> deliveryNoteMapper.fromEntityToResponse(deliverynoteEntity));
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
                deliverynoteEntities.map(deliverynoteEntity -> deliveryNoteMapper.fromEntityToResponse(deliverynoteEntity));
        return deliveryNoteResponses;
    }

    @Override
    public DeliveryNoteResponse addDeliveryNote(DeliveryNoteRequest newDeliveryNote) {
        DeliverynoteEntity newEntity = deliveryNoteMapper.fromRequestToEntity(newDeliveryNote);
        StaffEntity staff = staffRepository.getOne(newDeliveryNote.getStaffId());
        newEntity.setStaffByStaffId(staff);
        CustomerEntity customer = customerRepository.getOne(newDeliveryNote.getCustomerId());
        newEntity.setCustomerByCustomerId(customer);
        return deliveryNoteMapper.fromEntityToResponse(deliveryNoteRepository.save(newEntity));
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

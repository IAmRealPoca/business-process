package com.company.businessprocess.productorder;

import com.company.businessprocess.dto.request.ProductOrderRequest;
import com.company.businessprocess.dto.response.ProductOrderResponse;
import com.company.businessprocess.entity.ProductorderEntity;
import com.company.businessprocess.entity.ProviderEntity;
import com.company.businessprocess.entity.ReceivingnoteEntity;
import com.company.businessprocess.entity.StaffEntity;
import com.company.businessprocess.mapper.ProductOrderMapper;
import com.company.businessprocess.mapper.ReceivingNoteMapper;
import com.company.businessprocess.provider.ProviderRepository;
import com.company.businessprocess.receivingnote.ReceivingNoteRepository;
import com.company.businessprocess.staff.StaffRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.transaction.Transactional;
import java.sql.Date;
import java.util.Optional;

@Service
@Transactional
public class ProductOrderServiceImpl implements ProductOrderService {
    private ProductOrderRepository productOrderRepository;
    private StaffRepository staffRepository;
    private ProviderRepository providerRepository;

    private ReceivingNoteRepository receivingNoteRepository;
    private ProductOrderMapper productOrderMapper;
    private ReceivingNoteMapper receivingNoteMapper;

    public ProductOrderServiceImpl(ProductOrderRepository productOrderRepository, StaffRepository staffRepository, ProviderRepository providerRepository, ReceivingNoteRepository receivingNoteRepository, ProductOrderMapper productOrderMapper, ReceivingNoteMapper receivingNoteMapper) {
        this.productOrderRepository = productOrderRepository;
        this.staffRepository = staffRepository;
        this.providerRepository = providerRepository;
        this.receivingNoteRepository = receivingNoteRepository;
        this.productOrderMapper = productOrderMapper;
        this.receivingNoteMapper = receivingNoteMapper;
    }

    @Override
    public Page<ProductOrderResponse> getAllProductOrder(Pageable pageable) {
        Page<ProductorderEntity> productorderEntities = productOrderRepository.findAll(pageable);
        Page<ProductOrderResponse> productOrderResponses = productorderEntities.map(productorderEntity -> productOrderMapper.fromEntityToResponse(productorderEntity));
        return productOrderResponses;
    }

    @Override
    public Page<ProductOrderResponse> searchProductOrder(Date beginDate, Date endDate, Pageable pageable) {
        Page<ProductorderEntity> productorderEntities;
        if (!ObjectUtils.isEmpty(beginDate)) {
            productorderEntities = productOrderRepository.findAllByOrderDateAfter(beginDate, pageable);
        } else if (!ObjectUtils.isEmpty(endDate)) {
            productorderEntities = productOrderRepository.findAllByOrderDateBefore(endDate, pageable);
        } else {
            productorderEntities = productOrderRepository.findAllByOrderDateBetween(beginDate, endDate, pageable);
        }
        Page<ProductOrderResponse> productOrderResponses =
                productorderEntities.map(item -> productOrderMapper.fromEntityToResponse(item));
        return productOrderResponses;
    }

    @Override
    public ProductOrderResponse addProductOrder(ProductOrderRequest newProductOrder) {
        ProductorderEntity newEntity = productOrderMapper.fromRequestToEntity(newProductOrder);
        StaffEntity staff = staffRepository.getOne(newProductOrder.getStaffId());
        newEntity.setStaffByStaffId(staff);
        ProviderEntity providerEntity = providerRepository.getOne(newProductOrder.getProviderId());
        newEntity.setProviderByProviderId(providerEntity);
        ProductorderEntity savedEntity = productOrderRepository.save(newEntity);
        ReceivingnoteEntity receivingnoteEntity = receivingNoteMapper.fromProductEntToReceivingNoteEnt(savedEntity);
//        receivingnoteEntity.setProductOrderId(savedEntity.getOrderId());
        receivingnoteEntity.setReceiveDate(newEntity.getOrderDate());
        receivingnoteEntity.setProviderByProviderId(providerEntity);
        receivingNoteRepository.save(receivingnoteEntity);

        return productOrderMapper.fromEntityToResponse(savedEntity);
    }

    @Override
    public ProductorderEntity updateProductOrder(Integer id, ProductorderEntity updateEntity) {
        return productOrderRepository.save(updateEntity);
    }


    @Override
    public void deleteProductOrder(Integer id) {
        Optional<ProductorderEntity> optionalProductorderEntity = productOrderRepository.findById(id);
        if (optionalProductorderEntity.isPresent()) {
            productOrderRepository.deleteById(id);
        }
    }
}

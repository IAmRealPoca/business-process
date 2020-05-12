package com.company.businessprocess.productorder;

import com.company.businessprocess.dto.request.ProductOrderRequest;
import com.company.businessprocess.dto.response.ProductOrderResponse;
import com.company.businessprocess.entity.ProductorderEntity;
import com.company.businessprocess.entity.ReceivingnoteEntity;
import com.company.businessprocess.entity.StaffEntity;
import com.company.businessprocess.mapper.ProductOrderMapper;
import com.company.businessprocess.mapper.ReceivingNoteMapper;
import com.company.businessprocess.product.ProductRepository;
import com.company.businessprocess.receivingnote.ReceivingNoteRepository;
import com.company.businessprocess.staff.StaffRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.sql.Date;
import java.util.Optional;

@Service
public class ProductOrderServiceImpl implements ProductOrderService {
    private ProductOrderRepository productOrderRepository;
    private ProductRepository productRepository;
    private StaffRepository staffRepository;

    private ReceivingNoteRepository receivingNoteRepository;
    private ProductOrderMapper productOrderMapper;
    private ReceivingNoteMapper receivingNoteMapper;

    public ProductOrderServiceImpl(ProductOrderRepository productOrderRepository, ProductRepository productRepository, StaffRepository staffRepository, ReceivingNoteRepository receivingNoteRepository, ProductOrderMapper productOrderMapper, ReceivingNoteMapper receivingNoteMapper) {
        this.productOrderRepository = productOrderRepository;
        this.productRepository = productRepository;
        this.staffRepository = staffRepository;
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

        ReceivingnoteEntity receivingnoteEntity = receivingNoteMapper.fromProductEntToReceivingNoteEnt(newEntity);
        receivingnoteEntity.setReceiveDate(newEntity.getOrderDate());
        receivingNoteRepository.save(receivingnoteEntity);

        return productOrderMapper.fromEntityToResponse(productOrderRepository.save(newEntity));
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

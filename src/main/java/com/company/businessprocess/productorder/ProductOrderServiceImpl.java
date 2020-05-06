package com.company.businessprocess.productorder;

import com.company.businessprocess.dto.request.ProductOrderRequest;
import com.company.businessprocess.dto.response.ProductOrderResponse;
import com.company.businessprocess.entity.ProductEntity;
import com.company.businessprocess.entity.ProductorderEntity;
import com.company.businessprocess.entity.ReceivingnoteEntity;
import com.company.businessprocess.entity.StaffEntity;
import com.company.businessprocess.product.ProductRepository;
import com.company.businessprocess.receivingnote.ReceivingNoteRepository;
import com.company.businessprocess.staff.StaffRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductOrderServiceImpl implements ProductOrderService {
    private ProductOrderRepository productOrderRepository;
    private ProductRepository productRepository;
    private StaffRepository staffRepository;

    private ReceivingNoteRepository receivingNoteRepository;
    private ModelMapper mapper;


    public ProductOrderServiceImpl(ProductOrderRepository productOrderRepository, ProductRepository productRepository, StaffRepository staffRepository, ReceivingNoteRepository receivingNoteRepository, ModelMapper mapper) {
        this.productOrderRepository = productOrderRepository;
        this.productRepository = productRepository;
        this.staffRepository = staffRepository;
        this.receivingNoteRepository = receivingNoteRepository;
        this.mapper = mapper;
    }

    @Override
    public Page<ProductOrderResponse> getAllProductOrder(Pageable pageable) {
        Page<ProductorderEntity> productorderEntities = productOrderRepository.findAll(pageable);
        Page<ProductOrderResponse> productOrderResponses = productorderEntities.map(productorderEntity -> mapper.map(productorderEntity, ProductOrderResponse.class));
        return productOrderResponses;
    }

    @Override
    public ProductOrderResponse addProductOrder(ProductOrderRequest newProductOrder) {
        ProductorderEntity newEntity = mapper.map(newProductOrder, ProductorderEntity.class);
        ProductEntity product = productRepository.getOne(newProductOrder.getProductId());
        newEntity.setProductByProductId(product);
        StaffEntity staff = staffRepository.getOne(newProductOrder.getStaffId());
        newEntity.setStaffByStaffId(staff);

        ReceivingnoteEntity receivingnoteEntity = mapper.map(newEntity, ReceivingnoteEntity.class);
        receivingnoteEntity.setReceiveDate(newEntity.getOrderDate());
        receivingNoteRepository.save(receivingnoteEntity);

        return mapper.map(productOrderRepository.save(newEntity), ProductOrderResponse.class);
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

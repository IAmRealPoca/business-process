package com.company.businessprocess.productorder.productorderdetail;

import com.company.businessprocess.dto.request.ProductOrderDetailRequest;
import com.company.businessprocess.dto.response.ProductOrderDetailResponse;
import com.company.businessprocess.entity.ProductEntity;
import com.company.businessprocess.entity.ProductorderEntity;
import com.company.businessprocess.entity.ProductorderdetailEntity;
import com.company.businessprocess.entity.ReceivingnoteEntity;
import com.company.businessprocess.entity.ReceivingnotedetailEntity;
import com.company.businessprocess.mapper.ProductOrderDetailMapper;
import com.company.businessprocess.mapper.ReceivingNoteDetailMapper;
import com.company.businessprocess.product.ProductRepository;
import com.company.businessprocess.productorder.ProductOrderRepository;
import com.company.businessprocess.receivingnote.ReceivingNoteRepository;
import com.company.businessprocess.receivingnote.receivingnotedetail.ReceivingNoteDetailRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductOrderDetailServiceImpl implements ProductOrderDetailService{
    private ProductOrderDetailRepository productOrderDetailRepository;
    private ProductRepository productRepository;
    private ProductOrderRepository productOrderRepository;
    private ReceivingNoteRepository receivingNoteRepository;
    private ReceivingNoteDetailRepository receivingNoteDetailRepository;
    private ProductOrderDetailMapper productOrderDetailMapper;
    private ReceivingNoteDetailMapper receivingNoteDetailMapper;

    public ProductOrderDetailServiceImpl(ProductOrderDetailRepository productOrderDetailRepository, ProductRepository productRepository, ProductOrderRepository productOrderRepository, ReceivingNoteRepository receivingNoteRepository, ReceivingNoteDetailRepository receivingNoteDetailRepository, ProductOrderDetailMapper productOrderDetailMapper, ReceivingNoteDetailMapper receivingNoteDetailMapper) {
        this.productOrderDetailRepository = productOrderDetailRepository;
        this.productRepository = productRepository;
        this.productOrderRepository = productOrderRepository;
        this.receivingNoteRepository = receivingNoteRepository;
        this.receivingNoteDetailRepository = receivingNoteDetailRepository;
        this.productOrderDetailMapper = productOrderDetailMapper;
        this.receivingNoteDetailMapper = receivingNoteDetailMapper;
    }

    @Override
    public Page<ProductOrderDetailResponse> getAllProductOrderDetail(Pageable pageable) {
        Page<ProductorderdetailEntity> productorderEntities = productOrderDetailRepository.findAll(pageable);
        Page<ProductOrderDetailResponse> productOrderResponses = productorderEntities
                .map(productorderEntity -> productOrderDetailMapper.fromEntityToResponse(productorderEntity));
        return productOrderResponses;
    }

    @Override
    public ProductOrderDetailResponse addProductOrderDetail(Integer productOrderId, ProductOrderDetailRequest request) {
        ProductorderdetailEntity productorderdetailEntity = new ProductorderdetailEntity();
        productorderdetailEntity.setPrice(request.getPrice());
        productorderdetailEntity.setQuantity(request.getQuantity());

        ProductEntity productEntity = productRepository.getOne(request.getProductId());
        productorderdetailEntity.setProductByProductId(productEntity);

        ProductorderEntity productorderEntity = productOrderRepository.getOne(productOrderId);
        productorderdetailEntity.setProductorderByOrderId(productorderEntity);

        ReceivingnotedetailEntity receivingnotedetailEntity =
                receivingNoteDetailMapper.fromProdOrderDetailEntToReceivingNoteDetailEnt(productorderdetailEntity);
        ReceivingnoteEntity receivingnoteEntity = receivingNoteRepository.findByProductOrderId(productOrderId);
        receivingnotedetailEntity.setReceivingnoteByReceiveId(receivingnoteEntity);
        receivingnotedetailEntity.setProductByProductid(productEntity);
        receivingNoteDetailRepository.save(receivingnotedetailEntity);
        return productOrderDetailMapper.fromEntityToResponse(productOrderDetailRepository.save(productorderdetailEntity));
    }

    @Override
    public void deleteProductOrderDetail(Integer id) {
        Optional<ProductorderdetailEntity> currentEntity = productOrderDetailRepository.findById(id);
        if (currentEntity.isPresent()) {
            productOrderDetailRepository.deleteById(id);
        }
    }
}

//package com.company.businessprocess.deliverynote.deliverynotedetail;
//
//import com.company.businessprocess.deliverynote.DeliveryNoteRepository;
//import com.company.businessprocess.dto.request.ProductOrderDetailRequest;
//import com.company.businessprocess.dto.response.DeliveryNoteResponse;
//import com.company.businessprocess.dto.response.ProductOrderDetailResponse;
//import com.company.businessprocess.entity.DeliverynoteEntity;
//import com.company.businessprocess.entity.ProductEntity;
//import com.company.businessprocess.entity.ProductorderEntity;
//import com.company.businessprocess.entity.ProductorderdetailEntity;
//import com.company.businessprocess.mapper.DeliveryNoteMapper;
//import com.company.businessprocess.productorder.ProductOrderRepository;
//import com.company.businessprocess.receivingnote.ReceivingNoteRepository;
//import com.company.businessprocess.receivingnote.receivingnotedetail.ReceivingNoteDetailRepository;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//public class DeliveryNoteDetailServiceImpl implements DeliveryNoteDetailService {
//    private DeliveryNoteDetailRepository deliveryNoteDetailRepository;
//    private DeliveryNoteRepository deliveryNoteRepository;
//    private ProductOrderRepository productOrderRepository;
//    private ReceivingNoteRepository receivingNoteRepository;
//    private ReceivingNoteDetailRepository receivingNoteDetailRepository;
//    private DeliveryNoteMapper deliveryNoteMapper;
//
//    public DeliveryNoteDetailServiceImpl(DeliveryNoteDetailRepository productOrderDetailRepository, DeliveryNoteRepository productRepository, ProductOrderRepository productOrderRepository, ReceivingNoteRepository receivingNoteRepository, ReceivingNoteDetailRepository receivingNoteDetailRepository, DeliveryNoteMapper deliveryNoteMapper) {
//        this.deliveryNoteDetailRepository = productOrderDetailRepository;
//        this.deliveryNoteRepository = productRepository;
//        this.productOrderRepository = productOrderRepository;
//        this.receivingNoteRepository = receivingNoteRepository;
//        this.receivingNoteDetailRepository = receivingNoteDetailRepository;
//        this.deliveryNoteMapper = deliveryNoteMapper;
//    }
//
//    @Override
//    public Page<DeliveryNoteResponse> getAllProductOrderDetail(Pageable pageable) {
//        Page<DeliverynoteEntity> productorderEntities =
//                deliveryNoteDetailRepository.findAll(pageable);
//        Page<ProductOrderDetailResponse> productOrderResponses = productorderEntities.map(productorderEntity -> mapper.map(productorderEntity, ProductOrderDetailResponse.class));
//        return productOrderResponses;
//    }
//
//    @Override
//    public ProductOrderDetailResponse addProductOrderDetail(Integer productOrderId, ProductOrderDetailRequest request) {
//        ProductorderdetailEntity productorderdetailEntity = new ProductorderdetailEntity();
//        productorderdetailEntity.setPrice(request.getPrice());
//        productorderdetailEntity.setQuantity(request.getQuantity());
//
//        ProductEntity productEntity = deliveryNoteRepository.getOne(request.getProductId());
//        productorderdetailEntity.setProductByProductId(productEntity);
//
//        ProductorderEntity productorderEntity = productOrderRepository.getOne(productOrderId);
//        productorderdetailEntity.setProductorderByOrderId(productorderEntity);
//
////        ReceivingnotedetailEntity receivingnotedetailEntity =
////                mapper.map(productorderdetailEntity, ReceivingnotedetailEntity.class);
//////        ReceivingnoteEntity receivingnoteEntity = receivingNoteRepository.getOne()
////        receivingNoteDetailRepository.save(receivingnotedetailEntity);
//        return mapper.map(deliveryNoteDetailRepository.save(productorderdetailEntity), ProductOrderDetailResponse.class);
//    }
//
//    @Override
//    public void deleteProductOrderDetail(Integer id) {
//        Optional<ProductorderdetailEntity> currentEntity = deliveryNoteDetailRepository.findById(id);
//        if (currentEntity.isPresent()) {
//            deliveryNoteDetailRepository.deleteById(id);
//        }
//    }
//}

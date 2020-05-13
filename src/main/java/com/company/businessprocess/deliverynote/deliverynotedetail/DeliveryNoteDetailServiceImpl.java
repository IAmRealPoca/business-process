package com.company.businessprocess.deliverynote.deliverynotedetail;

import com.company.businessprocess.deliverynote.DeliveryNoteRepository;
import com.company.businessprocess.dto.request.DeliveryNoteDetailRequest;
import com.company.businessprocess.dto.response.DeliveryNoteDetailResponse;
import com.company.businessprocess.entity.DeliverynoteEntity;
import com.company.businessprocess.entity.DeliverynotedetailEntity;
import com.company.businessprocess.entity.ProductEntity;
import com.company.businessprocess.entity.ProductorderEntity;
import com.company.businessprocess.mapper.DeliveryNoteDetailMapper;
import com.company.businessprocess.mapper.DeliveryNoteMapper;
import com.company.businessprocess.product.ProductRepository;
import com.company.businessprocess.productorder.ProductOrderRepository;
import com.company.businessprocess.receivingnote.ReceivingNoteRepository;
import com.company.businessprocess.receivingnote.receivingnotedetail.ReceivingNoteDetailRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DeliveryNoteDetailServiceImpl implements DeliveryNoteDetailService {
    private DeliveryNoteDetailRepository deliveryNoteDetailRepository;
    private DeliveryNoteRepository deliveryNoteRepository;
    private ProductOrderRepository productOrderRepository;
    private ReceivingNoteRepository receivingNoteRepository;
    private ReceivingNoteDetailRepository receivingNoteDetailRepository;
    private DeliveryNoteMapper deliveryNoteMapper;
    private DeliveryNoteDetailMapper deliveryNoteDetailMapper;
    private ProductRepository productRepository;

    public DeliveryNoteDetailServiceImpl(DeliveryNoteDetailRepository productOrderDetailRepository, DeliveryNoteRepository deliveryNoteRepository, ProductOrderRepository productOrderRepository, ReceivingNoteRepository receivingNoteRepository, ReceivingNoteDetailRepository receivingNoteDetailRepository, DeliveryNoteMapper deliveryNoteMapper, DeliveryNoteDetailMapper deliveryNoteDetailMapper, ProductRepository productRepository) {
        this.deliveryNoteDetailRepository = productOrderDetailRepository;
        this.deliveryNoteRepository = deliveryNoteRepository;
        this.productOrderRepository = productOrderRepository;
        this.receivingNoteRepository = receivingNoteRepository;
        this.receivingNoteDetailRepository = receivingNoteDetailRepository;
        this.deliveryNoteMapper = deliveryNoteMapper;
        this.deliveryNoteDetailMapper = deliveryNoteDetailMapper;
        this.productRepository = productRepository;
    }

    @Override
    public Page<DeliveryNoteDetailResponse> getAllDeliveryNoteDetail(Pageable pageable) {
        Page<DeliverynotedetailEntity> deliverynoteDetailEntities = deliveryNoteDetailRepository.findAll(pageable);
        Page<DeliveryNoteDetailResponse> deliveryNoteResponses =
                deliverynoteDetailEntities.map(element -> deliveryNoteDetailMapper.fromEntityToResponse(element));
        return deliveryNoteResponses;
    }

    @Override
    public DeliveryNoteDetailResponse addDeliveryNoteDetail(Integer deliveryNoteId, DeliveryNoteDetailRequest request) {
        DeliverynotedetailEntity deliverynotedetailEntity = new DeliverynotedetailEntity();
        deliverynotedetailEntity.setPrice(request.getPrice());
        deliverynotedetailEntity.setQuantity(request.getQuantity());

        ProductEntity productEntity = productRepository.getOne(request.getProductId());
        deliverynotedetailEntity.setProductByProductId(productEntity);

        DeliverynoteEntity deliverynoteEntity = deliveryNoteRepository.getOne(deliveryNoteId);
        deliverynotedetailEntity.setDeliverynoteByDeliveryId(deliverynoteEntity);

        return deliveryNoteDetailMapper.fromEntityToResponse(deliveryNoteDetailRepository.save(deliverynotedetailEntity));
    }

    @Override
    public void deleteDeliveryNoteDetail(Integer id) {

    }
}

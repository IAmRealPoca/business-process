package com.company.businessprocess.productorder;

import com.company.businessprocess.dto.request.ProductOrderRequest;
import com.company.businessprocess.dto.response.ProductOrderResponse;
import com.company.businessprocess.entity.ProductorderEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class ProductOrderServiceImpl implements ProductOrderService {
    private ProductOrderRepository productOrderRepository;
    private ModelMapper mapper;


    public ProductOrderServiceImpl(ProductOrderRepository productOrderRepository, ModelMapper mapper) {
        this.productOrderRepository = productOrderRepository;
        this.mapper = mapper;
    }

    @Override
    public Collection<ProductOrderResponse> getAllProductOrder() {
        Collection<ProductOrderResponse> productOrderResponses =
                productOrderRepository.findAll().stream()
                        .map(productorderEntity -> mapper.map(productorderEntity, ProductOrderResponse.class))
                        .collect(Collectors.toList());
        return productOrderResponses;
    }

    @Override
    public ProductorderEntity addProductOrder(ProductOrderRequest newProductOrder) {
        ProductorderEntity newEntity = mapper.map(newProductOrder, ProductorderEntity.class);
        return productOrderRepository.save(newEntity);
    }

    @Override
    public ProductorderEntity updateProductOrder(Integer id, ProductorderEntity updateEntity) {
        return productOrderRepository.save(updateEntity);
    }
    

    @Override
    public void deleteProductOrder(Integer id) {
        productOrderRepository.deleteById(id);
    }
}

package com.company.businessprocess.productorder;

import com.company.businessprocess.deliverynote.DeliveryNoteRepository;
import com.company.businessprocess.entity.ProductorderEntity;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ProductOrderServiceImpl implements ProductOrderService {
    private ProductOrderRepository productOrderRepository;


    public ProductOrderServiceImpl(ProductOrderRepository productOrderRepository) {
        this.productOrderRepository = productOrderRepository;
    }

    @Override
    public Collection<ProductorderEntity> getAllProductOrder() {
        return productOrderRepository.findAll();
    }

    @Override
    public ProductorderEntity addProductOrder(ProductorderEntity newEntity) {
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

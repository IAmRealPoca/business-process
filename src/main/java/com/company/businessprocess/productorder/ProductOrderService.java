package com.company.businessprocess.productorder;

import com.company.businessprocess.entity.ProductorderEntity;

import java.util.Collection;

public interface ProductOrderService {
    Collection<ProductorderEntity> getAllProductOrder();
    ProductorderEntity addDeliveryNote(ProductorderEntity newEntity);
    ProductorderEntity updateDeliveryNote (Integer Id, ProductorderEntity updateEntity);
    void deleteProductOrder (Integer Id);
}

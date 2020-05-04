package com.company.businessprocess.productorder;

import com.company.businessprocess.dto.ProductOrderResponse;
import com.company.businessprocess.entity.ProductorderEntity;

import java.util.Collection;

public interface ProductOrderService {
    Collection<ProductOrderResponse> getAllProductOrder();
    ProductorderEntity addProductOrder(ProductorderEntity newEntity);
    ProductorderEntity updateProductOrder (Integer id, ProductorderEntity updateEntity);
    void deleteProductOrder (Integer id);
}

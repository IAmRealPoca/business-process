package com.company.businessprocess.productorder;

import com.company.businessprocess.dto.request.ProductOrderRequest;
import com.company.businessprocess.dto.response.ProductOrderResponse;
import com.company.businessprocess.entity.ProductorderEntity;

import java.util.Collection;

public interface ProductOrderService {
    Collection<ProductOrderResponse> getAllProductOrder();
    ProductorderEntity addProductOrder(ProductOrderRequest newProductOrder);
    ProductorderEntity updateProductOrder (Integer id, ProductorderEntity updateEntity);
    void deleteProductOrder (Integer id);
}

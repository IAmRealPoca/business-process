package com.company.businessprocess.product;

import com.company.businessprocess.dto.response.ProductResponse;
import com.company.businessprocess.entity.ProductEntity;

import java.util.Collection;

public interface ProductService {
    Collection<ProductResponse> getAllProduct();

    ProductEntity addProduct(ProductEntity newEntity);

    ProductEntity updateProduct(Integer id, ProductEntity updateEntity);

    void deleteProduct(Integer id);
}

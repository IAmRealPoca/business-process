package com.company.businessprocess.product;

import com.company.businessprocess.dto.request.ProductRequest;
import com.company.businessprocess.dto.response.ProductResponse;
import com.company.businessprocess.entity.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Collection;

public interface ProductService {
    Page<ProductResponse> getAllProduct(Pageable pageable);

    ProductResponse addProduct(ProductRequest newProduct);

    ProductResponse updateProduct(Integer id, ProductRequest updateEntity);

    void deleteProduct(Integer id);
}

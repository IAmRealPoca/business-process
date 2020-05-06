package com.company.businessprocess.productorder;

import com.company.businessprocess.dto.request.ProductOrderRequest;
import com.company.businessprocess.dto.response.ProductOrderResponse;
import com.company.businessprocess.dto.response.ProductResponse;
import com.company.businessprocess.entity.ProductorderEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.sql.Date;
import java.util.Collection;

public interface ProductOrderService {
    Page<ProductOrderResponse> getAllProductOrder(Pageable pageable);
    Page<ProductOrderResponse> searchProductOrder(Date beginDate, Date endDate, Pageable pageable);
    ProductOrderResponse addProductOrder(ProductOrderRequest newProductOrder);
    ProductorderEntity updateProductOrder (Integer id, ProductorderEntity updateEntity);
    void deleteProductOrder (Integer id);
}

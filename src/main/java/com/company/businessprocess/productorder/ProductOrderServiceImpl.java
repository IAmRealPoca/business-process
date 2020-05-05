package com.company.businessprocess.productorder;

import com.company.businessprocess.dto.request.ProductOrderRequest;
import com.company.businessprocess.dto.response.ProductOrderResponse;
import com.company.businessprocess.dto.response.ProductResponse;
import com.company.businessprocess.entity.ProductEntity;
import com.company.businessprocess.entity.ProductorderEntity;
import com.company.businessprocess.entity.StaffEntity;
import com.company.businessprocess.product.ProductRepository;
import com.company.businessprocess.staff.StaffRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class ProductOrderServiceImpl implements ProductOrderService {
    private ProductOrderRepository productOrderRepository;
    private ProductRepository productRepository;
    private StaffRepository staffRepository;
    private ModelMapper mapper;


    public ProductOrderServiceImpl(ProductOrderRepository productOrderRepository, ProductRepository productRepository, StaffRepository staffRepository, ModelMapper mapper) {
        this.productOrderRepository = productOrderRepository;
        this.productRepository = productRepository;
        this.staffRepository = staffRepository;
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
    public ProductOrderResponse addProductOrder(ProductOrderRequest newProductOrder) {
        ProductorderEntity newEntity = mapper.map(newProductOrder, ProductorderEntity.class);
        ProductEntity product = productRepository.getOne(newProductOrder.getProductId());
        newEntity.setProductByProductId(product);
        StaffEntity staff = staffRepository.getOne(newProductOrder.getStaffId());
        newEntity.setStaffByStaffId(staff);
        return mapper.map(productOrderRepository.save(newEntity), ProductOrderResponse.class);
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

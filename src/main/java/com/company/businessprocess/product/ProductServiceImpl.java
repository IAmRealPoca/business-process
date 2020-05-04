package com.company.businessprocess.product;

import com.company.businessprocess.dto.ProductResponse;
import com.company.businessprocess.entity.ProductEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;
    private ModelMapper mapper;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ModelMapper mapper) {
        this.productRepository = productRepository;
        this.mapper = mapper;
    }

    @Override
    public Collection<ProductResponse> getAllProduct() {
        Collection<ProductResponse> responses =
                productRepository.findAll().stream()
                .map(productEntity -> mapper.map(productEntity, ProductResponse.class))
                .collect(Collectors.toList());
        return responses;
    }

    @Override
    public ProductEntity addProduct(ProductEntity newEntity) {
        return null;
    }

    @Override
    public ProductEntity updateProduct(Integer id, ProductEntity updateEntity) {
        return null;
    }

    @Override
    public void deleteProduct(Integer id) {

    }
}

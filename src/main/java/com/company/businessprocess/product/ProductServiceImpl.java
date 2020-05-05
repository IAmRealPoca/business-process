package com.company.businessprocess.product;

import com.company.businessprocess.category.CategoryRepository;
import com.company.businessprocess.dto.request.ProductRequest;
import com.company.businessprocess.dto.response.ProductResponse;
import com.company.businessprocess.entity.CategoryEntity;
import com.company.businessprocess.entity.ProductEntity;
import com.company.businessprocess.entity.ProviderEntity;
import com.company.businessprocess.provider.ProviderRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;
    private ProviderRepository providerRepository;
    private CategoryRepository categoryRepository;
    private ModelMapper mapper;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ProviderRepository providerRepository, CategoryRepository categoryRepository, ModelMapper mapper) {
        this.productRepository = productRepository;
        this.providerRepository = providerRepository;
        this.categoryRepository = categoryRepository;
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
    public ProductResponse addProduct(ProductRequest newProduct) {
        ProductEntity newEntity = mapper.map(newProduct, ProductEntity.class);
        ProviderEntity company = providerRepository.getOne(newProduct.getCompanyId());
        CategoryEntity category = categoryRepository.getOne(newProduct.getCategoryId());
        newEntity.setProviderByCompany(company);
        newEntity.setCategoryByCategoryId(category);
        return mapper.map(productRepository.save(newEntity), ProductResponse.class);
    }

    @Override
    public ProductEntity updateProduct(Integer id, ProductRequest updateEntity) {
        Optional<ProductEntity> optionalProductEntity = productRepository.findById(id);
        if (optionalProductEntity.isPresent()) {
            ProductEntity currentProduct = optionalProductEntity.get();
            currentProduct = mapper.map(updateEntity, ProductEntity.class);
            productRepository.save(currentProduct);
        }
        return null;
    }

    @Override
    public void deleteProduct(Integer id) {

    }
}

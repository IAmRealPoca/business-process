package com.company.businessprocess.product;

import com.company.businessprocess.category.CategoryRepository;
import com.company.businessprocess.dto.request.ProductRequest;
import com.company.businessprocess.dto.response.ProductResponse;
import com.company.businessprocess.entity.CategoryEntity;
import com.company.businessprocess.entity.ProductEntity;
import com.company.businessprocess.entity.ProviderEntity;
import com.company.businessprocess.mapper.ProductMapper;
import com.company.businessprocess.provider.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;
    private ProviderRepository providerRepository;
    private CategoryRepository categoryRepository;
    private ProductMapper productMapper;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ProviderRepository providerRepository, CategoryRepository categoryRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.providerRepository = providerRepository;
        this.categoryRepository = categoryRepository;
        this.productMapper = productMapper;
    }

    @Override
    public Page<ProductResponse> getAllProduct(Pageable pageable) {
        Page<ProductEntity> results = productRepository.findAll(pageable);
        Page<ProductResponse> responses =
                results.map(productEntity -> productMapper.fromEntityToResponse(productEntity));
//                .map()
//                .collect(Collectors.toList());
//        Page<ProductResponse> pageResult = new PageImpl<>((List<ProductResponse>) responses, pageable, responses.size());
        return responses;
    }

    @Override
    public ProductResponse addProduct(ProductRequest newProduct) {
        ProductEntity newEntity = productMapper.fromRequestToEntity(newProduct);
        ProviderEntity company = providerRepository.getOne(newProduct.getCompanyId());
        CategoryEntity category = categoryRepository.getOne(newProduct.getCategoryId());
        newEntity.setProviderByCompany(company);
        newEntity.setCategoryByCategoryId(category);
        return productMapper.fromEntityToResponse(productRepository.save(newEntity));
    }

    @Override
    public ProductResponse updateProduct(Integer id, ProductRequest updateEntity) {
        Optional<ProductEntity> optionalProductEntity = productRepository.findById(id);
        if (optionalProductEntity.isPresent()) {
            ProductEntity currentProduct = optionalProductEntity.get();
            currentProduct.mergeToUpdate(updateEntity);
            return productMapper.fromEntityToResponse(productRepository.save(currentProduct));
        }
        return null;
    }

    @Override
    public void deleteProduct(Integer id) {
        Optional<ProductEntity> optionalProductEntity = productRepository.findById(id);
        if (optionalProductEntity.isPresent()) {
            productRepository.deleteById(id);
        }
    }
}

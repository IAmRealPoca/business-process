package com.company.businessprocess.dto.response;

import com.company.businessprocess.entity.CategoryEntity;
import com.company.businessprocess.entity.DeliverynoteEntity;
import com.company.businessprocess.entity.ProductorderEntity;
import com.company.businessprocess.entity.ProviderEntity;
import com.company.businessprocess.entity.ReceivingnoteEntity;
import com.company.businessprocess.entity.SaleinvoiceEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponse {
    private Integer productId;
    private String name;
    private String model;
    private String brand;
    private String description;
    private Double price;

    private Map<String, Object> companyInfo;
    private Map<String, Object> categoryInfo;

    public void mapCompanyInfo(ProviderEntity source) {
        if (CollectionUtils.isEmpty(companyInfo)) {
            companyInfo = new HashMap<>();
        }
        companyInfo.put("providerId", source.getProviderId());
        companyInfo.put("name", source.getName());
    }

    public void mapCategoryInfo(CategoryEntity source) {
        if (CollectionUtils.isEmpty(categoryInfo)) {
            categoryInfo = new HashMap<>();
        }
        categoryInfo.put("categoryId", source.getCategoryId());
        categoryInfo.put("name", source.getName());
    }
}

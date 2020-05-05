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

import java.util.Collection;

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

//    private Collection<DeliverynoteEntity> deliverynotesByProductId;
//    private ProviderEntity providerByCompany;
//    private CategoryEntity categoryByCategoryId;
//    private Collection<ProductorderEntity> productordersByProductId;
//    private Collection<ReceivingnoteEntity> receivingnotesByProductId;
//    private Collection<SaleinvoiceEntity> saleinvoicesByProductId;
}

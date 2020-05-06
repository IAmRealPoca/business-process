package com.company.businessprocess.config;

import com.company.businessprocess.dto.response.SaleInvoiceResponse;
import com.company.businessprocess.entity.SaleinvoiceEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
    private ModelMapper modelMapper;

    PropertyMap<SaleinvoiceEntity, SaleInvoiceResponse> saleInvoiceMap = new PropertyMap<SaleinvoiceEntity, SaleInvoiceResponse>() {
        @Override
        protected void configure() {
            map().mapProductInfo(source.getProductByProductId());

            map().mapStaffInfo(source.getStaffByStaffId());

            map().mapCustomerInfo(source.getCustomerByCustomerId());
        }
    };

    @Bean
    public ModelMapper modelMapper() {
        if (modelMapper == null) {
            modelMapper = new ModelMapper();
            modelMapper.getConfiguration()
                    .setMatchingStrategy(MatchingStrategies.STRICT)
                    .setSkipNullEnabled(true);
            modelMapper.addMappings(saleInvoiceMap);
        }
        return modelMapper;
    }
}

//package com.company.businessprocess.config;
//
//import com.company.businessprocess.dto.response.DeliveryNoteResponse;
//import com.company.businessprocess.dto.response.ProductOrderResponse;
//import com.company.businessprocess.dto.response.ProductResponse;
//import com.company.businessprocess.dto.response.ReceivingNoteResponse;
//import com.company.businessprocess.dto.response.SaleInvoiceResponse;
//import com.company.businessprocess.entity.DeliverynoteEntity;
//import com.company.businessprocess.entity.ProductEntity;
//import com.company.businessprocess.entity.ProductorderEntity;
//import com.company.businessprocess.entity.ReceivingnoteEntity;
//import com.company.businessprocess.entity.SaleinvoiceEntity;
//import org.modelmapper.ModelMapper;
//import org.modelmapper.PropertyMap;
//import org.modelmapper.convention.MatchingStrategies;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class ApplicationConfig {
//    private ModelMapper modelMapper;
//
//    PropertyMap<SaleinvoiceEntity, SaleInvoiceResponse> saleInvoiceMap = new PropertyMap<SaleinvoiceEntity, SaleInvoiceResponse>() {
//        @Override
//        protected void configure() {
//            map().mapProductInfo(source.getProductByProductId());
//
//            map().mapStaffInfo(source.getStaffByStaffId());
//
//            map().mapCustomerInfo(source.getCustomerByCustomerId());
//        }
//    };
//
//    PropertyMap<DeliverynoteEntity, DeliveryNoteResponse> deliveryNoteMap = new PropertyMap<DeliverynoteEntity, DeliveryNoteResponse>() {
//        @Override
//        protected void configure() {
//
//            map().mapStaffInfo(source.getStaffByStaffId());
//
//            map().mapCustomerInfo(source.getCustomerByCustomerId());
//        }
//    };
//
//    PropertyMap<ProductorderEntity, ProductOrderResponse> productOrderMap = new PropertyMap<ProductorderEntity, ProductOrderResponse>() {
//        @Override
//        protected void configure() {
//            map().mapProductOrderDetail(source.getProductorderdetailsByOrderId());
//
//            map().mapStaffInfo(source.getStaffByStaffId());
//        }
//    };
//
//    PropertyMap<ReceivingnoteEntity, ReceivingNoteResponse> receivingNoteMap = new PropertyMap<ReceivingnoteEntity, ReceivingNoteResponse>() {
//        @Override
//        protected void configure() {
//            map().mapReceivingNoteDetailInfo(source.getReceivingnotedetailsByReceiveId());
//            map().mapStaffInfo(source.getStaffByStaffId());
//        }
//    };
//
//    PropertyMap<ProductEntity, ProductResponse> productMap = new PropertyMap<ProductEntity, ProductResponse>() {
//        @Override
//        protected void configure() {
//            map().mapCompanyInfo(source.getProviderByCompany());
//
//            map().mapCategoryInfo(source.getCategoryByCategoryId());
//        }
//    };
//
//    @Bean
//    public ModelMapper modelMapper() {
//        if (modelMapper == null) {
//            modelMapper = new ModelMapper();
//            modelMapper.getConfiguration()
//                    .setMatchingStrategy(MatchingStrategies.STRICT)
//                    .setSkipNullEnabled(true);
//            modelMapper.addMappings(saleInvoiceMap);
//            modelMapper.addMappings(deliveryNoteMap);
//            modelMapper.addMappings(productOrderMap);
//            modelMapper.addMappings(receivingNoteMap);
//            modelMapper.addMappings(productMap);
//        }
//        return modelMapper;
//    }
//}

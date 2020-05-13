package com.company.businessprocess;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.company.businessprocess.mybatis")
public class BusinessprocessApplication {

    public static void main(String[] args) {
        SpringApplication.run(BusinessprocessApplication.class, args);
    }

}

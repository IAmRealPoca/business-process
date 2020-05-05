package com.company.businessprocess.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequest {
    private Integer companyId;
    private Integer categoryId;
    private String name;
    private String model;
    private String brand;
    private String description;
    private Double price;
}
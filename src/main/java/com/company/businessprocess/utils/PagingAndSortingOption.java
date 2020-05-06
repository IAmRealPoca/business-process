package com.company.businessprocess.utils;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PagingAndSortingOption {
    private Integer page;
    private Integer size;
    private String sortField;
    private String sortOrder;
}
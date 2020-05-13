package com.company.businessprocess.dto.request;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProviderRequest {
    private String name;
    private String address;
    private Integer phone;
    private Integer fax;
    private String email;
    private String contactPerson;
}

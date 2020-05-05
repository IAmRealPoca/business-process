package com.company.businessprocess.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StaffResponse {
    private Integer staffId;
    private String name;
    private String address;
    private Integer phone;
    private String email;
}

package com.tekshila.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode
public class Ambulance {
    private String hospital;
    private String phone;
    private String phone2;
    private String state;
    private String city;

    public Ambulance(String hospital, String phone) {
        this.hospital = hospital;
        this.phone = phone;
    }
}

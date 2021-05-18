package com.tekshila.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/* Info on beds available in a hospital */
@Data
@NoArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor
public class HospitalBed {

    private String hospitalName;
    private String numOfBeds;
    private String contactNum;

}

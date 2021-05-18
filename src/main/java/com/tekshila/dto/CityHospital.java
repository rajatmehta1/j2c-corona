package com.tekshila.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

/*
  Info about hospital available in the city
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class CityHospital {
    private String cityName;
    private String covid19BedsAvl;
    private String covid19BedsAvl2;
    private String covid19BedsIcuAvl;
    private List<HospitalBed> hospitalBedList;
}

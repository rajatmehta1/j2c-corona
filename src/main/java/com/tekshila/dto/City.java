package com.tekshila.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode
public class City implements Comparable{

    private String name;
    private Integer id;
    private double latitude;
    private double longitude;
    private String shortName;

    public City(String name,String shortName, double latitude, double longitude) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.shortName = shortName;
    }

    @Override
    public int compareTo(Object o) {
        City city2 = (City) o;
        return String.CASE_INSENSITIVE_ORDER.compare(this.name,city2.getName());
    }
}

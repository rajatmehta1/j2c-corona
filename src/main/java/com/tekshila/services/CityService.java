package com.tekshila.services;

import com.tekshila.dto.City;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class CityService {

    public List<City> getCities() {
        City c1 = new City("New Delhi","Delhi",28.644800,77.216721);
        City c2 = new City("Mumbai","Mumbai",19.076090, 72.877426);
        City c3 = new City("Pune","Pune",18.516726, 73.856255);
        City c4 = new City("Andhra Pradesh","Andhra Pradesh",18.516726, 73.856255);
        City c5 = new City("Telangana","Telangana",18.516726, 73.856255);
        City c6 = new City("West Bengal","West Bengal",18.516726, 73.856255);
        City c7 = new City("Ahmedabad","Ahmedabad",18.516726, 73.856255);
        City c8 = new City("Vadodara","Vadodara",18.516726, 73.856255);
        City c9 = new City("Nagpur","Nagpur",18.516726, 73.856255);
        City c10 = new City("Nashik","Nashik",18.516726, 73.856255);
        City c11 = new City("Madhya Pradesh","Madhya Pradesh",18.516726, 73.856255);
        City c12 = new City("Uttar Pradesh","Uttar Pradesh",18.516726, 73.856255);
        City c13 = new City("Rajasthan","Rajasthan",18.516726, 73.856255);
        City c14 = new City("Bhopal","Bhopal",18.516726, 73.856255);
        City c15 = new City("Haryana","Haryana",18.516726, 73.856255);
        City c16 = new City("Tamil Nadu","Tamil Nadu",18.516726, 73.856255);
        City c17 = new City("Beed","Beed",18.516726, 73.856255);
        City c18 = new City("Gandhinagar","Gandhinagar",18.516726, 73.856255);

        List<City> cities = new ArrayList<>();
            cities.add(c1);
            cities.add(c2);
            cities.add(c3);
        cities.add(c4);
        cities.add(c5);
        cities.add(c6);
        cities.add(c7);
        cities.add(c8);cities.add(c9);
        cities.add(c10);
        cities.add(c11);
        cities.add(c12);
        cities.add(c13);
        cities.add(c14);
        cities.add(c15);
        cities.add(c16);
        cities.add(c17);
        cities.add(c18);

          Collections.sort(cities);

            return cities;
    }
}

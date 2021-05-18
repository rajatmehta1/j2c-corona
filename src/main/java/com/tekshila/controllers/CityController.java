package com.tekshila.controllers;

import com.tekshila.dto.City;
import com.tekshila.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/*
 * Show list of top cities
 * pull cities from db and show
 * Each city will have latitude and longitude coordinate
 */
@Controller
@RequestMapping(value = "/v1/cd")
public class CityController {

    private final CityService cityService;

    @Autowired
    private CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @RequestMapping(value = "/cities", method = RequestMethod.GET)
    public String showCities(Model model) {
        List<City> cities = cityService.getCities();
            model.addAttribute("cities",cities);
        return "cities";
    }

    @RequestMapping(value = "/{city_name}/dashboard", method = RequestMethod.GET)
    public String showCities(@PathVariable(name = "city_name", required = true) String cityName, Model model) {
        model.addAttribute("city",cityName);
        return "city_dashboard";
    }


}

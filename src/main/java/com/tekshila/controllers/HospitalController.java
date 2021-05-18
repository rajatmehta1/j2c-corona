package com.tekshila.controllers;

import com.tekshila.dto.CityHospital;
import com.tekshila.helpers.HospitalBedHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

/* Shows informatioon about hospital
   like phone, beds available etc - by city
 */
@Controller
@RequestMapping("/v1/cd")
public class HospitalController {


    private HospitalBedHelper hospitalBedHelper;

    @Autowired
    public HospitalController(HospitalBedHelper hospitalBedHelper) {
        this.hospitalBedHelper = hospitalBedHelper;
    }

    @RequestMapping(value = "/{cn}/avlhsp")
    public String getAvailable(@PathVariable(name = "cn", required = true) String cityName, Model mdl) {
        try {
            CityHospital ch = hospitalBedHelper.pullHospitalInfo(cityName);
             mdl.addAttribute("ch",ch);
        } catch (IOException e) {
            e.printStackTrace();
        }
        mdl.addAttribute("cityName",cityName);
        return "city_hospitals";
    }


}

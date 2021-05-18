package com.tekshila.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//shows preventive care details
@Controller
@RequestMapping("/v1/pc")
public class PreventiveController {

    @RequestMapping(method = RequestMethod.GET)
    public String showPCScreen(Model model) {
        return "preventive_care";
    }


    @RequestMapping(value = "/masks",method = RequestMethod.GET)
    public String showMasksScreen(Model model) {
        return "masks";
    }

    @RequestMapping(value = "/sd",method = RequestMethod.GET)
    public String showSDScreen(Model model) {
        return "social_distancing";
    }
}

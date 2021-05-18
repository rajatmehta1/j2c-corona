package com.tekshila.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

//    @RequestMapping("/list_contact")
//    public String getHome(Model model) {
//        return "test";
//    }

    @RequestMapping("/list_contact")
    public String getHome(Model model) {
        return "testjqm";
    }

}

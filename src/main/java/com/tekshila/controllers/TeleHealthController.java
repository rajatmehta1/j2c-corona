package com.tekshila.controllers;

import com.tekshila.dto.TeleHealth;
import com.tekshila.services.TeleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/v1/cd/teles")
public class TeleHealthController {

    TeleService teleService;

    @Autowired
    public TeleHealthController(TeleService teleService) {
        this.teleService = teleService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String listTeles(Model model) {
        model.addAttribute("teles",teleService.getTeles());
        return "teles";
    }

}

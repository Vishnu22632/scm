package com.scm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/home")
    public String home(Model model){

        model.addAttribute("name", "Vishnu Thakur");
        model.addAttribute("city", "Janakpur");
        System.out.println("Home page handler...");
        return "home";
    }
}

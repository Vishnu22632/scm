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


    @GetMapping("/about")
    public String about(){
        System.out.println("About page loading...");
        return "about";
    }

    @GetMapping("/services")
    public String servicePage(){
        System.out.println("Service page loading...");
        return "services";
    }


    @GetMapping("/contact")
    public String contact(){
        return "contact";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/signup")
    public String signup(){
        return "signup";
    }

}

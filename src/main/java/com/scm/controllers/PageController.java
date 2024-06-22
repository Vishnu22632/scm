package com.scm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.scm.entities.User;
import com.scm.forms.UserForm;
import com.scm.services.UserService;

@Controller
public class PageController {

    @Autowired
    private UserService userService;

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
    public String signup(Model model){
        UserForm userForm=new UserForm();
        
        model.addAttribute("userForm", userForm);
        return "signup";
    }

    @PostMapping("/do_register")
    public String processRegister(@ModelAttribute UserForm userForm){
        System.out.println("process register...");

        //fetch form data
        //userform
        System.out.println(userForm);
        //validate form data
        // Todo 

        //save to database
        User user=User.builder()
        .name(userForm.getName())
        .email(userForm.getEmail())
        .password(userForm.getPassword())
        .phoneNumber(userForm.getPhoneNumber())
        .about(userForm.getAbout())
        .profilePic("https://www.iconfinder.com/icons/403017/avatar_default_head_person_unknown_user_anonym_icon")
        
        .build();

        User savedUser= userService.saveUser(user);

        System.out.println("User saved...");


        //message = "Registration successful"


        //redirect to login page

        return "redirect:/signup";
    }

}

package com.scm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.scm.entities.User;
import com.scm.forms.UserForm;
import com.scm.helpers.Message;
import com.scm.helpers.MessageType;
import com.scm.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

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
    public String processRegister(@Valid @ModelAttribute UserForm userForm,BindingResult rBindingResult, HttpSession session){
        System.out.println("process register...");

        //fetch form data
        //userform
        System.out.println(userForm);
        //validate form data
        if(rBindingResult.hasErrors()){
            return "signup";
        }





        // Todo 

        //save to database
        // User user=User.builder()
        // .name(userForm.getName())
        // .email(userForm.getEmail())
        // .password(userForm.getPassword())
        // .phoneNumber(userForm.getPhoneNumber())
        // .about(userForm.getAbout())
        // .profilePic("https://www.iconfinder.com/icons/403017/avatar_default_head_person_unknown_user_anonym_icon")
        
        // .build();


        User user=new User();
        user.setName(userForm.getName());
        user.setEmail(userForm.getEmail());
        user.setPassword(userForm.getPassword());
        user.setPhoneNumber(userForm.getPhoneNumber());
        user.setAbout(userForm.getAbout());
        user.setProfilePic("https://www.iconfinder.com/icons/403017/avatar_default_head_person_unknown_user_anonym_icon");

        User savedUser= userService.saveUser(user);

        System.out.println("User saved...");


        //message = "Registration successful"

       
        // add the message

       Message message= Message.builder().content("Registration Successful !!!").type(MessageType.blue).build();
        session.setAttribute("message", message);

    

       


        //redirect to login page

        return "redirect:/signup";
    }

}

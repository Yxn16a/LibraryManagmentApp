package com.example.librarymanagmentapp.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {
    @GetMapping("/login")
    public String login() {
        return "registrationpractice";
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/index")
    public String goHome(){
        return "index";
    }

    @GetMapping("/logout")
    public String logout(){
        return "login";
    }
    @GetMapping("/registration")
    public String registrationForm(){
        return "registrationform";
    }
}

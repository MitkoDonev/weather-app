package com.mitkodonev.controller;

import com.mitkodonev.model.LoginData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @RequestMapping("/login")
    public String requestLoginForm(Model model){
        model.addAttribute("loginData", new LoginData());
        return "login";
    }

    @RequestMapping("/logout-success")
    public String loggedOutSuccessfully(){
        return "logout-success";
    }

}

package com.mitkodonev.controller;

import com.mitkodonev.model.LoginData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class LoginController {

    @RequestMapping("/login")
    public String requestLoginForm(Model model){
        model.addAttribute("loginData", new LoginData());
        return "/login";
    }

    @RequestMapping("/logout-success")
    public String loggedOutSuccessfully(){
        return "logout-success";
    }

}

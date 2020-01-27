package com.mitkodonev.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping("/index")
    public String requestIndex(Model model){
        //model.addAttribute("products", productService.listProducts());
        return "index";
    }
}

package com.mitkodonev.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    private String[] TABLE_COLUMNS = {"ID", "CITY", "TEMPERATURE" ,"BLA", "PAPA", "TATA"};

    @RequestMapping("/index")
    public String requestIndex(Model model) {
        model.addAttribute("weatherTableColumns", TABLE_COLUMNS);
        //model.addAttribute("products", productService.listProducts());
        return "index";
    }
}

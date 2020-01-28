package com.mitkodonev.controller;

import com.mitkodonev.model.WeatherData;
import com.mitkodonev.services.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    private static final String[] TABLE_COLUMNS = {"ID", "CITY", "DATE", "TEMPERATURE", "PRECIPITATION", "WIND", "HUMIDITY", "DESCRIPTION"};

    private WeatherService weatherService;

    @Autowired
    public IndexController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @RequestMapping("/index")
    public String requestIndex(Model model) {
        model.addAttribute("weatherTableColumns", TABLE_COLUMNS);
        model.addAttribute("weatherDataList", weatherService.getAll());
        return "index";
    }

    @PostMapping("/index")
    public String addWeatherData(@ModelAttribute WeatherData weatherData){
        System.out.println(weatherData.getId());
        System.out.println(weatherData.getCity());
        return "index";
    }
}

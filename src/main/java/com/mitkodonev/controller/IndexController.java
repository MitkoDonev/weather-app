package com.mitkodonev.controller;

import com.mitkodonev.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    private static final String[] TABLE_COLUMNS = {"ID", "CITY", "DATE", "TEMPERATURE", "PRECIPITATION", "WIND", "HUMIDITY", "DESCRIPTION"};

    private WeatherRepository weatherRepository;

    @Autowired
    public IndexController(WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
    }

    @RequestMapping("/index")
    public String requestIndex(Model model) {
        model.addAttribute("weatherTableColumns", TABLE_COLUMNS);
        model.addAttribute("weatherData", weatherRepository.findAll());
        return "index";
    }
}

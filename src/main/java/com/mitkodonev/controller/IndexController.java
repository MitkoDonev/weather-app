package com.mitkodonev.controller;

import com.mitkodonev.model.WeatherData;
import com.mitkodonev.services.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

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

    @RequestMapping("/weather")
    public String requestSubmit(Model model) {
        model.addAttribute("weatherData", new WeatherData());
        return "weather";
    }

    @RequestMapping(value = "/addWeather", method = RequestMethod.POST)
    public String doCheckout(@Valid WeatherData weatherData, BindingResult bindingResult) {
        weatherService.addWeather(weatherData);
        return "redirect:index";
    }
}

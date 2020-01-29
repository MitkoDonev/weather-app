package com.mitkodonev.controller;

import com.mitkodonev.model.WeatherData;
import com.mitkodonev.services.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class WeatherController {

    private static final String[] TABLE_COLUMNS = {"ID", "CITY", "DATE", "TEMPERATURE", "PRECIPITATION", "WIND", "HUMIDITY", "DESCRIPTION", "ACTION"};

    private WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @RequestMapping("/weather")
    public String weatherList(Model model) {
        model.addAttribute("weatherTableColumns", TABLE_COLUMNS);
        model.addAttribute("weatherDataList", weatherService.getAll());
        return "weather";
    }

    @RequestMapping("/weather/new")
    public String addWeather(Model model) {
        model.addAttribute("weatherData", new WeatherData());
        return "add-edit-weather";
    }

    @RequestMapping("/weather/{weatherId}")
    public String editWeather(@PathVariable Long weatherId, Model model) {
        model.addAttribute("weatherData", weatherService.findById(weatherId));
        return "add-edit-weather";
    }

    @RequestMapping(value = "/saveWeather/{id}", method = RequestMethod.POST)
    public String saveWeather(@Valid WeatherData weatherData, @PathVariable Long id, BindingResult bindingResult) {
        if (id != null && id > 0) {
            weatherData.setId(id);
        }
        weatherService.saveWeather(weatherData);
        return "redirect:/weather";
    }

    @RequestMapping(value = "/weather/{weatherId}/delete")
    public String deleteWeather(@PathVariable Long weatherId) {
        weatherService.deleteWeather(weatherId);
        return "redirect:/weather";
    }
}

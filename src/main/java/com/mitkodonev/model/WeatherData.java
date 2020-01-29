package com.mitkodonev.model;

import com.mitkodonev.entity.City;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class WeatherData {

    private Long id;
    private City city;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date_time;
    private String temperature;
    private int highest_temp;
    private int lowest_temp;
    private int precipitation;
    private String wind;
    private int humidity;
    private String description;

    public Long getId() {
        return id;
    }

    public WeatherData setId(Long id) {
        this.id = id;
        return this;
    }

    public City getCity() {
        return city;
    }

    public WeatherData setCity(City city) {
        this.city = city;
        return this;
    }

    public LocalDate getDate_time() {
        return date_time;
    }

    public WeatherData setDate_time(LocalDate date_time) {
        this.date_time = date_time;
        return this;
    }

    public int getHighest_temp() {
        return highest_temp;
    }

    public WeatherData setHighest_temp(int highest_temp) {
        this.highest_temp = highest_temp;
        return this;
    }

    public int getLowest_temp() {
        return lowest_temp;
    }

    public WeatherData setLowest_temp(int lowest_temp) {
        this.lowest_temp = lowest_temp;
        return this;
    }

    public String getTemperature() {
        return temperature;
    }

    public WeatherData setTemperature(int lowest, int highest) {
        this.temperature = lowest + " / " + highest;
        return this;
    }

    public int getPrecipitation() {
        return precipitation;
    }

    public WeatherData setPrecipitation(int precipitation) {
        this.precipitation = precipitation;
        return this;
    }

    public String getWind() {
        return wind;
    }

    public WeatherData setWind(String wind) {
        this.wind = wind;
        return this;
    }

    public int getHumidity() {
        return humidity;
    }

    public WeatherData setHumidity(int humidity) {
        this.humidity = humidity;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public WeatherData setDescription(String description) {
        this.description = description;
        return this;
    }
}

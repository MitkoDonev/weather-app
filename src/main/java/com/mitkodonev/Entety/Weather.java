package com.mitkodonev.Entety;

import java.time.LocalDateTime;

public class Weather {
    private int id;
    private int city_id;
    private LocalDateTime date_time;
    private int highest_temp;
    private int lowest_temp;
    private int precip;
    private String wind;
    private int humidity;
    private String description;

    public Weather(int id, int city_id, LocalDateTime date_time, int highest_temp, int lowest_temp,
                   int precip, String wind, int humidity, String description) {
        this.id = id;
        this.city_id = city_id;
        this.date_time = date_time;
        this.highest_temp = highest_temp;
        this.lowest_temp = lowest_temp;
        this.precip = precip;
        this.wind = wind;
        this.humidity = humidity;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCity_id() {
        return city_id;
    }

    public void setCity_id(int city_id) {
        this.city_id = city_id;
    }

    public LocalDateTime getDate_time() {
        return date_time;
    }

    public void setDate_time(LocalDateTime date_time) {
        this.date_time = date_time;
    }

    public int getHighest_temp() {
        return highest_temp;
    }

    public void setHighest_temp(int highest_temp) {
        this.highest_temp = highest_temp;
    }

    public int getLowest_temp() {
        return lowest_temp;
    }

    public void setLowest_temp(int lowest_temp) {
        this.lowest_temp = lowest_temp;
    }

    public int getPrecip() {
        return precip;
    }

    public void setPrecip(int precip) {
        this.precip = precip;
    }

    public String getWind() {
        return wind;
    }

    public void setWind(String wind) {
        this.wind = wind;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

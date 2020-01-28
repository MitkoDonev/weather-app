package com.mitkodonev.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "WEATHER")
public class Weather {

    @Id
    @GeneratedValue
    private Long id;
    @OneToOne
    private City city;
    private LocalDateTime date_time;
    private int highest_temp;
    private int lowest_temp;
    private int precipitation;
    private String wind;
    private int humidity;
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
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

    public int getPrecipitation() {
        return precipitation;
    }

    public void setPrecipitation(int precipitation) {
        this.precipitation = precipitation;
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

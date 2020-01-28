package com.mitkodonev.entity;

public class City {
    private int id;
    private String city_name;
    private String country;

    public City(int id, String city_name, String country) {
        this.id = id;
        this.city_name = city_name;
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}

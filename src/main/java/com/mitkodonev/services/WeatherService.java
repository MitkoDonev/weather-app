package com.mitkodonev.services;

import com.mitkodonev.entity.Weather;
import com.mitkodonev.model.WeatherData;
import com.mitkodonev.repository.CityRepository;
import com.mitkodonev.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WeatherService {

    private final WeatherRepository weatherRepository;
    private final CityRepository cityRepository;

    @Autowired
    public WeatherService(final WeatherRepository weatherRepository, final CityRepository cityRepository) {
        this.weatherRepository = weatherRepository;
        this.cityRepository = cityRepository;
    }

    public List<WeatherData> getAll() {
        List<Weather> weathers = weatherRepository.findAll();
        if (weathers != null && !weathers.isEmpty()) {
            return weathers.stream().map(w -> new WeatherData()
                    .setId(w.getId())
                    .setCity(w.getCity())
                    .setDate_time(w.getDate_time())
                    .setDescription(w.getDescription())
                    .setHumidity(w.getHumidity())
                    .setWind(w.getWind())
                    .setPrecipitation(w.getPrecipitation())
                    .setTemperature(w.getLowest_temp(), w.getHighest_temp())).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    public void addWeather(WeatherData weatherData) {
        if (weatherData != null) {
            Weather weather = new Weather();
            weather.setDate_time(weatherData.getDate_time());
            weather.setDescription(weatherData.getDescription());
            weather.setHighest_temp(weatherData.getHighest_temp());
            weather.setLowest_temp(weatherData.getLowest_temp());
            weather.setPrecipitation(weatherData.getPrecipitation());
            weather.setHumidity(weatherData.getHumidity());
            weather.setWind(weatherData.getWind());

            if (weatherData.getCity() != null) {
                cityRepository.save(weatherData.getCity());
                weather.setCity(weatherData.getCity());
            }

            weatherRepository.save(weather);
        }
    }

}

package com.mitkodonev.services;

import com.mitkodonev.entity.Weather;
import com.mitkodonev.model.WeatherData;
import com.mitkodonev.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WeatherService {

    private WeatherRepository weatherRepository;

    @Autowired
    public WeatherService(WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
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

}

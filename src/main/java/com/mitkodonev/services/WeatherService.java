package com.mitkodonev.services;

import com.mitkodonev.entity.Weather;
import com.mitkodonev.model.WeatherData;
import com.mitkodonev.repository.CityRepository;
import com.mitkodonev.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
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
            return weathers.stream().map(w -> mapToWeatherData(w)).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    public WeatherData findById(Long id) {
        Optional<Weather> weather = weatherRepository.findById(id);
        if (weather.isPresent()) {
            return mapToWeatherData(weather.get());
        }
        return null;
    }

    public void saveWeather(WeatherData weatherData) {
        Weather weather = mapToWeather(weatherData);
        if (weather != null) {
            if (weather.getCity() != null) {
                cityRepository.save(weather.getCity());
            }
            weatherRepository.save(weather);
        }
    }

    public void deleteWeather(Long weatherId) {
        if (weatherId != null) {
            weatherRepository.deleteById(weatherId);
        }
    }

    private Weather mapToWeather(WeatherData weatherData) {
        if (weatherData != null) {
            Weather weather = new Weather();
            weather.setId(weatherData.getId());
            weather.setDate_time(weatherData.getDate_time());
            weather.setDescription(weatherData.getDescription());
            weather.setHighest_temp(weatherData.getHighest_temp());
            weather.setLowest_temp(weatherData.getLowest_temp());
            weather.setPrecipitation(weatherData.getPrecipitation());
            weather.setHumidity(weatherData.getHumidity());
            weather.setWind(weatherData.getWind());
            weather.setCity(weatherData.getCity());
            return weather;
        }
        return null;
    }

    private WeatherData mapToWeatherData(Weather weather) {
        return new WeatherData()
                .setId(weather.getId())
                .setCity(weather.getCity())
                .setDate_time(weather.getDate_time())
                .setDescription(weather.getDescription())
                .setHighest_temp(weather.getHighest_temp())
                .setLowest_temp(weather.getLowest_temp())
                .setHumidity(weather.getHumidity())
                .setWind(weather.getWind())
                .setPrecipitation(weather.getPrecipitation())
                .setTemperature(weather.getLowest_temp(), weather.getHighest_temp());
    }
}

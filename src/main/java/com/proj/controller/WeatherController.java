package com.proj.controller;


import com.proj.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/CurrentWeather/{city}")
    public String getCurrentWeather(@PathVariable String city) {
        return weatherService.getCurrentWeather(city);
    }
    
    @GetMapping("/futureWeather/{city}/{futureDate}/{days}")
    public String futureWeather(@PathVariable String city, @PathVariable String futureDate, @PathVariable String days) {
        return weatherService.getFutureWeather(city, futureDate, days);
    }

}

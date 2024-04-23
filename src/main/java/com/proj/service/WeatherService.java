package com.proj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    @Autowired
    private RestTemplate restTemplate;

    private final String apiKey = "a4df822769b94028843163825241503";
    private final String baseUrl = "http://api.weatherapi.com/v1";

    public String getCurrentWeather(String city) {
        String url = baseUrl + "/current.json?key=" + apiKey + "&q=" + city;
        return restTemplate.getForObject(url, String.class);
    }

    public String getHistoricalWeather(String city, String date) {
        String url = baseUrl + "/history.json?key=" + apiKey + "&q=" + city + "&dt=" + date;
        return restTemplate.getForObject(url, String.class);
    }

    public String getFutureWeather(String city, String futureDate, String days) {
        String url = baseUrl + "/forecast.json?key=" + apiKey + "&q=" + city + "&dt=" + futureDate + "&days=" + days;
        return restTemplate.getForObject(url, String.class);
    }
}


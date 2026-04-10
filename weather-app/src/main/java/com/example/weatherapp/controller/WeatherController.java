package com.example.weatherapp.controller;


import com.example.weatherapp.dto.WeatherInfo;
import com.example.weatherapp.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/weather")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173") // Cho phép React (Vite) gọi API
public class WeatherController {
    private final WeatherService weatherService;

    @GetMapping("/{city}")
    public ResponseEntity<WeatherInfo> getWeather(@PathVariable String city) {

        WeatherInfo info = weatherService.getWeatherByCity(city);

        return ResponseEntity.ok(info);
    }
}

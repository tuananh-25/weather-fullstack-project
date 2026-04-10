package com.example.weatherapp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.util.List;

@Data

public class WeatherResponse {

    private String name; // Tên thành phố

    @JsonProperty("main")
    private MainData main; // Chứa nhiệt độ, độ ẩm

    @JsonProperty("weather")
    private List<WeatherDescription> weather; // Chứa mô tả thời tiết

    @Data
    public static class MainData {
        private double temp;
        private int humidity;
    }

    @Data
    public static class WeatherDescription {
        private String description;
    }

    @Data
    public static class WindData {
        private double speed; // km/h
    }

    @JsonProperty("wind")
    private WindData wind;
}

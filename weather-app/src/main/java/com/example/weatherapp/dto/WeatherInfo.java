package com.example.weatherapp.dto;

import lombok.Builder;
import lombok.Data;

// Dùng @Builder để khởi tạo Object này một cách dễ dàng và gọn gàng
@Data
@Builder

public class WeatherInfo {

    private String cityName; // tên thành phố
    private int temperature; // nhiệt độ
    private int humidity; // độ ẩm
    private String description; // mô tả: mưa, nắng,...
    private double windSpeed;   // tốc độ gió
}

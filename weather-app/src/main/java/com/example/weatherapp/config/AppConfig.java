package com.example.weatherapp.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {
    // Khởi tạo Bean RestTemplate để sử dụng ở toàn bộ project
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}

package com.example.weatherapp.service;


import com.example.weatherapp.dto.WeatherInfo;
import com.example.weatherapp.dto.WeatherResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class WeatherService {

    private final RestTemplate restTemplate;

    // Lấy API Key từ file application.properties
    @Value("${weather.api.key}")
    private String apiKey;

    /**
     * Hàm gọi API thời tiết và trả về dữ liệu sạch
     */
    public WeatherInfo getWeatherByCity(String city) {
        // 1. Tạo URL gọi API (Dùng units=metric để lấy độ C, lang=vi để lấy tiếng Việt)
        String url = String.format(
                "https://api.openweathermap.org/data/2.5/weather?q=%s,VN&appid=%s&units=metric&lang=vi",
                city, apiKey
        );

        try {
            // 2. Gọi API và map vào class OpenWeatherResponse
            WeatherResponse rawData = restTemplate.getForObject(url, WeatherResponse.class);

            // 3. Nếu dữ liệu bị null (không tìm thấy), ném ra lỗi để báo cho Controller
            if (rawData == null) {
                throw new RuntimeException("Không lấy được dữ liệu từ OpenWeather.");
            }

            // 4. Chuyển đổi dữ liệu thô thành dữ liệu sạch để trả cho Front-end
            return WeatherInfo.builder()
                    .cityName(rawData.getName())
                    // Làm tròn nhiệt độ (ví dụ 28.6 -> 29)
                    .temperature((int) Math.round(rawData.getMain().getTemp()))
                    .humidity(rawData.getMain().getHumidity())
                    // Lấy mô tả thời tiết đầu tiên trong mảng
                    .description(rawData.getWeather().get(0).getDescription())
                    .windSpeed(Math.round(rawData.getWind().getSpeed() * 3.6)) // km/h
                    .build();

        } catch (HttpClientErrorException.NotFound e) {
            // Lỗi 404 từ OpenWeatherMap khi nhập sai tên thành phố
            throw new RuntimeException("Không tìm thấy thành phố: " + city);
        } catch (Exception e) {
            // Các lỗi khác (Mất mạng, sai API Key...)
            throw new RuntimeException("Lỗi hệ thống: " + e.getMessage());
        }
    }
}

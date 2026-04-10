import { useState } from "react";
import SearchWeather from "./components/SearchWeather";
import DetailWeather from "./components/DetailWeather";
import { fetchWeatherByCity } from "./pages/WeatherAPI";

function App() {
  const [weatherData, setWeatherData] = useState(null);
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState(null);

  const handleSearch = async (city) => {
    setLoading(true);
    setError(null); // Reset lỗi cũ
    setWeatherData(null); // Xóa data cũ

    try {
      // Gọi hàm từ service api.js
      const data = await fetchWeatherByCity(city);

      // { cityName: "Hanoi", temperature: 25, description: "Trời trong xanh", humidity: 80, windSpeed: 15 }
      setWeatherData(data);
    } catch (err) {
      setError(err.message);
    } finally {
      setLoading(false);
    }
  };

  return (
    <div className="container py-5" style={{ maxWidth: "600px" }}>
      <h1 className="text-center mb-4 text-primary fw-bold">
        Dự Báo Thời Tiết
      </h1>

      <SearchWeather onSearch={handleSearch} isLoading={loading} />

      {/* Hiển thị thông báo lỗi nếu có */}
      {error && (
        <div className="alert alert-danger shadow-sm" role="alert">
          {error}
        </div>
      )}

      {/* Hiển thị Card thời tiết nếu có data */}
      {weatherData && <DetailWeather weather={weatherData} />}
    </div>
  );
}

export default App;

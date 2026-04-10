const BASE_URL = "http://localhost:8080/api/weather";

export const fetchWeatherByCity = async (city) => {
  try {
    const response = await fetch(`${BASE_URL}/${city}`);
    if (!response.ok) {
      throw new Error("Không tìm thấy dữ liệu thời tiết cho khu vực này.");
    }
    return await response.json();
  } catch (error) {
    console.error("Lỗi khi gọi API thời tiết:", error);
    throw error;
  }
};

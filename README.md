🌦️ Weather App (Full-stack)

Ứng dụng tra cứu thời tiết thời gian thực, tích hợp dữ liệu từ OpenWeatherMap API. Dự án được xây dựng nhằm trình bày tư duy thiết kế hệ thống tách biệt (Decoupled) giữa Spring Boot và ReactJS.



**Công nghệ**



**Backend (Spring Boot)**

Java 17 / Spring Boot: Framework chính xử lý Logic và API.



Maven: Quản lý Dependency.



RestTemplate: Kết nối và tiêu thụ dữ liệu từ OpenWeather API.



Lombok \& DTO Pattern: Tối ưu hóa cấu trúc dữ liệu và bảo mật thông tin nội bộ.



**Frontend (React JS)**

Vite: Tooling giúp khởi động và build ứng dụng cực nhanh.



Bootstrap 5: Xây dựng giao diện Responsive (tương thích mọi thiết bị).



Fetch API: Giao tiếp mượt mà với Backend.



Chức năng

&#x20;- Search: Tìm kiếm thời tiết theo tên thành phố bất kỳ.



&#x20;- Real-time Data: Hiển thị nhiệt độ (°C), độ ẩm, tốc độ gió và mô tả trạng thái (tiếng Việt).



&#x20;- Error Handling: Xử lý ngoại lệ khi nhập sai tên thành phố hoặc lỗi kết nối hệ thống.



&#x20;- Security: Quản lý API Key thông qua biến môi trường (Environment Variables).



&#x20;**Hướng dẫn khởi chạy**

**1. Cấu hình API Key (Bắt buộc)**

Bạn cần đăng ký tài khoản tại OpenWeatherMap để lấy API Key.



**2. Chạy Backend**

Truy cập thư mục weather-app.



Cấu hình biến môi trường WEATHER\_API\_KEY trong hệ thống hoặc IDE.



Chạy lệnh:  mvn spring-boot:run





**3. Chạy Frontend**

Truy cập thư mục weather-ui



Cài đặt thư viện và chạy:



&#x20; - npm install

&#x20; - npm run dev


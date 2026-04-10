import { useState } from "react";
export default function SearchWeather({ onSearch, isLoading }) {
  const [city, setCity] = useState("");

  const handleSubmit = (e) => {
    e.preventDefault();
    if (city.trim()) {
      onSearch(city.trim());
    }
  };

  return (
    <form onSubmit={handleSubmit} className="mb-4">
      <div className="input-group input-group-lg shadow-sm">
        <input
          type="text"
          className="form-control"
          placeholder="Nhập tên thành phố (vd: Hanoi, Paris)..."
          value={city}
          onChange={(e) => setCity(e.target.value)}
          disabled={isLoading}
        />
        <button
          className="btn btn-primary px-4"
          type="submit"
          disabled={isLoading}
        >
          {isLoading ? "Đang tìm..." : "Tra cứu"}
        </button>
      </div>
    </form>
  );
}

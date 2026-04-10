export default function DetailWeather({ weather }) {
  if (!weather) return null;

  return (
    <div className="card shadow-sm border-0 bg-light">
      <div className="card-body text-center p-5">
        <h2 className="card-title display-5 fw-bold text-dark mb-1">
          {weather.cityName}
        </h2>
        <p className="text-muted mb-4 fs-5">{weather.description}</p>

        <div className="display-1 fw-bold text-primary mb-4">
          {weather.temperature}°C
        </div>

        <div className="row text-muted fs-5">
          <div className="col-6 border-end">
            <div>Độ ẩm</div>
            <div className="fw-bold text-dark">{weather.humidity}%</div>
          </div>
          <div className="col-6">
            <div>Sức gió</div>
            <div className="fw-bold text-dark">{weather.windSpeed} km/h</div>
          </div>
        </div>
      </div>
    </div>
  );
}

package cnam.project.weather.Model;

public class FavoritesModel {

    private String weatherState;
    private String location;

    private String temperature;
    private String humidity;
    private String index;
    private String windPressure;

    public FavoritesModel(String weatherState, String location, String temperature, String humidity, String index, String windPressure) {
        this.weatherState = weatherState;
        this.location = location;
        this.temperature = temperature;
        this.humidity = humidity;
        this.index = index;
        this.windPressure = windPressure;
    }

    public String getWeatherState() {
        return weatherState;
    }

    public void setWeatherState(String weatherState) {
        this.weatherState = weatherState;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getWindPressure() {
        return windPressure;
    }

    public void setWindPressure(String windPressure) {
        this.windPressure = windPressure;
    }
}

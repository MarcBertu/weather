package cnam.project.weather.Model;

public class ForeCastModel {

    private String date;
    private String temperature;
    private Object image;

    public ForeCastModel(String date, String temperature, Object image) {
        this.date = date;
        this.temperature = temperature;
        this.image = image;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public Object getImage() {
        return image;
    }

    public void setImage(Object image) {
        this.image = image;
    }
}

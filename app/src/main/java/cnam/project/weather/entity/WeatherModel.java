package cnam.project.weather.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WeatherModel {

    private float latitude;  //Reims 49.27
    private float longitude; //Reims 4.03

    private String unit_temp;

    private float current_temp;
    private float current_windspeed;
    private int current_winddirection;
    private short current_weathercode;
    private Date current_time;

    private List<Date> hourly_time = new ArrayList<Date>();
    private List<Float> hourly_temp = new ArrayList<Float>();
    private List<Integer> hourly_weathercode = new ArrayList<Integer>();

    public WeatherModel(float latitude, float longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public String getUnit_temp() {
        return unit_temp;
    }

    public float getCurrent_temp() {
        return current_temp;
    }

    public float getCurrent_windspeed() {
        return current_windspeed;
    }

    public int getCurrent_winddirection() {
        return current_winddirection;
    }

    public short getCurrent_weathercode() {
        return current_weathercode;
    }

    public Date getCurrent_time() {
        return current_time;
    }

    public List<Date> getHourly_time() {
        return hourly_time;
    }

    public List<Float> getHourly_temp() {
        return hourly_temp;
    }

    public List<Integer> getHourly_weathercode() {
        return hourly_weathercode;
    }

    public void setUnit_temp(String unit_temp) {
        this.unit_temp = unit_temp;
    }

    public void setCurrent_temp(float current_temp) {
        this.current_temp = current_temp;
    }

    public void setCurrent_windspeed(float current_windspeed) {
        this.current_windspeed = current_windspeed;
    }

    public void setCurrent_winddirection(int current_winddirection) {
        this.current_winddirection = current_winddirection;
    }

    public void setCurrent_weathercode(short current_weathercode) {
        this.current_weathercode = current_weathercode;
    }

    public void setCurrent_time(Date current_time) {
        this.current_time = current_time;
    }

    @Override
    public String toString() {
        return "WeatherMaker{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                ", unit_temp='" + unit_temp + '\'' +
                ", current_temp=" + current_temp +
                ", current_windspeed=" + current_windspeed +
                ", current_winddirection=" + current_winddirection +
                ", current_weathercode=" + current_weathercode +
                '}';
    }
}

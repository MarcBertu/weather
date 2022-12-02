package cnam.project.weather.utils;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import cnam.project.weather.R;

public enum WMOUtils {

    CLEAR_SKY(new Integer[] {0}, R.drawable.icon_sun, R.drawable.icon_moon),
    CLOUDY(new Integer[] {1, 2}, R.drawable.icon_cloud_sun, R.drawable.icon_cloud_moon),
    OVERCAST(new Integer[] {3}, R.drawable.icon_cloud),
    FOG(new Integer[] {45, 48}, R.drawable.icon_fog),
    DRIZZLE(new Integer[] {51, 53, 55, 56, 57}, R.drawable.icon_small_rain),
    RAIN(new Integer[] {61, 63, 65, 80, 81, 82}, R.drawable.icon_rain),
    FREEZING_RAIN(new Integer[] {66, 67}, R.drawable.icon_snow_rain),
    SNOW_FALL(new Integer[] {71, 73, 75, 77}, R.drawable.icon_snow),
    SNOW_SHOWERS(new Integer[] {85, 86}, R.drawable.icon_storm_snow),
    THUNDERSTORM(new Integer[] {95, 96, 99}, R.drawable.icon_thunderstorm);

    private List<Integer> codes;
    private int day_img;
    private int night_img;

    WMOUtils(Integer[] codes, int day_img, int night_img) {
        this.codes = Arrays.asList(codes);
        this.day_img = day_img;
        this.night_img = night_img;
    }

    WMOUtils(Integer[] codes, int img) {
        this.codes = Arrays.asList(codes);
        this.day_img = img;
        this.night_img = img;
    }

    public int getImage(int code, Date date) {
        for (WMOUtils en : values()) {
            if (en.codes.contains(code)) {
                SimpleDateFormat formater = new SimpleDateFormat("HH");
                int hours = Integer.parseInt(formater.format(date));
                if (hours > 18 || hours < 6) {
                    return this.night_img;
                } else {
                    return this.day_img;
                }
            }
        }

        return R.drawable.icon_error;
    }



}

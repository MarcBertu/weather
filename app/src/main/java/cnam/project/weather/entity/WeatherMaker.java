package cnam.project.weather.entity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import cnam.project.weather.databinding.ActivityStartingBinding;
import cnam.project.weather.tabItem.StartingActivity;
import cnam.project.weather.utils.Constant;

public class WeatherMaker {

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

    public WeatherMaker(float latitude, float longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public void fetch() {
        String url = String.format(Constant.API_URL, String.valueOf(latitude), String.valueOf(longitude));
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    StringBuilder jsonTxt = new StringBuilder();

                    URL oracle = new URL(url);
                    URLConnection yc = oracle.openConnection();
                    BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
                    String inputLine;
                    while ((inputLine = in.readLine()) != null)
                        jsonTxt.append(inputLine);
                    in.close();

                    JSONObject skr = new JSONObject(jsonTxt.toString());

                    try {
                        unit_temp = skr.getJSONObject("hourly_units").getString("temperature_2m");

                        JSONObject current = skr.getJSONObject("current_weather");
                        current_windspeed = current.getInt("windspeed");
                        current_winddirection = current.getInt("winddirection");
                        current_weathercode = (short) current.getInt("weathercode");
//                        current_time = new Date(current.getString("time"));
                        current_temp = current.getInt("temperature");

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                } catch (IOException | JSONException e) {
                    e.printStackTrace();
                }
            }
        });




//        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
//            @Override
//            public void onResponse(JSONObject response) {
//                try {
//                    unit_temp = response.getJSONObject("hourly-unit").getString("temperature_2m");
//
//                    JSONObject current = response.getJSONObject("current_weather");
//                    current_windspeed = current.getInt("windspeed");
//                    current_winddirection = current.getInt("winddirection");
//                    current_weathercode = (short) current.getInt("weathercode");
//                    current_time = new Date(current.getString("time"));
//
//
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//
////                    private List<Date> hourly_time = new ArrayList<Date>();
////                    private List<Float> hourly_temp = new ArrayList<Float>();
////                    private List<Integer> hourly_weathercode = new ArrayList<Integer>();
//            }
//        }, new Response.ErrorListener() {
//
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                // TODO: Handle error
//
//            }
//        });

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

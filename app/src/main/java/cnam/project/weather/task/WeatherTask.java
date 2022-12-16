package cnam.project.weather.task;

import android.app.ProgressDialog;
import android.os.AsyncTask;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import cnam.project.weather.entity.WeatherModel;
import cnam.project.weather.utils.Constant;

public class WeatherTask extends AsyncTask {

    public interface WeatherTaskInterface {
        void success(WeatherModel model);
        void failed();
    }

private float longitude;
private float latitude;

private WeatherTaskInterface delegate = null;

    public WeatherTask(WeatherTaskInterface delegate) {
        this.delegate = delegate;
    }

    @Override
    protected Object doInBackground(Object... objects) {
        JSONObject skr = null;

        try {
            String url = String.format(Constant.API_URL, String.valueOf(objects[0]), String.valueOf(objects[1]));

            StringBuilder jsonTxt = new StringBuilder();

            URL oracle = new URL(url);
            URLConnection yc = oracle.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null)
                jsonTxt.append(inputLine);
            in.close();

            skr = new JSONObject(jsonTxt.toString());

        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }

        return skr;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);

        JSONObject skr = (JSONObject) o;

        WeatherModel model = new WeatherModel(longitude, latitude);

        try {
            model.setUnit_temp(skr.getJSONObject("hourly_units").getString("temperature_2m"));

            JSONObject current = skr.getJSONObject("current_weather");
            model.setCurrent_windspeed(current.getInt("windspeed"));
            model.setCurrent_winddirection(current.getInt("winddirection"));
            model.setCurrent_weathercode((short) current.getInt("weathercode"));
//                        current_time = new Date(current.getString("time"));
            model.setCurrent_temp(current.getInt("temperature"));

        } catch (JSONException e) {
            e.printStackTrace();
        }

        delegate.success(model);

    }
}


package cnam.project.weather.tabItem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import cnam.project.weather.databinding.ActivityStartingBinding;
import cnam.project.weather.entity.WeatherModel;
import cnam.project.weather.task.WeatherTask;

public class StartingActivity extends AppCompatActivity implements WeatherTask.WeatherTaskInterface {

    private ActivityStartingBinding binding;

    private WeatherModel entity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityStartingBinding.inflate(getLayoutInflater());

        this.entity = new WeatherModel(49.27F, 4.03F);

        this.fetchMeteo();

        setContentView(binding.getRoot());
    }

    private void fetchMeteo() {

        WeatherTask task = new WeatherTask(this);
        task.execute(49.27F, 4.03F);


//        try {
//            this.entity.fetch();
//        } catch ( Exception | Error e) {
//            e.printStackTrace();
//        }
//        finally {
//            Log.d("debug_entity", this.entity.toString());
//            this.updateUI();
//        }

    }

    @Override
    public void success(WeatherModel model) {
        binding.tempValueText.setText( model.getCurrent_temp() + model.getUnit_temp() );
        binding.pressureValueText.setText(model.getCurrent_windspeed() + "km/h");
    }

    @Override
    public void failed() {

    }
}
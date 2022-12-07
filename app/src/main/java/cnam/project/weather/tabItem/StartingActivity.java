package cnam.project.weather.tabItem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import cnam.project.weather.databinding.ActivityStartingBinding;
import cnam.project.weather.entity.WeatherModel;
import cnam.project.weather.task.WeatherTask;

public class StartingActivity extends AppCompatActivity {

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

        WeatherTask task = new WeatherTask();
        task.execute(49.27F, 4.03F);


        try {
            this.entity.fetch();
        } catch ( Exception | Error e) {
            e.printStackTrace();
        }
        finally {
            Log.d("debug_entity", this.entity.toString());
            this.updateUI();
        }

    }

    public void updateUI() {
        binding.tempValueText.setText( entity.getCurrent_temp() + entity.getUnit_temp() );
        binding.pressureValueText.setText(entity.getCurrent_windspeed() + "mp/h");
    }
}
package cnam.project.weather;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;

import cnam.project.weather.databinding.ActivityMainBinding;
import cnam.project.weather.tabItem.StartingActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        cnam.project.weather.databinding.ActivityMainBinding binding = ActivityMainBinding.inflate(LayoutInflater.from(this));

        ProgressBar progressBar = binding.progressBar;

        progressBar.setVisibility(View.VISIBLE);

        final Handler handler = new Handler();
        handler.postDelayed(() -> startActivity( new Intent( getApplicationContext(), StartingActivity.class)), 1500);

        setContentView(R.layout.activity_main);

    }
}
package cnam.project.weather;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;

import cnam.project.weather.databinding.LaunchLayoutBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        cnam.project.weather.databinding.LaunchLayoutBinding binding = LaunchLayoutBinding.inflate(LayoutInflater.from(this));

        ProgressBar progressBar = binding.progressBar;

        progressBar.setVisibility(View.VISIBLE);

        final Handler handler = new Handler();
        handler.postDelayed(() -> startActivity( new Intent( getApplicationContext(), StartingActivity.class)), 1500);

        setContentView(R.layout.launch_layout);

    }
}
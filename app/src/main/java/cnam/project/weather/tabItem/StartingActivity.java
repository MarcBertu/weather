package cnam.project.weather.tabItem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import cnam.project.weather.databinding.ActivityStartingBinding;

public class StartingActivity extends AppCompatActivity {

    private ActivityStartingBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityStartingBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());
    }
}
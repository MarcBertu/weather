package cnam.project.weather;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

import cnam.project.weather.databinding.DetailsLayoutBinding;

public class DetailsWeatherActivity extends AppCompatActivity {

    public DetailsWeatherActivity() {
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DetailsLayoutBinding binding = DetailsLayoutBinding.inflate(getLayoutInflater());

        Objects.requireNonNull(getSupportActionBar()).setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.custom_action_bar);
        View view = getSupportActionBar().getCustomView();

        view.findViewById(R.id.custom_action_bar_drawer).setOnClickListener( c -> finish());

        TextView textView = view.findViewById(R.id.custom_action_bar_title);
        textView.setText("Reims, France");

        setContentView(binding.getRoot());
    }
}

package cnam.project.weather;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

import java.util.Objects;

import cnam.project.weather.databinding.DetailsLayoutBinding;

public class DetailsWeatherActivity extends AppCompatActivity {

    private DetailsLayoutBinding binding;

    public DetailsWeatherActivity() {
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DetailsLayoutBinding.inflate(getLayoutInflater());

        Objects.requireNonNull(getSupportActionBar()).setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.custom_action_bar_details);
        View view = getSupportActionBar().getCustomView();

        view.findViewById(R.id.custom_action_bar_details_back).setOnClickListener( c -> finish());

        TextView textView = view.findViewById(R.id.custom_action_bar_details_title);
        textView.setText("Reims, France");

        setContentView(binding.getRoot());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.hamburger_menu_details, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if( id == R.id.details_add_to_favorite ) {
            Snackbar.make( binding.getRoot(), "Cette destination a bien été ajouter à vos favoris", Snackbar.LENGTH_SHORT ).show();
        }

        return super.onOptionsItemSelected(item);
    }
}

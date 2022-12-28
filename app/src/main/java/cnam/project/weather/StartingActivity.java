package cnam.project.weather;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import java.util.Objects;

import cnam.project.weather.databinding.MainLayoutBinding;

public class StartingActivity extends AppCompatActivity {

    private MainLayoutBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = MainLayoutBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        NavigationView navigationView = binding.navView;

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupWithNavController(navigationView, navController);

        Objects.requireNonNull(getSupportActionBar()).setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.custom_action_bar);
        View view = getSupportActionBar().getCustomView();

        view.findViewById(R.id.custom_action_bar_drawer).setOnClickListener( c -> binding.drawerLayout.open() );

        TextView textView = view.findViewById(R.id.custom_action_bar_title);

        textView.setText(R.string.menu_home);

        binding.drawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {

            }

            @Override
            public void onDrawerOpened(@NonNull View drawerView) {

            }

            @Override
            public void onDrawerClosed(@NonNull View drawerView) {

            }

            @Override
            public void onDrawerStateChanged(int newState) {
                MenuItem item = navigationView.getCheckedItem();

                assert item != null;

                if( item.getItemId() == R.id.nav_home) {
                    textView.setText(R.string.menu_home);
                }
                else if( item.getItemId() == R.id.nav_setting ) {
                    textView.setText(R.string.menu_settings);
                }
            }
        });
    }

}
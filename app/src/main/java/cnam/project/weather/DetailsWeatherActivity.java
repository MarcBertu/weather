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
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.Objects;

import cnam.project.weather.Adapter.DetailsForecastFragmentAdapter;
import cnam.project.weather.Adapter.ForeCastAdapter;
import cnam.project.weather.databinding.DetailsLayoutBinding;
import cnam.project.weather.entity.WeatherModel;
import cnam.project.weather.task.WeatherTask;

public class DetailsWeatherActivity extends AppCompatActivity implements WeatherTask.WeatherTaskInterface {

    private DetailsLayoutBinding binding;

    private WeatherModel entity;

    private final int[] strings = {
            R.string.details_viewpager_state_past,
            R.string.details_viewpager_state_present,
            R.string.details_viewpager_state_future
    };

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
        textView.setText(R.string.info_details_text);

        // Tablayout part

        TabLayout tabLayout = binding.detailsTablayout;
        ViewPager2 viewPager2 = binding.detailsViewpager2;

        DetailsForecastFragmentAdapter adapter = new DetailsForecastFragmentAdapter(getSupportFragmentManager(), getLifecycle());

        viewPager2.setAdapter(adapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                tab.setCustomView(null);
                tab.setCustomView( getView(tab.getPosition(), true) );
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tab.setCustomView(null);
                tab.setCustomView( getView(tab.getPosition(), false) );
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                //
            }
        });

        new TabLayoutMediator(tabLayout, viewPager2, (tab, position) -> {
        }).attach();

        for( int i =0; i < tabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            assert tab != null;
            tab.setCustomView(null);
            tab.setCustomView(getView(tab.getPosition(), false));
        }

        tabLayout.selectTab(tabLayout.getTabAt(1));

        this.entity = new WeatherModel(49.27F, 4.03F);

        this.fetchMeteo();

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
            Snackbar.make( binding.getRoot(), "Cette destination a bien ??t?? ajouter ?? vos favoris", Snackbar.LENGTH_SHORT ).show();
        }

        return super.onOptionsItemSelected(item);
    }

    private void fetchMeteo() {

        try {
            WeatherTask task = new WeatherTask(this);
            task.execute(49.27F, 4.03F);
        } catch ( Exception | Error throwable) { throwable.printStackTrace(); }


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

    private View getView( int position, boolean selected) {
        View view;
        if( selected) {
            view = View.inflate(getApplicationContext(), R.layout.custom_tablayout_item_selected, null);
        }
        else {
            view = View.inflate(getApplicationContext(), R.layout.custom_tablayout_item, null);
        }

        TextView textView = view.findViewById(R.id.tablayout_item_text);
        textView.setText(strings[position]);

        return view;
    }
}

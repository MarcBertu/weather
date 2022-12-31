package cnam.project.weather.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import cnam.project.weather.Controller.DetailsForecastFragment;

public class DetailsForecastFragmentAdapter extends FragmentStateAdapter {

    public DetailsForecastFragmentAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return new DetailsForecastFragment();
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}

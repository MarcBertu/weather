package cnam.project.weather.Controller;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Objects;

import cnam.project.weather.Adapter.FavoritesAdapter;
import cnam.project.weather.Adapter.ForeCastAdapter;
import cnam.project.weather.R;
import cnam.project.weather.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private FragmentHomeBinding binding;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            // TODO: Rename and change types of parameters
            String mParam1 = getArguments().getString(ARG_PARAM1);
            String mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView (@NonNull LayoutInflater inflater,
                              ViewGroup container,
                              Bundle savedInstanceState) {

        binding = FragmentHomeBinding.inflate(inflater, container, false);

        RecyclerView recyclerViewFavorite = binding.favoriteRecyler;
        FavoritesAdapter favoritesAdapter = new FavoritesAdapter(requireContext(),new ArrayList<>());
        recyclerViewFavorite.setAdapter(favoritesAdapter);

        LinearLayoutManager favoriteManager = new LinearLayoutManager(requireContext());
        favoriteManager.setOrientation(RecyclerView.HORIZONTAL);
        recyclerViewFavorite.setLayoutManager(favoriteManager);

        DividerItemDecoration dividerItemDecorationFavorite = new DividerItemDecoration(requireContext(), DividerItemDecoration.HORIZONTAL);
        dividerItemDecorationFavorite.setDrawable(Objects.requireNonNull(ResourcesCompat.getDrawable(getResources(), R.drawable.divider_horizontal_8, null)));
        recyclerViewFavorite.addItemDecoration(dividerItemDecorationFavorite);




        RecyclerView recyclerViewForeCast = binding.forecastRecycler;
        ForeCastAdapter foreCastAdapter = new ForeCastAdapter();
        recyclerViewForeCast.setAdapter(foreCastAdapter);

        LinearLayoutManager forecastManager = new LinearLayoutManager(requireContext());
        forecastManager.setOrientation(RecyclerView.HORIZONTAL);
        recyclerViewForeCast.setLayoutManager(forecastManager);

        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
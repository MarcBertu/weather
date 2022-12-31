package cnam.project.weather.Controller;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cnam.project.weather.Adapter.ForeCastAdapter;
import cnam.project.weather.R;
import cnam.project.weather.databinding.DetailsForecastFragmentBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DetailsForecastFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DetailsForecastFragment extends Fragment {

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DetailsForecastFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DetailsForecastFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DetailsForecastFragment newInstance(String param1, String param2) {
        DetailsForecastFragment fragment = new DetailsForecastFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        DetailsForecastFragmentBinding binding = DetailsForecastFragmentBinding.inflate(inflater);

        ForeCastAdapter adapter = new ForeCastAdapter();
        binding.detailForecastRecycler.setAdapter(adapter);

        LinearLayoutManager detailsForecastManager = new LinearLayoutManager(requireContext());
        detailsForecastManager.setOrientation(RecyclerView.HORIZONTAL);
        binding.detailForecastRecycler.setLayoutManager(detailsForecastManager);

        return binding.getRoot();
    }
}
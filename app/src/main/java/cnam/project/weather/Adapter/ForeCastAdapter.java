package cnam.project.weather.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import cnam.project.weather.R;
import cnam.project.weather.ViewHolder.ForeCastViewHolder;

public class ForeCastAdapter extends RecyclerView.Adapter<ForeCastViewHolder> {

    public ForeCastAdapter() {
    }

    @NonNull
    @Override
    public ForeCastViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.forecast_item_layout,parent,false);

        return new ForeCastViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ForeCastViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 5;
    }

}

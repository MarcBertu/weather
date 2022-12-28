package cnam.project.weather.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import cnam.project.weather.DetailsWeatherActivity;
import cnam.project.weather.Model.FavoritesModel;
import cnam.project.weather.R;
import cnam.project.weather.ViewHolder.FavoritesViewHolder;

public class FavoritesAdapter extends RecyclerView.Adapter<FavoritesViewHolder> {

    private ArrayList<FavoritesModel> favoritesList;
    private Context context;

    public FavoritesAdapter( Context context, ArrayList<FavoritesModel> liste ) {
        this.context = context;
        this.favoritesList = liste;
    }

    @NonNull
    @Override
    public FavoritesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                                    .inflate(R.layout.favorite_item_layout, parent, false);

        return new FavoritesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FavoritesViewHolder holder, int position) {
        holder.getCardView().setOnClickListener( c -> {
            Intent intent = new Intent(context, DetailsWeatherActivity.class);
            context.startActivity(intent);
        } );
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public ArrayList<FavoritesModel> getFavoritesList() {
        return favoritesList;
    }

    public void setFavoritesList(ArrayList<FavoritesModel> favoritesList) {
        this.favoritesList = favoritesList;
    }
}

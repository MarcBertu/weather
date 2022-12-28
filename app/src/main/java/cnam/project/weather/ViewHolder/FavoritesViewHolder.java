package cnam.project.weather.ViewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import cnam.project.weather.Model.FavoritesModel;
import cnam.project.weather.R;

public class FavoritesViewHolder extends RecyclerView.ViewHolder {

    private final CardView cardView;
    private final ImageView imageView;
    private final TextView status;
    private final TextView location;

    public FavoritesViewHolder(@NonNull View itemView) {
        super(itemView);
        this.cardView = itemView.findViewById(R.id.recycler_item_container);
        this.imageView = itemView.findViewById(R.id.recycler_item_image);
        this.status = itemView.findViewById(R.id.recycler_item_weather_state);
        this.location = itemView.findViewById(R.id.recycler_item_location);
    }

    public CardView getCardView() {
        return cardView;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public TextView getStatus() {
        return status;
    }

    public TextView getLocation() {
        return location;
    }
}

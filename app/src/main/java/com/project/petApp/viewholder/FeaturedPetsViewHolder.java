package com.project.petApp.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.project.petApp.R;

public class FeaturedPetsViewHolder extends RecyclerView.ViewHolder {
    public ImageView featured_pets_picture;
    public RelativeLayout featured_pets_parent;
    public TextView featured_pets_title, featured_pets_country, featured_pets_price;

    public FeaturedPetsViewHolder(@NonNull View itemView) {
        super(itemView);
        featured_pets_picture = itemView.findViewById(R.id.item_featured_pets_picture);
        featured_pets_parent = itemView.findViewById(R.id.item_featured_plants_parent);
        featured_pets_title = itemView.findViewById(R.id.item_featured_pets_title);
        featured_pets_country = itemView.findViewById(R.id.item_featured_pets_country);
        featured_pets_price = itemView.findViewById(R.id.item_featured_pets_price);
    }
}

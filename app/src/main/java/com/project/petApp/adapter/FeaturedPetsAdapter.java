package com.project.petApp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.project.petApp.R;
import com.project.petApp.menu.home.HomeDetailActivity;
import com.project.petApp.model.Pet;
import com.project.petApp.viewholder.FeaturedPetsViewHolder;

import java.util.ArrayList;

public class FeaturedPetsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final Context context;
    private final ArrayList<Pet> pets;

    public FeaturedPetsAdapter(Context context, ArrayList<Pet> pets) {
        this.context = context;
        this.pets = pets;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.featured_pets_item, parent, false);
        return new FeaturedPetsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        FeaturedPetsViewHolder temp = ((FeaturedPetsViewHolder) holder);
        setImage(temp.featured_pets_picture, pets.get(position).getPetPicture());
        setTitle(temp.featured_pets_title, pets.get(position).getPetTitle());
        setCountry(temp.featured_pets_country, pets.get(position).getPetCountry());
        setPrice(temp.featured_pets_price, pets.get(position).getPetPrice());
        setOnClick(temp.featured_pets_parent, pets.get(position).getPetTitle(), pets.get(position).getPetCountry(), pets.get(position).getPetPrice(), pets.get(position).getPetPicture());
    }

    private void setImage(final ImageView imageView, int image) {
        imageView.setBackgroundResource(image);
//        Picasso.get().load(imageURL).fit().centerCrop().into(imageView, new Callback() {
//            @Override
//            public void onSuccess() {
//
//            }
//
//            @Override
//            public void onError(Exception e) {
//                imageView.setBackgroundResource(R.drawable.ic_launcher_background);
//            }
//        });
    }

    private void setOnClick(RelativeLayout button, String name, String country, String price, int image) {
        Intent intent = new Intent(context, HomeDetailActivity.class);
        intent.putExtra("name", name);
        intent.putExtra("country", country);
        intent.putExtra("price", price);
        intent.putExtra("image", image);
        button.setOnClickListener(view -> context.startActivity(intent));
    }

    private void setTitle(TextView textView, String plantTitle) {
        textView.setText(plantTitle);
    }

    private void setCountry(TextView textView, String plantCountry) {
        textView.setText(plantCountry);
    }

    private void setPrice(TextView textView, String plantPrice) {
        textView.setText(plantPrice);
    }

    @Override
    public int getItemCount() {
        return pets.size();
    }
}

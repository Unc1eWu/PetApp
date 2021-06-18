package com.project.petApp.menu.home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;

import com.project.petApp.R;
import com.project.petApp.adapter.HomeDetailAdapter;
import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator;

import java.util.ArrayList;
import java.util.List;

public class HomeDetailActivity extends AppCompatActivity {
    private ImageButton buttonBack;
    private final List<Integer> imagesList = new ArrayList<>();
    private ViewPager viewPager;
    private HomeDetailAdapter adapter;
    private WormDotsIndicator dotsIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        hideStatusBar();
        setContentView(R.layout.activity_home_detail);
        String name = getIntent().getStringExtra("name");
        String country = getIntent().getStringExtra("country");
        String price = getIntent().getStringExtra("price");
        int image = getIntent().getIntExtra("image", 0);
        Log.d("namename", name+" "+country+" "+price+" "+image);
        imagesList.add(image);
        imagesList.add(image);
        imagesList.add(image);
        imagesList.add(image);
        imagesList.add(image);
        setViews();
        initViews();
        TextView text_country = findViewById(R.id.text_country);
        text_country.setText(country);
        TextView text_price = findViewById(R.id.text_price);
        text_price.setText(price);
        TextView detail_plant_title = findViewById(R.id.detail_plant_title);
        detail_plant_title.setText(name);
        //detail_plant_title
        adapter = new HomeDetailAdapter(getApplicationContext(), getLayoutInflater(), imagesList);
        viewPager.setAdapter(adapter);

        dotsIndicator = findViewById(R.id.layout_dot);
        dotsIndicator.setViewPager(viewPager);

        adapter.notifyDataSetChanged();
    }

    @SuppressLint("ObsoleteSdkInt")
    private void hideStatusBar() {
        try {
            if (Build.VERSION.SDK_INT >= 19) {
                getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
                getWindow().getDecorView().setSystemUiVisibility(3328);
            } else {
                requestWindowFeature(Window.FEATURE_NO_TITLE);
                getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setViews() {
        buttonBack  = findViewById(R.id.button_back);
        viewPager   = findViewById(R.id.view_pager);
    }

    private void initViews() {
        buttonBack.setOnClickListener(view -> onBackPressed());
    }

//    private void initData() {
//        /**Add Images List**/
////        imagesList.add(R.drawable.detail_home_picture_3);
////        imagesList.add(R.drawable.detail_home_picture_4);
////        imagesList.add(R.drawable.detail_home_picture_5);
////        imagesList.add(R.drawable.detail_home_picture_1);
////        imagesList.add(R.drawable.detail_home_picture_2);
//
//
//    }
}
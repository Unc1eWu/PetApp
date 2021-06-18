package com.project.petApp.menu.home;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.project.petApp.R;
import com.project.petApp.adapter.GroupAdapter;
import com.project.petApp.model.Group;
import com.project.petApp.model.Pet;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    private Context mContext;
    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private GroupAdapter groupAdapter;
    private ArrayList<Group> groups;
    private ArrayList<Pet> featured_pets;
    private ArrayList<Pet> recommended;
    //todo 0. If you want to add more types of objects, you can easily do so. Check "todo list" (I added it step by step)

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setAdapterType(view);
        setAdapter();
    }

    private void initGroupData() {
        groups = new ArrayList<>();
        groups.add(new Group("推荐", "更多"));
        groups.add(new Group("特色宠物", "更多"));
    }

    private void initPetData() {
        featured_pets = new ArrayList<>();
        recommended     = new ArrayList<>();

        featured_pets.add(new Pet("比熊犬", "地中海地区", "$300", R.drawable.bottom_img_1));
        featured_pets.add(new Pet("柯基犬", "英国", "$200", R.drawable.bottom_img_2));
        featured_pets.add(new Pet("迷你雪纳瑞", "德国", "$100", R.drawable.bottom_img_3));

        recommended.add(new Pet("边境牧羊犬", "苏格兰", "$600", R.drawable.bottom_img_4));
        recommended.add(new Pet("哈士奇", "俄罗斯", "$500", R.drawable.bottom_img_5));
        recommended.add(new Pet("柴犬", "日本", "$400", R.drawable.bottom_img_6));
        recommended.add(new Pet("金毛寻回犬", "苏俄", "$300", R.drawable.bottom_img_7));
        recommended.add(new Pet("阿拉斯加犬", "美国", "$200", R.drawable.bottom_img_8));
        recommended.add(new Pet("苏格兰牧羊犬", "苏格兰", "$100", R.drawable.bottom_img_9));
    }

    private void setAdapterType(View view) {
        recyclerView    = view.findViewById(R.id.recyclerView);
        layoutManager   = new LinearLayoutManager(mContext);
        recyclerView.setLayoutManager(layoutManager);
    }

    private void setAdapter() {
        initGroupData();
        initPetData();
        //todo 1. Add the new object to the parameter list.
        groupAdapter = new GroupAdapter(mContext, groups, featured_pets, recommended);
        recyclerView.setAdapter(groupAdapter);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mContext = context;
    }
}
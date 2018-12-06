package com.example.delllaptop.exercise3_demo2.adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.delllaptop.exercise3_demo2.R;
import com.example.delllaptop.exercise3_demo2.model.Category;

import java.util.ArrayList;

/**
 * Created by DELL LAPTOP on 04/29/2018.
 */

public class CategoriesAdapter extends ArrayAdapter<Category>{

    private Context context;
    private int resource;
    private ArrayList<Category> arrCategory;


    public CategoriesAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull ArrayList<Category> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.arrCategory = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.category_layout,parent,false);
        TextView name = (TextView) convertView.findViewById(R.id.tv_name);

        Category category = arrCategory.get(position);
        name.setText(category.getName());
        return  convertView;
    }
}

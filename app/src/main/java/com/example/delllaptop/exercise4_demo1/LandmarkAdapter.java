package com.example.delllaptop.exercise4_demo1;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.delllaptop.exercise4_demo1.model.LandmarkBuilding;

import java.util.ArrayList;

/**
 * Created by DELL LAPTOP on 04/30/2018.
 */

public class LandmarkAdapter  extends ArrayAdapter<LandmarkBuilding>{
    private Context context;
    private int resource;
    private ArrayList<LandmarkBuilding> landmarkBuildings;

    public LandmarkAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull ArrayList<LandmarkBuilding> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.landmarkBuildings = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.item_layout,parent,false);
        TextView tvName = (TextView) convertView.findViewById(R.id.tv_name);

        LandmarkBuilding landmarkBuilding = landmarkBuildings.get(position);
        tvName.setText(landmarkBuilding.getName());
        return convertView;
    }
}

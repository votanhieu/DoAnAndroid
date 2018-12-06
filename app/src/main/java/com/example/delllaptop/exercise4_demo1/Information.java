package com.example.delllaptop.exercise4_demo1;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.delllaptop.exercise4_demo1.model.LandmarkBuilding;

public class Information extends AppCompatActivity {

    TextView name;
    Button btnMapIt;
    Button btnMoreInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        name = (TextView) findViewById(R.id.tv_info_name);
        btnMapIt = (Button) findViewById(R.id.btn_map_it);
        btnMoreInfo = (Button) findViewById(R.id.btn_more_info);
        final Intent intent = getIntent();
        final LandmarkBuilding landmarkBuilding = (LandmarkBuilding) intent.getSerializableExtra("landmark");

        name.setText(landmarkBuilding.getName());



        btnMoreInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse(landmarkBuilding.getWebsite());
                Intent intentView = new Intent(Intent.ACTION_VIEW,uri);
                try
                {
                    startActivity(intentView);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        });

        btnMapIt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentView = new Intent(Information.this, MapsActivity.class);
                intentView.putExtra("name",landmarkBuilding.getName());
                intentView.putExtra("lat",landmarkBuilding.getLat());
                intentView.putExtra("lng", landmarkBuilding.getLng());
                startActivity(intentView);

            }
        });
    }
}

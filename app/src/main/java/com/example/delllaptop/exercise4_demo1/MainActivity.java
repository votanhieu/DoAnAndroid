package com.example.delllaptop.exercise4_demo1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.delllaptop.exercise4_demo1.model.LandmarkBuilding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvLandmark;
    ArrayList<LandmarkBuilding> landmarkBuildings;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        landmarkBuildings = getLandmarkBuildings();
        lvLandmark = (ListView) findViewById(R.id.lv_landmark);

        LandmarkAdapter adapter = new LandmarkAdapter(MainActivity.this,android.R.layout.simple_list_item_1,landmarkBuildings);
        lvLandmark.setAdapter(adapter);

       lvLandmark.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               Intent intent = new Intent(MainActivity.this, Information.class);
               LandmarkBuilding landmarkBuilding = (LandmarkBuilding) lvLandmark.getItemAtPosition(i);
               intent.putExtra("landmark",landmarkBuilding);
               startActivity(intent);
           }
       });

    }
    ArrayList<LandmarkBuilding> getLandmarkBuildings()
    {
        ArrayList<LandmarkBuilding> landmarkBuildings = new ArrayList<>();
        LandmarkBuilding l1 = new LandmarkBuilding("Terminal Tower", 41.497430, -81.694067 ,"http://towercitycenter.com");
        LandmarkBuilding l2 = new LandmarkBuilding("Superman House",41.512581, -81.594524,"http://lakeviewcemetery.com/garfield.php ");
        LandmarkBuilding l3 = new LandmarkBuilding("Soldiers’ and Sailors’ Monument",41.499701, -81.696090,"http://soldiersandsailors.com");
        LandmarkBuilding l4 = new LandmarkBuilding("Cleveland History Center",41.513594, -81.610796,"http://wrhs.org");
        LandmarkBuilding l5 = new LandmarkBuilding("Cod Submarine",41.509784, -81.690934,"http://usscod.org");


        landmarkBuildings.add(l1);
        landmarkBuildings.add(l2);
        landmarkBuildings.add(l3);
        landmarkBuildings.add(l5);
        landmarkBuildings.add(l4);
        return landmarkBuildings;
    }

}

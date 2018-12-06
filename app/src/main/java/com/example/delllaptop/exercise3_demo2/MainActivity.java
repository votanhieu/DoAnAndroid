package com.example.delllaptop.exercise3_demo2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.delllaptop.exercise3_demo2.adapter.CategoriesAdapter;
import com.example.delllaptop.exercise3_demo2.model.Category;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvCategories;
    ArrayList<Category> listCategories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvCategories = (ListView) findViewById(R.id.lv_category);
        listCategories = getCategories();
        CategoriesAdapter categoriesAdapter = new CategoriesAdapter(this,R.layout.category_layout,listCategories);
        lvCategories.setAdapter(categoriesAdapter);

        lvCategories.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Category category = (Category) lvCategories.getItemAtPosition(i);
                Intent intent = new Intent(MainActivity.this,ListByCatogery.class);
                intent.putExtra("name",category.getName());
                intent.putExtra("url",category.getUrl());
                startActivity(intent);
            }
        });
    }

    ArrayList<Category> getCategories()
    {
        ArrayList<Category> listCategories = new ArrayList<>();
        Category rss = new Category("RSS","https://www.bonappetit.com/feed/rss");
        listCategories.add(rss);
        Category healthyish = new Category("Healthy","https://www.bonappetit.com/feed/healthyish/rss");
        listCategories.add(healthyish);
        Category recipes = new Category("Recipes","https://www.bonappetit.com/feed/latest-recipes/rss");
        listCategories.add(recipes);
        Category latest = new Category("Latest", "https://www.bonappetit.com/feed/rss");
        listCategories.add(latest);
        Category articlesAndVenues = new Category("Origins", "https://www.bonappetit.com/feed/stories/rss");
        listCategories.add(articlesAndVenues);
        Category galleries = new Category("Galleries", "https://www.bonappetit.com/feed/galleries/rss");
        listCategories.add(galleries);
        Category tags = new Category("Tags", "https://www.bonappetit.com/feed/rss");
        listCategories.add(tags);

        return  listCategories;
    }
}

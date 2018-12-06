package com.example.delllaptop.exercise3_demo2;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class ListByCatogery extends AppCompatActivity {

    ListView lvByCategory;
    ArrayList<String> titles;
    ArrayList<String> links;
    String intentName;
    String intentUrl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_by_catogery);
        lvByCategory =(ListView) findViewById(R.id.lv_bycategory);
        titles = new ArrayList<String>();
        links = new ArrayList<String>();

        Intent intent = getIntent();
        intentName = intent.getStringExtra("name");
        intentUrl = intent.getStringExtra("url");

        lvByCategory.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String stringUrl = links.get(i);
                Uri uri = Uri.parse(stringUrl);
                Intent viewIntent = new Intent(ListByCatogery.this,WebViewActivity.class);
                viewIntent.putExtra("url",stringUrl);
                startActivity(viewIntent);
            }
        });
        new ProcessInBackground().execute();
    }
    public InputStream getInputStream (URL url)
    {
        try
        {
            return url.openConnection().getInputStream();
        }
        catch (IOException e)
        {
            return null;
        }
    }

    public class ProcessInBackground extends AsyncTask<Integer,Void,String>
    {
        Exception exception = null;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

        @Override
        protected String doInBackground(Integer... integers) {
            try
            {
                URL url = new URL(intentUrl);
                XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
                factory.setNamespaceAware(false);
                XmlPullParser xpp = factory.newPullParser();
                xpp.setInput(getInputStream(url), "UTF_8");
                boolean insideItem = false;
                int eventType = xpp.getEventType();
                while (eventType != XmlPullParser.END_DOCUMENT)
                {
                    if (eventType == XmlPullParser.START_TAG)
                    {
                        if(xpp.getName().equalsIgnoreCase("item"))
                        {
                            insideItem = true;
                        }
                        else if(xpp.getName().equalsIgnoreCase("title"))
                        {
                            if(insideItem)
                            {
                                titles.add(xpp.nextText());
                            }
                        }
                        else if(xpp.getName().equalsIgnoreCase("link"))
                        {
                            if(insideItem)
                            {
                                links.add((xpp.nextText()));
                            }
                        }
                    }
                    else if (eventType == XmlPullParser.END_TAG && xpp.getName().equalsIgnoreCase("item"))
                    {
                        insideItem = false;
                    }

                    eventType = xpp.next();
                }
            }
            catch (MalformedURLException e)
            {
                exception = e;
            }
            catch (IOException e )
            {
                exception = e;
            } catch (XmlPullParserException e) {
                exception = e;
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(ListByCatogery.this,
                    android.R.layout.simple_list_item_1, titles);
            lvByCategory.setAdapter(adapter);
        }
    }
}

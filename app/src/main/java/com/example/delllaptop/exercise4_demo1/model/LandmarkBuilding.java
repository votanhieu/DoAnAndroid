package com.example.delllaptop.exercise4_demo1.model;

import java.io.Serializable;

/**
 * Created by DELL LAPTOP on 04/30/2018.
 */

public class LandmarkBuilding implements Serializable{
    private String name;
    private String location;
    private double lat;
    private double lng;
    private String website;

    public LandmarkBuilding(String name, double lat, double lng, String website) {
        this.name = name;
        this.lat = lat;
        this.lng = lng;
        this.website = website;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }





    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}

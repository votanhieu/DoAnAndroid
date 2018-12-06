package com.example.delllaptop.exercise3_demo2.model;

/**
 * Created by DELL LAPTOP on 04/29/2018.
 */

public class Category {
    private String name;
    private String url;

    public Category() {
    }

    public Category(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

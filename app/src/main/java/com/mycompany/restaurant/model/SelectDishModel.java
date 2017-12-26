package com.mycompany.restaurant.model;

import android.graphics.drawable.Drawable;

import java.io.Serializable;

/**
 * Created by Lantiets on 24.12.2017.
 */

public class SelectDishModel implements Serializable {

    private int imageId;

    private String name;

    private int price;

    private int weight;

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}

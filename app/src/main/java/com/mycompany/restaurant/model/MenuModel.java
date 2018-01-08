package com.mycompany.restaurant.model;

import java.io.Serializable;
import java.util.ArrayList;

public class MenuModel implements Serializable {

    private int imageId;

    private String name;

    private ArrayList<SelectDishModel> selectDishModel;

    public ArrayList<SelectDishModel> getSelectDishModel() {
        return selectDishModel;
    }

    public void setSelectDishModel(ArrayList<SelectDishModel> selectDishModel) {
        this.selectDishModel = selectDishModel;
    }

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
}

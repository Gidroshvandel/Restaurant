package com.mycompany.restaurant.model;

import java.io.Serializable;
import java.util.ArrayList;

public class UserModel implements Serializable {

    private String street;

    private String apartment;

    private String building;

    private ArrayList<SelectDishModel> selectDishModel;

    public UserModel(String street, String apartment, String building, ArrayList<SelectDishModel> selectDishModel) {
        this.street = street;
        this.apartment = apartment;
        this.building = building;
        this.selectDishModel = selectDishModel;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public ArrayList<SelectDishModel> getSelectDishModel() {
        return selectDishModel;
    }

    public void setSelectDishModel(ArrayList<SelectDishModel> selectDishModel) {
        this.selectDishModel = selectDishModel;
    }
}

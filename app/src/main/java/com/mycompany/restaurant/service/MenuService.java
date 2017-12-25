package com.mycompany.restaurant.service;

import com.mycompany.restaurant.model.SelectDishModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface MenuService {
    @GET("/dataBase/selectDishModel.json")
    Call<ArrayList<SelectDishModel>> getDishModel();
}

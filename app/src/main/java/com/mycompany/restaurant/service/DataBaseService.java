package com.mycompany.restaurant.service;

import com.mycompany.restaurant.model.MenuModel;
import com.mycompany.restaurant.model.UserModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface DataBaseService {

    //Запросы к базе данных
    @GET("/dataBase/menuModel.json")
    Call<ArrayList<MenuModel>> getMenuModel();

    @PUT("/dataBase/{new}.json")
    Call<ArrayList<UserModel>> sendUserModel(@Path("new") String phone, @Body ArrayList<UserModel> userModels);

    @GET("/dataBase/{new}.json")
    Call<ArrayList<UserModel>> getUserModel(@Path("new") String phone);
}

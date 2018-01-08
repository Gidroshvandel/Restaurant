package com.mycompany.restaurant.service;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiService {

    //адрес сервера
    private static final String BASE_URL = "https://restaurant-e3401.firebaseio.com/";

    public static Retrofit getInstance(){
        return buildClient();
    }

    private static Retrofit buildClient(){

        //Логирование запросов
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);

        //Настройка взаимодействия с сервером
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build());

        return builder.build();
    }
}

package com.ClaVis.clavis.retrofit_util;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static ClientAPI clientAPI;
    private RetrofitClient(){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(" ").addConverterFactory(GsonConverterFactory.create()).build();
        clientAPI = retrofit.create(ClientAPI.class);
    }

    public static ClientAPI getClientAPI() {
        if (clientAPI == null){
            new RetrofitClient();}
        return clientAPI;
    }
}

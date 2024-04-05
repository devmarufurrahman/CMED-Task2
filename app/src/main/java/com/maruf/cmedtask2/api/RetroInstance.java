package com.maruf.cmedtask2.api;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroInstance {

    public static String baseurl="https://bdclean.winkytech.com/backend/api/";
    private static Retrofit retrofit;

    public static Retrofit getRetroClient()
    {
        if(retrofit==null)
        {
            retrofit= new Retrofit.Builder()
                    .baseUrl(baseurl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}

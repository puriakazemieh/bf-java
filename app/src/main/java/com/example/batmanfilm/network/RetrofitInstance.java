package com.example.batmanfilm.network;

import com.example.batmanfilm.helper.router;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

    public RetrofitInstance() {

    }

    private static Retrofit retrofit;


    public static Retrofit getInstance() {

        if (retrofit == null) {

            retrofit = new Retrofit.Builder()
                    .baseUrl(router.URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }
        return retrofit;
    }

}

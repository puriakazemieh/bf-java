package com.example.batmanfilm.network;

import com.example.batmanfilm.model.DetailModel;
import com.example.batmanfilm.model.MoveDataModel;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIService {

    @GET(".")
    Single<MoveDataModel> getmovie(@Query("apikey") String apikey, @Query("s") String s);

    @GET(".")
    Single<DetailModel> getdetailmovie(@Query("apikey") String apikey, @Query("i") String s);


}

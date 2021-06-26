package com.example.batmanfilm.viewmodel;

import com.example.batmanfilm.model.DetailModel;
import com.example.batmanfilm.model.MoveDataModel;
import com.example.batmanfilm.network.APIService;
import com.example.batmanfilm.network.ApiServiceProvider;

import io.reactivex.Single;

public class DetailViewModel {
    private APIService apiService = ApiServiceProvider.providerApiService();

    public Single<DetailModel> latestProduct(String i) {
        return apiService.getdetailmovie("3e974fca", i);
    }
}

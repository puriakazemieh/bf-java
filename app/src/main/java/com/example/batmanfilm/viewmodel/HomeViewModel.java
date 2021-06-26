package com.example.batmanfilm.viewmodel;

import com.example.batmanfilm.model.MoveDataModel;
import com.example.batmanfilm.network.APIService;
import com.example.batmanfilm.network.ApiServiceProvider;

import io.reactivex.Single;

public class HomeViewModel {
    private APIService apiService = ApiServiceProvider.providerApiService();

    public Single<MoveDataModel> latestProduct() {
        return apiService.getmovie("3e974fca","batman");
    }
}

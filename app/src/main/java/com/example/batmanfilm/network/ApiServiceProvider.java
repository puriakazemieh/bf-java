package com.example.batmanfilm.network;

public class ApiServiceProvider {
    private static APIService apiService;

    public static APIService providerApiService() {
        if (apiService == null) {
            apiService = RetrofitInstance.getInstance().create(APIService.class);
        }
        return apiService;
    }
}

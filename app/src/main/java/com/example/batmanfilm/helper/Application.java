package com.example.batmanfilm.helper;

import android.content.Context;

public class Application extends android.app.Application {
    private static Context context;

    public void onCreate() {
        super.onCreate();
        context=this;

    }

    public static Context getContext() {
        return context;
    }


}

package com.example.batmanfilm.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class isconnect {
    public static boolean isNetworkAvilable(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
       /* if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            Network network=connectivityManager.getActiveNetwork();
        }*/

        return networkInfo != null && networkInfo.isConnectedOrConnecting();
    }
}

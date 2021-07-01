package com.example.batmanfilm.helper;

import android.annotation.SuppressLint;
import android.util.Log;
import android.widget.Toast;

public class app {

    @SuppressLint("LongLogTag")
    public static void l(String message) {
        Log.e(router.TAG, message);
    }

    public static void t(String message) {
        Toast.makeText(Application.getContext(), message, Toast.LENGTH_LONG).show();
    }
}

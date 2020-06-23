package com.hands_on_android.dogviewerjava.network;

import com.hands_on_android.dogviewerjava.DogViewerConst;

import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

public class ServiceGenerator {
    private static ApiService SERVICE;

    private ServiceGenerator() {
        //Private constructor to prevent object creation
    }

    public static ApiService getService() {
        if (SERVICE == null) {
            initialize();
        }
        return SERVICE;
    }

    private static void initialize() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(DogViewerConst.BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create())
                .build();

        SERVICE = retrofit.create(ApiService.class);
    }
}

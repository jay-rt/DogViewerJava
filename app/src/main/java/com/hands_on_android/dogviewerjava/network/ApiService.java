package com.hands_on_android.dogviewerjava.network;

import com.hands_on_android.dogviewerjava.network.model.BreedList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("breeds/list/all")
    Call<BreedList> getBreedList();
}

package com.ahmad.mvvm_retrofit.network

import com.ahmad.mvvm_retrofit.model.Wisata
import retrofit2.Call
import retrofit2.http.GET

public interface ApiService {


    @GET("?action=findAll")
    fun wisata(): Call<Wisata>
}
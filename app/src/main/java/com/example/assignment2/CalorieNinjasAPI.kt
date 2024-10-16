package com.example.assignment2

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface CalorieNinjasApi{
    @GET("/v1/nutrition")
    fun getNutritionInfo(
        @Query("query") foodName: String,
        @Header("X-Api-Key") apiKey: String
    ): Call<NutritionResponse>
}

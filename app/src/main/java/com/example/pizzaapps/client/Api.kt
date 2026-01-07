package com.example.pizzaapps.client

import com.example.pizzaapps.response.account.LoginResponse
import com.example.pizzaapps.response.food.FoodResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface Api {
    @GET("food")
    fun getFood(): Call<ArrayList<FoodResponse>>


    @FormUrlEncoded
    @POST("account")
    fun postLogin(
        @Field("username") username:String,
        @Field("password") password:String
    ): Call<LoginResponse>


}
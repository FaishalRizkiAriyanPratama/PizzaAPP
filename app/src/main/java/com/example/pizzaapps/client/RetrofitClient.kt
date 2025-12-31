package com.example.pizzaapps.client


import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    const val BASE_URL = "http://10.24.2.37/rest_api3384/index.php/"

    val instance:Api by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory (GsonConverterFactory.create())
            .build();

        retrofit.create(Api::class.java)
    }
}
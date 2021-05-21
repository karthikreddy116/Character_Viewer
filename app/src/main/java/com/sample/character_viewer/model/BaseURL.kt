package com.sample.character_viewer.model
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object BaseURL {
    val BASE_URL = "http://api.duckduckgo.com"
    fun getClient(): RestAPI {
        val  retroClient: Retrofit = Retrofit.Builder()
             .baseUrl(BASE_URL)
             .addConverterFactory(GsonConverterFactory.create())
             .build()
        return retroClient.create(RestAPI::class.java);
    }
}
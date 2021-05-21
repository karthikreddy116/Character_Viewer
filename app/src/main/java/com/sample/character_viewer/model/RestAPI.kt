package com.sample.character_viewer.model

import retrofit2.Call
import retrofit2.http.*

interface RestAPI {
    @GET("/?")
    fun getEventListByMatch(@Query("q", encoded = true) query: String, @Query("format") format: String) :Call<Characters>
}
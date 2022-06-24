package com.example.contact

import retrofit2.Call
import retrofit2.http.GET

interface Api {
    @GET("api/?results=30")
    fun getResults() : Call<ResultList>
}
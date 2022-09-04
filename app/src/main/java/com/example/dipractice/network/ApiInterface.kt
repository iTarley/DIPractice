package com.example.dipractice.network

import com.example.dipractice.domain.model.MemeModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {

    @GET("get_memes")
    suspend fun getMeme(): Response<MemeModel>
}
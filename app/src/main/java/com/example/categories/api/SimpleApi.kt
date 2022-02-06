package com.example.categories.api

import com.example.categories.response.MainResponse
import retrofit2.Response
import retrofit2.http.GET

interface SimpleApi {
    @GET("5ec39cba300000720039c1f6")
suspend fun setRequest(): Response<MainResponse>
}

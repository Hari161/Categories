package com.example.categories.repository

import com.example.categories.api.RetrofitInstance
import com.example.categories.response.MainResponse
import retrofit2.Response

class Repository {

        suspend fun getCustomPosts(): Response<MainResponse> {
            return RetrofitInstance.api.setRequest()
        }
    }

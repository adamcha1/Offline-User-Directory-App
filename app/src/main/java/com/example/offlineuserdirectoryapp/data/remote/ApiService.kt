package com.example.offlineuserdirectoryapp.data.remote

import com.example.offlineuserdirectoryapp.model.User
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("users")
    suspend fun getUsers(): Response<List<User>>
}

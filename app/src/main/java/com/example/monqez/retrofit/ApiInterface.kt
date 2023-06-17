package com.example.monqez.retrofit

import com.example.monqez.pojo.User
import com.example.monqez.pojo.UserReq
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInterface {
    @POST("getUser")
    suspend fun getUser(@Body data: UserReq): User
}
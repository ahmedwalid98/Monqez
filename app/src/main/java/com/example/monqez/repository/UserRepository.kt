package com.example.monqez.repository

import com.example.monqez.pojo.UserReq
import com.example.monqez.retrofit.ApiInterface
import com.example.monqez.retrofit.RetrofitBuilder

class UserRepository {
    suspend fun getUser(data: UserReq) = RetrofitBuilder.getApis().getUser(data)
}
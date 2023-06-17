package com.example.monqez.retrofit

import android.util.Log
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitBuilder {
    companion object {
        private val BASE_URL = "http://13.53.186.220/"
        private var retrofit: Retrofit? = null
        private  fun getInstance(): Retrofit {
            if (retrofit == null) {
                // createRetrofit

                val logging = HttpLoggingInterceptor { message ->
                    Log.e(
                        "api",
                        message
                    )
                }
                logging.setLevel(HttpLoggingInterceptor.Level.BODY)
                val client = OkHttpClient.Builder()
                    .addInterceptor(logging)
                    .readTimeout(60, TimeUnit.SECONDS)
                    .build()

                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            }
            return retrofit!!;
        }
        fun getApis(): ApiInterface {
            return getInstance().create(ApiInterface::class.java);
        }
    }
}
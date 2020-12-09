package com.opencanarias.frontend.io
/*
import com.opencanarias.frontend.io.response.LoginResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

import retrofit2.http.*

interface IRetrofitService {

    @POST("login")
    fun postLogin(@Query("email") email: String, @Query("password") password: String):
            Call<LoginResponse>

    @POST("logout")
    fun postLogout(@Header("Authorization") authHeader: String): Call<Void>

/*
    @POST("register")
    @Headers("Accept: application/json")
    fun postRegister(
        @Query("name") name: String,
        @Query("email") email: String,
        @Query("password") password: String,
        @Query("password_confirmation") password_confirmation: String
    ): Call<Void>
*/
    companion object Factory {
        private const val BASE_URL = "http://192.168.56.1:8000/api/"

        fun create(): IRetrofitService {
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()

            return retrofit.create(IRetrofitService::class.java)
        }
    }
/*
    @POST( "login")
    fun postLogin(@Field("email") email: String , @Field("password") password: String):
            Call<LoginResponse>
*/
}*/
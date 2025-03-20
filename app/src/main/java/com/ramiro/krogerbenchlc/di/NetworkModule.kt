package com.ramiro.krogerbenchlc.di

import com.google.gson.Gson
import com.ramiro.krogerbenchlc.data.interceptors.ApiInterceptor
import com.ramiro.krogerbenchlc.data.service.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun providesRetrofit(gson: Gson, okHttpClient: OkHttpClient):Retrofit
    = Retrofit
        .Builder()
        .baseUrl("https://api.thecatapi.com/")
        .addConverterFactory(GsonConverterFactory.create(gson))
        .client(okHttpClient)
        .build()

    @Provides
    @Singleton
    fun providesServiceClient(retrofit: Retrofit): ApiService
    = retrofit.create(ApiService::class.java)

    @Provides
    @Singleton
    fun providesOkHttpClient(interceptor: ApiInterceptor): OkHttpClient
    = OkHttpClient.Builder().addInterceptor(interceptor)
        .writeTimeout(30, TimeUnit.SECONDS)
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS).build()

    @Provides
    @Singleton
    fun providesGson():Gson = Gson()

    @Provides
    @Singleton
    fun providesDispatcher():CoroutineDispatcher = Dispatchers.IO
}
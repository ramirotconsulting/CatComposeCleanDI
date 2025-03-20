package com.ramiro.krogerbenchlc.data.interceptors

import com.ramiro.krogerbenchlc.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class ApiInterceptor @Inject constructor(): Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        chain.request().newBuilder().apply {
            addHeader("x-api-key", BuildConfig.apikey)
        }.build().also {
            return chain.proceed(it)
        }
    }
}
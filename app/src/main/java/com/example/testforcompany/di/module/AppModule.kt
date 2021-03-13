package com.example.testforcompany.di.module

import com.androidnetworking.interceptors.HttpLoggingInterceptor
import com.example.testforcompany.BuildConfig
import com.example.testforcompany.data.api.ApiService
import com.google.gson.Gson
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

val BASE_URL = "https://pokeapi.co/api/v2/"
val appModule = module {
    single { provideOkHttpClient() }
    single { provideRetrofit(get()) }
    single { provideApiService(get())}

}

private fun provideOkHttpClient() = if(BuildConfig.DEBUG){
    val loggingInterceptor = HttpLoggingInterceptor()
    loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
    OkHttpClient.Builder().addInterceptor(loggingInterceptor).build()
}else{
    OkHttpClient.Builder().build()
}
private fun provideRetrofit(okHttpClient: OkHttpClient) : Retrofit {
    return Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJavaCallAdapterFactory.create()).baseUrl(BASE_URL).client(okHttpClient).build()
}
private fun provideApiService(retrofit: Retrofit): ApiService {
    return retrofit.create(ApiService::class.java)
}

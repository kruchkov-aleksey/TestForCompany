package com.example.testforcompany.data.api

import com.example.testforcompany.data.model.Pokemon
import com.example.testforcompany.data.model.ResponseWrapper
import io.reactivex.Single

import retrofit2.http.GET
import retrofit2.http.Path


interface ApiService {
    @GET("pokemon/{name}")
    fun searchPokemon(@Path("name") name:String): Single<ResponseWrapper<List<Pokemon>>>
}
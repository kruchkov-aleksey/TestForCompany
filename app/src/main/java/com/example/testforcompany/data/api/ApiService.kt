package com.example.testforcompany.data.api

import com.example.testforcompany.data.model.Pokemon
import io.reactivex.Single

import retrofit2.Response
import retrofit2.http.GET


interface ApiService {
    @GET("pokemon")
    fun getPokemons(): Single<List<Pokemon>>
}
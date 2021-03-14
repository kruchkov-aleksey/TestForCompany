package com.example.testforcompany.data.api

import com.example.testforcompany.data.model.Pokemon
import com.example.testforcompany.data.model.PokemonSearch
import com.example.testforcompany.data.model.ResponseWrapper
import com.example.testforcompany.data.model.ResponseWrapperSearch
import io.reactivex.Observable
import io.reactivex.Single

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface ApiService {
    @GET("pokemon")
    fun getPokemons(): Single<ResponseWrapper<List<Pokemon>>>
    @GET("pokemon")
    fun searchPokemon(@Path("name") name: String): Single<ResponseWrapperSearch<List<PokemonSearch>>>
}
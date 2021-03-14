package com.example.testforcompany.data.repository


import com.example.testforcompany.data.api.ApiService
import com.example.testforcompany.data.model.Pokemon
import com.example.testforcompany.data.model.PokemonSearch
import com.example.testforcompany.data.model.ResponseWrapper
import com.example.testforcompany.data.model.ResponseWrapperSearch
import io.reactivex.Observable
import io.reactivex.Single
import java.util.*

class SearchRepository(val apiService: ApiService) {
    fun searchPokemon(name: String): Single<ResponseWrapperSearch<List<PokemonSearch>>> {
        return apiService.searchPokemon(name = name)
    }
}
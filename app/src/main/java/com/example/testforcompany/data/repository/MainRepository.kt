package com.example.testforcompany.data.repository

import android.util.Log
import com.example.testforcompany.data.api.ApiService
import com.example.testforcompany.data.model.Pokemon
import com.example.testforcompany.data.model.ResponseWrapper
import io.reactivex.Single
import java.net.ResponseCache

class MainRepository (private val apiService: ApiService) {
    fun searchPokemon(name: String): Single<ResponseWrapper<List<Pokemon>>> {
        Log.e("Response",name)
        return apiService.searchPokemon(name = name)
    }
}
package com.example.testforcompany.data.repository

import com.example.testforcompany.data.api.ApiService

class MainRepository (private val apiService: ApiService) {
    fun getPokemons() = apiService.getPokemons()
}
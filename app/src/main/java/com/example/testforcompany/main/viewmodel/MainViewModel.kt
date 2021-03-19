package com.example.testforcompany.main.viewmodel

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testforcompany.data.model.Pokemon
import com.example.testforcompany.data.model.ResponseWrapper
import com.example.testforcompany.data.repository.MainRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.launch


class MainViewModel(private val mainRepository: MainRepository) : ViewModel() {
    var pokemons: MutableLiveData<List<Pokemon>> = MutableLiveData()
    val name: String = ""

    init {
        fetchPokemons(name)
    }


    fun fetchPokemons(name: String) {
        mainRepository.searchPokemon(name).observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io()).subscribe(
                {
                    pokemons.postValue(it.forms)
                },
                {
                    Log.e("error", "", it)
                })
    }
}
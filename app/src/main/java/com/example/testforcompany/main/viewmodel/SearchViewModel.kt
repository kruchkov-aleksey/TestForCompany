package com.example.testforcompany.main.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testforcompany.data.model.Pokemon
import com.example.testforcompany.data.model.PokemonSearch
import com.example.testforcompany.data.repository.SearchRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.launch

class SearchViewModel(private val searchRepository: SearchRepository): ViewModel() {

    val pokemons: MutableLiveData<List<PokemonSearch>> = MutableLiveData()
    var name: String = ""
    init{
        fetchPokemon(name)
    }

        fun fetchPokemon(name: String){
        viewModelScope.launch {
            searchRepository.searchPokemon(name).observeOn(AndroidSchedulers.mainThread()).subscribeOn(
                Schedulers.io()).subscribe(
                { pokemons.postValue(it.abilities) },
                {
                    Log.e("error","",it)
                })
        }
    }
}
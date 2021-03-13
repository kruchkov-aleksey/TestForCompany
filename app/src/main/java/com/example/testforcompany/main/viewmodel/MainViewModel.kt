package com.example.testforcompany.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testforcompany.data.model.Pokemon
import com.example.testforcompany.data.repository.MainRepository
import com.example.testforcompany.utils.Resource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.launch


class MainViewModel(private val mainRepository: MainRepository) : ViewModel() {
    private val _pokemons = MutableLiveData<List<Pokemon>>()
    val pokemons: LiveData<List<Pokemon>>
        get() = _pokemons

    init{
        fetchPokemons()
    }

    private fun fetchPokemons(){
        viewModelScope.launch {
            mainRepository.getPokemons().observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(
                { _pokemons.postValue(it)},
                {}
            )
        }
    }
}
package com.example.testforcompany.main.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testforcompany.data.model.Pokemon
import com.example.testforcompany.data.repository.MainRepository
import com.example.testforcompany.data.repository.SearchRepository
import com.example.testforcompany.di.module.viewModelModule
import com.example.testforcompany.utils.Resource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.launch


class MainViewModel(private val mainRepository: MainRepository) : ViewModel() {
    var pokemons: MutableLiveData<List<Pokemon>> = MutableLiveData()
    init{
        fetchPokemons()
    }

    private fun fetchPokemons(){
        viewModelScope.launch {
            mainRepository.getPokemons().observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(
                { pokemons.postValue(it.results)},
                {
                    Log.e("error","",it)
                }
            )
        }
    }
}
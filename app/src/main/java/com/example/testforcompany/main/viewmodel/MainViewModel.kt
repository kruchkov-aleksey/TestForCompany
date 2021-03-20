package com.example.testforcompany.main.viewmodel

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.EmptyResultSetException
import com.example.testforcompany.EmployeeDao
import com.example.testforcompany.data.model.Employee
import com.example.testforcompany.data.model.Pokemon
import com.example.testforcompany.data.model.ResponseWrapper
import com.example.testforcompany.data.repository.MainRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.launch


class MainViewModel(private val mainRepository: MainRepository, private val employeeDao: EmployeeDao) : ViewModel() {
    var pokemons: MutableLiveData<List<Pokemon>> = MutableLiveData()
    val name: String = ""

    init {
        fetchPokemons(name)
    }


    fun fetchPokemons(name: String) {
        mainRepository.searchPokemon(name)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io()).subscribe(
                {
                    if(it.forms?.isNotEmpty() == true){
                        checkPokemonInBD(it.forms.first())
                    }
                },
                {
                    Log.e("error", "", it)
                })
        }
    fun checkPokemonInBD(pokemon: Pokemon) {
        employeeDao.findEmployeeByName(pokemon.name).observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io()).subscribe(
                {
                    pokemons.postValue(listOf(pokemon.copy(isFavorite = true)))
                },
                {
                    if(it is EmptyResultSetException){
                        pokemons.postValue(listOf(pokemon))
                    }
                    Log.e("error", "", it)
                })
    }
}
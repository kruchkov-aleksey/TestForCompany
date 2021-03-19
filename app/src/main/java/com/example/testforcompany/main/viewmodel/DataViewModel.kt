package com.example.testforcompany.main.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testforcompany.EmployeeDao
import com.example.testforcompany.data.model.Employee
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.koin.java.KoinJavaComponent.inject


class DataViewModel(private val employeeDao: EmployeeDao): ViewModel() {

    var employees: MutableLiveData<List<Employee>> = MutableLiveData()
    init {
        fetchEmployee()
    }
    fun fetchEmployee(){

        employeeDao.getAll().observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io()).subscribe(
                {
                    Log.e("Response",it.toString())
                    employees.postValue(it)
                },
                {
                    Log.e("error", "", it)
                })
    }
    fun addEmployee(employee: Employee){
        employeeDao.insert(employee)
    }
    fun delete(employee: Employee){
        employeeDao.delete(employee)
    }
}
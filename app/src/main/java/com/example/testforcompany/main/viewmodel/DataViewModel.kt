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
    var employee: MutableLiveData<Employee> = MutableLiveData()

    init{
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
        Log.e("Response", employee.name)
        employeeDao.insert(employee)
    }
    fun delete(employee: Employee){
        employeeDao.delete(employee)
    }
    fun findByName(name: String) {
        employeeDao.findEmployeeByName(name).observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io()).subscribe(
            {
                employee.postValue(it)
                Log.e("Response",employee.value.toString() + " find")
            },
                {
                    Log.e("error", "", it)
                })
    }
}
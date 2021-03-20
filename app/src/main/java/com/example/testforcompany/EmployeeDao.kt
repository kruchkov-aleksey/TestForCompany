package com.example.testforcompany

import androidx.room.*
import com.example.testforcompany.data.model.Employee
import io.reactivex.Single

@Dao
interface EmployeeDao {

    @Query("SELECT * FROM Employees")
    fun getAll(): Single<List<Employee>>

    @Insert
    fun insert(employee: Employee)

    @Delete
    fun delete(employee: Employee)

    @Update
    fun update(employee: Employee)
    @Query("SELECT * FROM Employees WHERE name = :name")
    fun findEmployeeByName(name: String): Single<Employee>
}
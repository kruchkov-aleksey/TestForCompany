package com.example.testforcompany

import androidx.room.*
import com.example.testforcompany.data.model.Employee
import io.reactivex.Single

@Dao
interface EmployeeDao {

    @Query("SELECT * FROM Employee")
    fun getAll(): Single<List<Employee>>

    @Insert
    fun insert(employee: Employee)

    @Delete
    fun delete(employee: Employee)

    @Update
    fun update(employee: Employee)
}
package com.example.testforcompany

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.testforcompany.data.model.Employee

@Database(
    entities = [Employee::class],
    version = 1
)
abstract class AppDataBase: RoomDatabase() {
    abstract fun employeeDao(): EmployeeDao
}
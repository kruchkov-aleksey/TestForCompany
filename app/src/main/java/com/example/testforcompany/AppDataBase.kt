package com.example.testforcompany

import androidx.room.Database
import androidx.room.RoomDatabase
@Database(
    entities = [EmployeeDao::class],
    version = 1
)
abstract class AppDataBase: RoomDatabase() {
    abstract fun employeeDao(): EmployeeDao
}
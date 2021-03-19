package com.example.testforcompany.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Employees")
data class Employee(
        @PrimaryKey
        var name: String = ""
)
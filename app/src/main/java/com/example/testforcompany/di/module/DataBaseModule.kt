package com.example.testforcompany.di.module

import android.app.ActivityManager
import android.content.Context
import androidx.room.Room
import com.example.testforcompany.AppDataBase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import org.koin.java.KoinJavaComponent.get

val dataBaseModule = module {
    single {
        Room.databaseBuilder(androidContext(),AppDataBase::class.java, "mydb")
    }
    single{
        get<AppDataBase>().EmployeeDao()
    }
}




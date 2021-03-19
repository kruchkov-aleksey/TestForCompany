package com.example.testforcompany.di.module

import android.app.ActivityManager
import android.content.Context
import androidx.room.Room
import com.example.testforcompany.AppDataBase
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.dsl.module
import org.koin.java.KoinJavaComponent.get

val dataBaseModule: Module = module{
    single{
        Room.databaseBuilder(androidApplication(),AppDataBase::class.java, "mydb").allowMainThreadQueries().build()
    }
    single{
        get<AppDataBase>().employeeDao()
    }
}




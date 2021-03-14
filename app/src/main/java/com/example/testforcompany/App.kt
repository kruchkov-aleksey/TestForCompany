package com.example.testforcompany

import android.app.Application
import com.example.testforcompany.di.module.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidContext(this@App)
            modules(listOf(appModule, repoModule, viewModelModule, repoSearch, searchViewModel))
        }
    }
}
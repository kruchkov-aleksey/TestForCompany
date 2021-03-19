package com.example.testforcompany.di.module

import androidx.lifecycle.ViewModel
import com.example.testforcompany.main.viewmodel.DataViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import org.koin.java.KoinJavaComponent.get

val dataModelModule = module {
     viewModel{ DataViewModel(get()) }
}
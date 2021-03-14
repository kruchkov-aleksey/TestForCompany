package com.example.testforcompany.di.module

import com.example.testforcompany.main.viewmodel.SearchViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val searchViewModel = module{
    viewModel {
        SearchViewModel(get())
    }
}
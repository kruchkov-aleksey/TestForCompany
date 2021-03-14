package com.example.testforcompany.di.module

import com.example.testforcompany.data.repository.SearchRepository
import org.koin.dsl.module

val repoSearch = module {
    single { SearchRepository(get()) }
}
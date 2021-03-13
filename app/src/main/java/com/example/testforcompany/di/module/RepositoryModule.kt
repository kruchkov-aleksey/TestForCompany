package com.example.testforcompany.di.module

import com.example.testforcompany.data.repository.MainRepository
import org.koin.dsl.module

val repoModule = module {
    single { MainRepository(get()) }
}
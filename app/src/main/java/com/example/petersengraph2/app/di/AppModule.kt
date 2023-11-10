package com.example.petersengraph2.app.di

import com.example.petersengraph2.app.presentation.MainActivityVM
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    viewModel<MainActivityVM> {
        MainActivityVM(
            createVerticesSetUseCase = get(),
            createEdgeSetUseCase = get()
        )
    }
}
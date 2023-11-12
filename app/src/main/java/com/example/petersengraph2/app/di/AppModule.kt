package com.example.petersengraph2.app.di

import com.example.petersengraph2.app.presentation.GraphViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    viewModel<GraphViewModel> {
        GraphViewModel(
            createGeneralizedPetersenGraph = get()
        )
    }
}
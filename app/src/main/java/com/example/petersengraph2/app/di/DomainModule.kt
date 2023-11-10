package com.example.petersengraph2.app.di

import com.example.petersengraph2.domain.CreateEdgeSetUseCase
import com.example.petersengraph2.domain.CreateVerticesSetUseCase
import org.koin.dsl.module

val domainModule = module {

    factory<CreateEdgeSetUseCase> {
        CreateEdgeSetUseCase()
    }

    factory<CreateVerticesSetUseCase> {
        CreateVerticesSetUseCase()
    }

}
package com.example.petersengraph2.app.di

import com.example.petersengraph2.domain.CreateGeneralizedPetersenGraph
import org.koin.dsl.module

val domainModule = module {

    single<CreateGeneralizedPetersenGraph> {
        CreateGeneralizedPetersenGraph()
    }

}
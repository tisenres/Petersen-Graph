package com.example.petersengraph2.app.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.petersengraph2.domain.CreateEdgeSetUseCase
import com.example.petersengraph2.domain.CreateVerticesSetUseCase
import com.example.petersengraph2.domain.entity.Edge
import com.example.petersengraph2.domain.entity.Vertex

class MainActivityVM(
    private val createVerticesSetUseCase: CreateVerticesSetUseCase,
    private val createEdgeSetUseCase: CreateEdgeSetUseCase
): ViewModel() {

    val verticesLiveData = MutableLiveData<Set<Vertex>>()
    val edgeLiveData = MutableLiveData<Set<Edge>>()

    fun execute() {
        initVerticesLiveData()
        initEdgeLiveData()
    }

    private fun initVerticesLiveData() {
        verticesLiveData.value = createVerticesSetUseCase.execute()
    }

    private fun initEdgeLiveData() {
        edgeLiveData.value = verticesLiveData.value?.let { verticesSet ->
            createEdgeSetUseCase.execute(verticesSet = verticesSet)
        }
    }
}
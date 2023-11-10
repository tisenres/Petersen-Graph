package com.example.petersengraph2.app.presentation

import androidx.lifecycle.ViewModel
import com.example.petersengraph2.domain.CreateEdgeSetUseCase
import com.example.petersengraph2.domain.CreateVerticesSetUseCase
import com.example.petersengraph2.domain.entity.Edge
import com.example.petersengraph2.domain.entity.Vertex

class MainActivityVM(
    private val createVerticesSetUseCase: CreateVerticesSetUseCase,
    private val createEdgeSetUseCase: CreateEdgeSetUseCase
): ViewModel() {

    private lateinit var verticesSet: Set<Vertex>
    private lateinit var edgeSet: Set<Edge>

    fun getVertices(): Set<Vertex> {
        verticesSet.let {
            verticesSet = createVerticesSetUseCase.execute()
        }
        return verticesSet
    }

    fun getEdges(): Set<Edge> {
        edgeSet.let {
            edgeSet = createEdgeSetUseCase.execute(getVertices())
        }
        return edgeSet
    }

}
package com.example.petersengraph2.domain

import com.example.petersengraph2.domain.entity.Edge
import com.example.petersengraph2.domain.entity.Vertex

class CreateEdgeSetUseCase() {

    fun execute(verticesSet: Set<Vertex>): Set<Edge> {
        val edgeSet = mutableSetOf<Edge>()

        verticesSet.forEach { vertex1 ->
            verticesSet.forEach { vertex2 ->
                if (vertex1.x != vertex2.x && vertex1.x != vertex2.y && vertex1.y != vertex2.x && vertex1.y != vertex2.y) {
                    val edge = Edge(setOf(vertex1, vertex2))
                    edgeSet.add(edge)
                }
            }
        }
        return edgeSet
    }

}
package com.example.petersengraph2.domain

import com.example.petersengraph2.domain.entity.Vertex

const val VERTICES_SET_LENGTH = 5

class CreateVerticesSetUseCase {

    fun execute(): Set<Vertex> {
        val verticesSet = mutableSetOf<Vertex>()

        (1 .. VERTICES_SET_LENGTH).forEach { x ->
            (1 .. VERTICES_SET_LENGTH).forEach { y ->
                if (x < y) {
                    verticesSet.add(Vertex(x, y))
                }
            }
        }
        return verticesSet
    }

}
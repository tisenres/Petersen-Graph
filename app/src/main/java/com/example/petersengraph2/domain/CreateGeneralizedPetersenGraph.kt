package com.example.petersengraph2.domain

class CreateGeneralizedPetersenGraph {

    fun execute(n: Int, k: Int): Pair<MutableList<Int>, MutableList<Pair<Int, Int>>> {
        val vertices = generateVertices(n)
        val edges = generateEdges(n, k)
        return Pair(vertices, edges)
    }

    private fun generateVertices(n: Int): MutableList<Int> {
        val vertices = mutableListOf<Int>()
        for (i in 0 until n) {
            vertices.add(i)
        }
        return vertices
    }

    private fun generateEdges(n: Int, k: Int): MutableList<Pair<Int, Int>> {
        val edges = mutableListOf<Pair<Int, Int>>()
        for (i in 0 until n) {
            edges.add(Pair(i, (i + k) % n))
            edges.add(Pair(i, (i + k * 2) % n))
        }
        return edges
    }
}
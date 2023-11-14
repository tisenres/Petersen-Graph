package com.example.petersengraph2.app.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.petersengraph2.domain.CreateGeneralizedPetersenGraph

class GraphViewModel(
    private val createGeneralizedPetersenGraph: CreateGeneralizedPetersenGraph
): ViewModel() {

    val verticesLiveData: MutableLiveData<MutableList<Int>> = MutableLiveData()
    val edgeLiveData: MutableLiveData<MutableList<Pair<Int, Int>>> = MutableLiveData()
    val nLiveData: MutableLiveData<Int> = MutableLiveData()
    val kLiveData: MutableLiveData<Int> = MutableLiveData()

    fun drawPetersenGraph(n: Int, k: Int) {
        val pair = createGeneralizedPetersenGraph.execute(n, k)
        val vertices = pair.first
        val edges = pair.second

        verticesLiveData.value = vertices
        edgeLiveData.value = edges
        nLiveData.value = n
        kLiveData.value = k
    }
}
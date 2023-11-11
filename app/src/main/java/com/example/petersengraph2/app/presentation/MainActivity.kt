package com.example.petersengraph2.app.presentation

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.petersengraph2.databinding.ActivityMainBinding
import com.example.petersengraph2.domain.entity.Edge
import com.example.petersengraph2.domain.entity.Vertex
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : AppCompatActivity() {

//    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainActivityVM by viewModel()
    private lateinit var petersenView: PetersenGraphView

    private var verticesSet: Set<Vertex> = emptySet()
    private var edgeSet: Set<Edge> = emptySet()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        binding = ActivityMainBinding.inflate(layoutInflater)

        initObservers()
        viewModel.execute()

        petersenView = PetersenGraphView(this, verticesSet, edgeSet)
        setContentView(petersenView)
    }

    private fun initObservers() {
        viewModel.verticesLiveData.observe(this) { verticesSet ->
            this.verticesSet = verticesSet
            Log.d("gsdgsghsghdsd", verticesSet.toString())
        }

        viewModel.edgeLiveData.observe(this) { edgeSet ->
            this.edgeSet = edgeSet
            Log.d("gsdgsghsghdsd", edgeSet.toString())
        }
    }
}
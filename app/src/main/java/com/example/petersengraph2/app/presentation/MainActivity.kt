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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        binding = ActivityMainBinding.inflate(layoutInflater)

        initLiveDataObservers()
        viewModel.execute()

        petersenView = PetersenGraphView(this, viewModel.verticesLiveData.value!!, viewModel.edgeLiveData.value!!)
        setContentView(petersenView)
    }

    private fun initLiveDataObservers() {
        viewModel.verticesLiveData.observe(this) { verticesSet ->
            petersenView.verticesSet = verticesSet
        }

        viewModel.edgeLiveData.observe(this) { edgeSet ->
            petersenView.edgeSet = edgeSet
        }
    }
}
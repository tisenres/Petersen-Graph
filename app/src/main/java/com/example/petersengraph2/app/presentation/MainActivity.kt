package com.example.petersengraph2.app.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.petersengraph2.databinding.ActivityMainBinding
import com.example.petersengraph2.domain.entity.Edge
import com.example.petersengraph2.domain.entity.Vertex
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.w3c.dom.Node


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainActivityVM by viewModel()

    private lateinit var verticesSet: Set<Vertex>
    private lateinit var edgeSet: Set<Edge>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        verticesSet = viewModel.getVertices()
        edgeSet = viewModel.getEdges()
    }
}
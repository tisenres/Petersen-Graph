package com.example.petersengraph2.app.presentation

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.petersengraph2.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: GraphViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        Log.d("SUDHSHDHSD","We are in activity")
        setContentView(binding.root)

        initLiveDataObservers()
        initSetOnClickListeners()

    }

    private fun initSetOnClickListeners() {
        binding.createGraphBtn.setOnClickListener {
            val n = binding.inputN.text.toString().toInt()
            val k = binding.inputK.text.toString().toInt()

            viewModel.drawPetersenGraph(n, k)
        }
    }


    private fun initLiveDataObservers() {
        viewModel.verticesLiveData.observe(this) { verticesSet ->
            binding.petersenView.verticesSet = verticesSet
            binding.petersenView.invalidate()
        }

        viewModel.edgeLiveData.observe(this) { edgeSet ->
            binding.petersenView.edgeSet = edgeSet
            binding.petersenView.invalidate()
        }

        viewModel.nLiveData.observe(this) { n ->
            binding.petersenView.n = n
        }

        viewModel.kLiveData.observe(this) { k ->
            binding.petersenView.k = k
        }
    }
}
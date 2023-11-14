package com.example.petersengraph2.app.presentation

import android.content.res.Configuration
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.petersengraph2.app.presentation.themes.Theme
import com.example.petersengraph2.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: GraphViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initLiveDataObservers()
        initSetOnClickListeners()
        setThemeForPaint()
    }

    private fun initSetOnClickListeners() {
        binding.createGraphBtn.setOnClickListener {
            val n = binding.inputN.text.toString()
            val k = binding.inputK.text.toString()

            if (n.isNotBlank() && k.isNotBlank()) {
                viewModel.drawPetersenGraph(n.toInt(), k.toInt())
            } else {
                Toast.makeText(this, "Enter the values", Toast.LENGTH_SHORT).show()
            }
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

    private fun setThemeForPaint() {
        when (resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK) {
            Configuration.UI_MODE_NIGHT_NO -> binding.petersenView.setThemeForPaint(Theme.LIGHT)
            Configuration.UI_MODE_NIGHT_YES -> binding.petersenView.setThemeForPaint(Theme.DARK)
            else -> binding.petersenView.setThemeForPaint(Theme.LIGHT)
        }
    }
}
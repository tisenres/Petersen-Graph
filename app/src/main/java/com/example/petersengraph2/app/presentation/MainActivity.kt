package com.example.petersengraph2.app.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.petersengraph2.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: GraphViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction()
            .replace(binding.fragmentContainerViewTag.id, GraphFragment(viewModel))
            .commit()

        initSetOnClickListeners()
    }

    private fun initSetOnClickListeners() {
        binding.createGraphBtn.setOnClickListener {
            val n = binding.inputN.text.toString().toInt()
            val k = binding.inputK.text.toString().toInt()

            viewModel.drawPetersenGraph(n, k)
        }
    }
}
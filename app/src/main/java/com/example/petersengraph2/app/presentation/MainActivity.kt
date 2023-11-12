package com.example.petersengraph2.app.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.petersengraph2.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: GraphViewModel by viewModel()

    private var n: Int = 0
    private var k: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initSetOnClickListeners()
    }

    private fun changeFragment(n: Int, k: Int) {

        val bundle = Bundle()
        bundle.putInt("N", n)
        bundle.putInt("K", k)

        val fragment = GraphFragment(viewModel)
        fragment.arguments = bundle

        supportFragmentManager.beginTransaction()
            .replace(binding.fragmentContainerViewTag.id, fragment)
            .commit()
    }

    private fun initSetOnClickListeners() {
        binding.createGraphBtn.setOnClickListener {
            val n = binding.inputN.text.toString().toInt()
            val k = binding.inputK.text.toString().toInt()

            viewModel.drawPetersenGraph(n, k)
            changeFragment(n, k)
        }
    }
}
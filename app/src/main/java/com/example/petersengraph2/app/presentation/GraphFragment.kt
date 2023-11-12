package com.example.petersengraph2.app.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class GraphFragment(private val viewModel: GraphViewModel) : Fragment() {

    private lateinit var petersenView: PetersenGraphView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

//        val bundle = arguments
//        bundle?.let {
//            val n = bundle.getInt("N", 0)
//            val k = bundle.getInt("K", 0)
//        }

        petersenView = PetersenGraphView(requireContext(), )

        initLiveDataObservers()

        return petersenView
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
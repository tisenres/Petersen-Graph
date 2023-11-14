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
    ): View {
        petersenView = PetersenGraphView(requireContext())
        initLiveDataObservers()

        return petersenView
    }

    private fun initLiveDataObservers() {
        viewModel.verticesLiveData.observe(viewLifecycleOwner) { verticesSet ->
            petersenView.verticesSet = verticesSet
            petersenView.invalidate()
        }

        viewModel.edgeLiveData.observe(viewLifecycleOwner) { edgeSet ->
            petersenView.edgeSet = edgeSet
            petersenView.invalidate()
        }
    }
}
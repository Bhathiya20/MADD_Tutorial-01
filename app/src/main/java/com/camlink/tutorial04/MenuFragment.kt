package com.camlink.tutorial04

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

class MenuFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val viewModel = ViewModelProvider(requireActivity()).get(MainActivityData::class.java)
        val rootView = inflater.inflate(R.layout.fragment_menu, container, false)

        val btnWalking: Button = rootView.findViewById(R.id.btnWalking)
        val btnCycling: Button = rootView.findViewById(R.id.btnCycling)
        val btnDriving: Button = rootView.findViewById(R.id.btnDriving)

        btnWalking.setOnClickListener {
            viewModel.setCountValue(1)
        }
        btnCycling.setOnClickListener {
            viewModel.setCountValue(2)
        }
        btnDriving.setOnClickListener {
            viewModel.setCountValue(3)
        }

        return rootView
    }
}

package com.camlink.tutorial04

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

import android.widget.Button

import androidx.lifecycle.ViewModelProvider

class WalkingFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val viewModel = ViewModelProvider(requireActivity()).get(MainActivityData::class.java)
        val rootView = inflater.inflate(R.layout.fragment_walking, container, false)

        val changeButton: Button = rootView.findViewById(R.id.btnChangeColor)
        val constraintLayout: ViewGroup = rootView.findViewById(R.id.walkingLayout)

        // Restore state
        val currentToggle = viewModel.walkingToggle.value ?: 0
        if (currentToggle == 1) {
            constraintLayout.setBackgroundResource(R.color.luminous_green)
        } else {
            constraintLayout.setBackgroundResource(R.color.luminous_blue)
        }

        changeButton.setOnClickListener {
            val toggle = viewModel.walkingToggle.value ?: 0
            if (toggle == 0) {
                viewModel.walkingToggle.value = 1
                constraintLayout.setBackgroundResource(R.color.luminous_green)
            } else {
                viewModel.walkingToggle.value = 0
                constraintLayout.setBackgroundResource(R.color.luminous_blue)
            }
        }

        return rootView
    }
}

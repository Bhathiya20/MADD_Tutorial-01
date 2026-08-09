package com.camlink.tutorial04

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

import androidx.lifecycle.ViewModelProvider

class CyclingFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val viewModel = ViewModelProvider(requireActivity()).get(MainActivityData::class.java)
        val rootView = inflater.inflate(
            R.layout.fragment_cycling,
            container,
            false
        )

        val changeButton: Button =
            rootView.findViewById(R.id.btnChangeColor)

        val constraintLayout: ViewGroup =
            rootView.findViewById(R.id.cyclingLayout)

        // Restore state
        val currentToggle = viewModel.cyclingToggle.value ?: 0
        if (currentToggle == 1) {
            constraintLayout.setBackgroundResource(R.color.luminous_red)
        } else {
            constraintLayout.setBackgroundResource(R.color.luminous_yellow)
        }

        changeButton.setOnClickListener {
            val toggle = viewModel.cyclingToggle.value ?: 0
            if (toggle == 0) {
                viewModel.cyclingToggle.value = 1
                constraintLayout.setBackgroundResource(R.color.luminous_red)
            } else {
                viewModel.cyclingToggle.value = 0
                constraintLayout.setBackgroundResource(R.color.luminous_yellow)
            }
        }

        return rootView
    }
}

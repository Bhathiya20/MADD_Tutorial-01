package com.camlink.tutorial04

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityData : ViewModel() {

    private val _clickedValue = MutableLiveData<Int>().apply {
        value = 1 // Start on WalkingFragment by default
    }
    val clickedvalue: LiveData<Int> = _clickedValue

    fun setCountValue(value: Int) {
        _clickedValue.value = value
    }

    // Background color states for each fragment (0 or 1)
    val walkingToggle = MutableLiveData<Int>().apply { value = 0 }
    val cyclingToggle = MutableLiveData<Int>().apply { value = 0 }
    val drivingToggle = MutableLiveData<Int>().apply { value = 0 }
}

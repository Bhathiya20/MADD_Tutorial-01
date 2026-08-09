package com.camlink.tutorial04

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.Observer

class MainActivity : AppCompatActivity() {

    val menuFragment = MenuFragment()
    val walkingFragment = WalkingFragment()
    val cyclingFragment = CyclingFragment()
    val drivingFragment = DrivingFragment()

    private lateinit var viewModel: MainActivityData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        loadMenu()

        viewModel = ViewModelProvider(this).get(MainActivityData::class.java)
        viewModel.clickedvalue.observe(this, Observer {
            when (it) {
                1 -> walk()
                2 -> cycle()
                3 -> drive()
            }
        })
    }

    private fun loadMenu() {
        val fragment = supportFragmentManager.findFragmentById(R.id.fragment_menu)
        if (fragment == null) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_menu, menuFragment)
                .commit()
        }
    }

    private fun walk() {
        val fragment = supportFragmentManager.findFragmentById(R.id.fragment_container)
        if (fragment == null) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_container, walkingFragment)
                .commit()
        } else {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_container, walkingFragment)
                .commit()
        }
    }

    private fun cycle() {
        val fragment = supportFragmentManager.findFragmentById(R.id.fragment_container)
        if (fragment == null) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_container, cyclingFragment)
                .commit()
        } else {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_container, cyclingFragment)
                .commit()
        }
    }

    private fun drive() {
        val fragment = supportFragmentManager.findFragmentById(R.id.fragment_container)
        if (fragment == null) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_container, drivingFragment)
                .commit()
        } else {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_container, drivingFragment)
                .commit()
        }
    }
}
package com.abdulmohsen.androidassignment.ui

import android.view.LayoutInflater
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.abdulmohsen.androidassignment.R
import com.abdulmohsen.androidassignment.databinding.ActivityMainBinding
import com.abdulmohsen.base.BaseActivity

class MainActivity : BaseActivity<ActivityMainBinding>() {
    private lateinit var navController: NavController

    override val bindingInflater: (LayoutInflater) -> ActivityMainBinding
        get() = ActivityMainBinding::inflate

    override fun setup() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.main_nav_host) as NavHostFragment
        navController = navHostFragment.navController
    }
}
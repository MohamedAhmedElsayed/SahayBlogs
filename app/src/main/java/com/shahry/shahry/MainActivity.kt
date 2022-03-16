package com.shahry.shahry

import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.shahry.shahry.base.ui.screen.BaseActivity
import com.shahry.shahry.databinding.ActivityMainBinding

class MainActivity : BaseActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!
    private val navController by lazy {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navHostFragment.navController
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = binding(R.layout.activity_main)
        NavigationUI.setupWithNavController(binding.mainToolbar, navController)

    }
}
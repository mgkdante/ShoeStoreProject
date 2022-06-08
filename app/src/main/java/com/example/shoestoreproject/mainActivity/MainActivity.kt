package com.example.shoestoreproject.mainActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.*
import com.example.shoestoreproject.R
import com.example.shoestoreproject.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var appBarConfiguration: AppBarConfiguration


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        //inflating tool bar
        setSupportActionBar(binding.toolbar)

        //identifying the fragment holder
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        //Setting screen that up button does not go back to
        appBarConfiguration = AppBarConfiguration(topLevelDestinationIds = setOf(R.id.loginFragment,R.id.welcomeFragment,R.id.instructionsFragment),
        fallbackOnNavigateUpListener = ::onSupportNavigateUp)



        binding.toolbar.setupWithNavController(navController, appBarConfiguration)

        setContentView(binding.root)
    }

}
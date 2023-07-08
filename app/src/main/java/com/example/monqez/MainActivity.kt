package com.example.monqez

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottom_nav)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        val header = findViewById<ImageView>(R.id.header)
        bottomNavigation.setupWithNavController(navController)
        navController.addOnDestinationChangedListener {_,destination,_->
            if (destination.id == R.id.splashFragment){
                header.visibility = View.GONE
            }else{
                header.visibility = View.VISIBLE
            }
            if (destination.id == R.id.splashFragment || destination.id == R.id.welcomeFragment || destination.id == R.id.instructionFragment){
                bottomNavigation.visibility = View.GONE
            }else{
                bottomNavigation.visibility = View.VISIBLE
            }
        }
    }
    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.nav_host_fragment)
        return navController.navigateUp()
    }
}
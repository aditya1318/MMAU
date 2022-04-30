package com.example.mmau

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavDestination
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {


    lateinit var bottomNavigationView: BottomNavigationView;

    lateinit var bottomAppBar: BottomAppBar;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        bottomAppBar = findViewById(R.id.bottomAppBar)



        bottomNavigationView = findViewById(R.id.bottomNavigationView)
        val navHostFragment: NavHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment;
        val navController = navHostFragment.navController

        NavigationUI.setupWithNavController(
            bottomNavigationView,
            navHostFragment.navController
        );

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.home_nav_fragment -> {
                    bottomNavigationView.visibility = View.VISIBLE
                    bottomAppBar.visibility = View.VISIBLE


                }
                R.id.doner_nav_Fragment -> {
                    bottomNavigationView.visibility = View.VISIBLE
                    bottomAppBar.visibility = View.VISIBLE

                }
                R.id.login_fragment -> {
                    bottomNavigationView.visibility = View.GONE
                    bottomAppBar.visibility = View.GONE
                }
                R.id.profile_nav_fragment -> {
                    bottomNavigationView.visibility = View.VISIBLE
                    bottomAppBar.visibility = View.VISIBLE

                }
                else -> {
                    bottomNavigationView.visibility = View.GONE
                    bottomAppBar.visibility = View.GONE
                }

            }

            val firstFragment = home_nav_fragment()
            val secondFragment = doner_nav_Fragment()
            val thirdFragment = reward_nav_fragment()
            val fourthfragment = profile_nav_fragment()

        }


        fun showBottomNav() {
            bottomNavigationView.visibility = View.VISIBLE
            bottomAppBar.visibility = View.VISIBLE


        }

        fun hideBottomNav() {
            bottomNavigationView.visibility = View.GONE
            bottomAppBar.visibility = View.GONE


        }
    }
}

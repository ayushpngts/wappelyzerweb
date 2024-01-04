package com.ngts.wappelyzerweb

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.ngts.wappelyzerweb.databinding.ActivityMainBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.create


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var bottomNavBar: BottomNavigationView
    private lateinit var mNavController: NavController
    private lateinit var googleSignInClient: GoogleSignInClient


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        mNavController = navHostFragment.navController
        bottomNavBar = findViewById(R.id.bottomNavBar)

        mNavController.addOnDestinationChangedListener { controller, destination, arguments ->


            bottomNavBar.isVisible = destination.id in arrayOf(
                R.id.fragment_home_screen,
                R.id.analyticsScreen_Fragment,

                )
        }

        bottomNavBar.setOnItemSelectedListener {
            when(it.itemId){
                R.id.navHome ->{
                    mNavController.navigate(R.id.fragment_home_screen)
                    true
                }
                R.id.navAnalytics ->{
                    mNavController.navigate(R.id.analyticsScreen_Fragment)
                    true
                }
                R.id.navSmsTesting ->{
                    mNavController.navigate(R.id.fragment_home_screen)
                    true
                }
                R.id.navSettings ->{
                    mNavController.navigate(R.id.analyticsScreen_Fragment)
                    true
                }
                else -> false
            }
        }
    }
    public fun click(){
        val signInClient = googleSignInClient.signInIntent
            // lanchuer.launch(signInClient)
    }
}
package com.example.shifokor.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.shifokor.R
import com.example.shifokor.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    private lateinit var  navController: NavController

    private lateinit var toolbar: Toolbar


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)


//       image_bottom.setOnClickListener{
//            val intent = Intent(this, HomeFragment::class.java)
//            startActivity(intent)
//        }


        navController = findNavController(R.id.nav_fragment)
        val config = AppBarConfiguration(navController.graph)
        val toolbarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home,
                R.id.navigation_hour,
                R.id.navigation_doctor,
                R.id.navigation_evaluation
            )
        )

        setupActionBarWithNavController(navController, toolbarConfiguration)
        binding.bottomNavView.setupWithNavController(navController)

findViewById<Toolbar>(R.id.toolbar).setupWithNavController(navController,config)

    }


    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }


}
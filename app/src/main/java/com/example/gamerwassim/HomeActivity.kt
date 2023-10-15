package com.example.gamerwassim

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.gamerwassim.databinding.HomeBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.snackbar.Snackbar

class HomeActivity : AppCompatActivity() {

    private lateinit var binding : HomeBinding

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = HomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpToolBar()

       // setUpBottomNavigationBar()


    }


    // Debut Methodes pour toolbar *********************************
    fun setUpToolBar() {
        val toolbar: Toolbar = binding.toolbar.topAppBar
        setSupportActionBar(toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_toolbar, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val snack = Snackbar.make(binding.contextView,"Coming soon :)", Snackbar.LENGTH_LONG)
            .setTextColor(ContextCompat.getColor(this, R.color.white))

        when(item.itemId){
            R.id.bell -> snack.show()
            R.id.cart -> snack.show()
        }

        return super.onOptionsItemSelected(item)
    }
    // Fin Methodes pour toolbar ***********************************

    /*
          // Debut Methodes pour BottomBar *******************************
          fun setUpBottomNavigationBar() {
              minimumRequired()

              changeTopBarTitleSwitchFragment()
          }

        fun minimumRequired() {
              val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
              navController = navHostFragment.navController

              val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)

              bottomNavigationView.set(navController)
          }

          fun changeTopBarTitleSwitchFragment() {
              val appBarConfiguration = AppBarConfiguration(setOf(R.id.newsFragment, R.id.storeFragment, R.id.profileFragment))

              setupActionBarWithNavController(navController, appBarConfiguration)
          }
          // Fin Methodes pour BottomBar *********************************
    */

}
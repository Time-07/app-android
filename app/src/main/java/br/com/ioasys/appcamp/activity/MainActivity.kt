package br.com.ioasys.appcamp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import br.com.ioasys.appcamp.R
import br.com.ioasys.appcamp.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding: ActivityMainBinding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setBottomNavigation()
    }

    private fun setBottomNavigation(){
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController = navHostFragment.navController
        val bottomNavigationView = binding.bottomNavigationView
        binding.fragmentContainerView
        bottomNavigationView.setupWithNavController(navController)

        bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.listFragment -> {
                    navController.navigate(R.id.listFragment)
                    true
                }

                R.id.transHealthFragment -> {
                    navController.navigate(R.id.transHealthFragment)
                    true
                }

                R.id.aboutFragment -> {
                    navController.navigate(R.id.aboutFragment)
                    true
                }

                else -> {
                    false
                }
            }


        }

    }



    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
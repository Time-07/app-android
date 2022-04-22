package br.com.ioasys.appcamp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Telephony
import android.view.View
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import br.com.ioasys.appcamp.R
import br.com.ioasys.appcamp.databinding.ActivityMainBinding
import okhttp3.internal.wait


class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding: ActivityMainBinding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Thread.sleep(1000)

        setTheme(R.style.Theme_AppCamp)

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

        navController.addOnDestinationChangedListener { _, destination, _ ->
            bottomNavigationView.visibility = when(destination.id){
                R.id.SignUpFragment -> View.GONE
                R.id.loginFragment -> View.GONE
                R.id.onBoardingFragment -> View.GONE
                R.id.onBoardingFragment2 -> View.GONE

                else -> View.VISIBLE
            }
        }

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
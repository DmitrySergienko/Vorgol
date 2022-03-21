package ru.ds.vorgol

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.ds.vorgol.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initBottomNavigation()
    }


    private fun initBottomNavigation() {
        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.bottom_sector -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, SectorsFragment()).commit()
                    true
                }
                R.id.bottom_settings -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, SettingsFragment()).commit()
                    true
                }
                R.id.bottom_about -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, AboutFragment()).commit()
                    true
                }
                else -> true
            }
        }
        //default view
        binding.bottomNavigationView.selectedItemId = R.id.bottom_sector
    }

}
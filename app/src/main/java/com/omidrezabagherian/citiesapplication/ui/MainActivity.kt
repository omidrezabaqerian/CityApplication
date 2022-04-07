package com.omidrezabagherian.citiesapplication.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.omidrezabagherian.citiesapplication.ui.first.CityFragment
import com.omidrezabagherian.citiesapplication.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().replace(R.id.container, CityFragment())
            .setReorderingAllowed(true).commit()

    }
}
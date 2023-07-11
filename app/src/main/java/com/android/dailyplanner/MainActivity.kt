package com.android.dailyplanner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.dailyplanner.presentation.ui.calendar.CalendarFragment
import com.android.dailyplanner.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .add(R.id.main_activity__fragment_container, CalendarFragment())
            .commit()
    }
}

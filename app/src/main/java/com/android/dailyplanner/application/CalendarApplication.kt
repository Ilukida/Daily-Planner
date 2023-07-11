package com.android.dailyplanner.application

import android.app.Application
import com.android.dailyplanner.data.db.EventDao
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltAndroidApp
class CalendarApplication : Application() {

    @Inject
    lateinit var eventDao: EventDao

    override fun onCreate() {
        super.onCreate()

    }
}

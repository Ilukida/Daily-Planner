package com.android.dailyplanner.data.repository

import com.android.dailyplanner.data.db.EventEntity

interface ICalendarRepository {
    suspend fun getListOfEventByDate(date: String): List<EventEntity>

}

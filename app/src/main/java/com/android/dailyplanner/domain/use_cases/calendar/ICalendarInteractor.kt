package com.android.dailyplanner.domain.use_cases.calendar

import com.android.dailyplanner.data.db.Event

interface ICalendarInteractor {
    suspend fun getListOfEventByDate(date: String): List<Event>
}

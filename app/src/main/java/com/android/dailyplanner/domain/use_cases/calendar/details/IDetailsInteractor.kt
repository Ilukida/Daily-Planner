package com.android.dailyplanner.domain.use_cases.calendar.details

import com.android.dailyplanner.data.db.Event

interface IDetailsInteractor {
    suspend fun getEvent(eventId: Long): Event
}

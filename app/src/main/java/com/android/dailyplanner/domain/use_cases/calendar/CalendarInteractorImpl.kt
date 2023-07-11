package com.android.dailyplanner.domain.use_cases.calendar

import com.android.dailyplanner.data.db.Event
import com.android.dailyplanner.data.db.mapToDomain
import com.android.dailyplanner.data.repository.ICalendarRepository
import javax.inject.Inject

class CalendarInteractorImpl @Inject constructor(
    private val calendarRepository: ICalendarRepository
) : ICalendarInteractor {
    override suspend fun getListOfEventByDate(date: String): List<Event> {
        return calendarRepository.getListOfEventByDate(date).map { it.mapToDomain() }
    }

}

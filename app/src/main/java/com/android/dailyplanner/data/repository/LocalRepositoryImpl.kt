package com.android.dailyplanner.data.repository

import android.util.Log
import com.android.dailyplanner.data.db.EventDao
import com.android.dailyplanner.data.db.EventEntity
import com.android.dailyplanner.utils.Utils
import javax.inject.Inject

class LocalRepositoryImpl @Inject constructor(private val eventDao: EventDao) :
    ICalendarRepository,
    ICreateRepository,
    IDetailsRepository {

    override suspend fun getListOfEventByDate(date: String): List<EventEntity> {
        val endDate = (date.toLong() + Utils.ONE_DAY).toString()
        return eventDao.getEventListByDate(date, endDate)
    }

    override suspend fun createEvent(event: EventEntity) {
        eventDao.insertEvent(event)
    }

    override suspend fun getEvent(eventId: Long) : EventEntity {
        return eventDao.getEvent(eventId)
    }

}

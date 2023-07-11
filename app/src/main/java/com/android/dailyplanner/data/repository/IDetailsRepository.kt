package com.android.dailyplanner.data.repository

import com.android.dailyplanner.data.db.EventEntity

interface IDetailsRepository {
    suspend fun getEvent(eventId: Long): EventEntity
}

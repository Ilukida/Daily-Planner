package com.android.dailyplanner.data.repository

import com.android.dailyplanner.data.db.EventEntity

interface ICreateRepository {
    suspend fun createEvent(event: EventEntity)
}

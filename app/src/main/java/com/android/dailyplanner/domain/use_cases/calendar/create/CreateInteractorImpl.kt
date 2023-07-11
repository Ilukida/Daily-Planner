package com.android.dailyplanner.domain.use_cases.calendar.create

import com.android.dailyplanner.data.db.EventEntity
import com.android.dailyplanner.data.repository.ICreateRepository
import com.android.dailyplanner.utils.Utils
import com.android.dailyplanner.utils.convertToStartHourInUnix
import javax.inject.Inject

class CreateInteractorImpl @Inject constructor(
    private val createRepository: ICreateRepository
) : ICreateInteractor {

    override suspend fun createEvent(
        date: String,
        time: String,
        name: String,
        description: String
    ) {
        val dateStart = time.convertToStartHourInUnix(date)
        val dateFinish = (dateStart.toLong() + Utils.ONE_HOUR).toString()
        createRepository.createEvent(
            EventEntity(
                id = null,
                dateStart = dateStart,
                dateFinish = dateFinish,
                name = name,
                description = description
            )
        )
    }

}

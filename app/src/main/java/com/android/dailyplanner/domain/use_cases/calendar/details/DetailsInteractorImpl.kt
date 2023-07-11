package com.android.dailyplanner.domain.use_cases.calendar.details

import com.android.dailyplanner.data.db.Event
import com.android.dailyplanner.data.db.mapToDomain
import com.android.dailyplanner.data.repository.IDetailsRepository
import javax.inject.Inject

class DetailsInteractorImpl @Inject constructor(private val detailsRepository: IDetailsRepository): IDetailsInteractor {
    override suspend fun getEvent(eventId: Long): Event {
        return detailsRepository.getEvent(eventId).mapToDomain()
    }
}

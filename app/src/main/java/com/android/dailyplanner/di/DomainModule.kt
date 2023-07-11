package com.android.dailyplanner.di

import com.android.dailyplanner.data.db.EventDao
import com.android.dailyplanner.data.repository.ICalendarRepository
import com.android.dailyplanner.data.repository.ICreateRepository
import com.android.dailyplanner.data.repository.IDetailsRepository
import com.android.dailyplanner.data.repository.LocalRepositoryImpl
import com.android.dailyplanner.domain.use_cases.calendar.CalendarInteractorImpl
import com.android.dailyplanner.domain.use_cases.calendar.ICalendarInteractor
import com.android.dailyplanner.domain.use_cases.calendar.create.CreateInteractorImpl
import com.android.dailyplanner.domain.use_cases.calendar.create.ICreateInteractor
import com.android.dailyplanner.domain.use_cases.calendar.details.DetailsInteractorImpl
import com.android.dailyplanner.domain.use_cases.calendar.details.IDetailsInteractor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DomainModule {

    @Singleton
    @Provides
    fun provideCalendarInteractor(
        calendarRepository: ICalendarRepository
    ): ICalendarInteractor {
        return CalendarInteractorImpl(calendarRepository = calendarRepository)
    }

    @Singleton
    @Provides
    fun provideCreateInteractor(
        createRepository: ICreateRepository
    ): ICreateInteractor {
        return CreateInteractorImpl(createRepository = createRepository)
    }

    @Singleton
    @Provides
    fun provideDetailsInteractor(
        detailsRepository: IDetailsRepository
    ): IDetailsInteractor {
        return DetailsInteractorImpl(detailsRepository = detailsRepository)
    }

    @Singleton
    @Provides
    fun provideLocalCalendarRepository(eventDao: EventDao): ICalendarRepository {
        return LocalRepositoryImpl(eventDao)
    }

    @Singleton
    @Provides
    fun provideLocalCreateRepository(eventDao: EventDao): ICreateRepository {
        return LocalRepositoryImpl(eventDao)
    }

    @Singleton
    @Provides
    fun provideLocalDetailsRepository(eventDao: EventDao): IDetailsRepository {
        return LocalRepositoryImpl(eventDao)
    }

}

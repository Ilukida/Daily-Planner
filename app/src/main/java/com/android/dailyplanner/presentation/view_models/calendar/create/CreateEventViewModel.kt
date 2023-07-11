package com.android.dailyplanner.presentation.view_models.calendar.create

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.dailyplanner.domain.use_cases.calendar.create.ICreateInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CreateEventViewModel @Inject constructor(private val interactor: ICreateInteractor) : ViewModel() {



    fun createEvent(date: String, time: String, name: String, description: String) {
        viewModelScope.launch(Dispatchers.IO) {
            interactor.createEvent(
                date = date,
                time = time,
                name = name,
                description = description,
            )
        }
    }
}

package com.android.dailyplanner.presentation.view_models.calendar.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.dailyplanner.data.db.Event
import com.android.dailyplanner.domain.use_cases.calendar.details.IDetailsInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class DetailEventViewModel @Inject constructor(private val interactor: IDetailsInteractor) : ViewModel() {

    private val _event = MutableStateFlow<Event?>(null)
    val event: StateFlow<Event?> = _event

    fun getEvent(eventId: Long) {
        viewModelScope.launch(Dispatchers.IO) {
            val eventResult = interactor.getEvent(eventId)
            withContext(Dispatchers.Main) {
                _event.value = eventResult
            }
        }
    }
}

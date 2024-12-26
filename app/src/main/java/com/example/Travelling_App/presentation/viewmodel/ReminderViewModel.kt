
// ReminderViewModel.kt
package com.example.Travelling_App.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.Travelling_App.domain.models.Reminder
import com.example.Travelling_App.domain.usecase.reminderUsecase.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ReminderViewModel(
    private val getPlannedRemindersUsecase: GetPlannedRemindersUsecase,
    private val getWishListRemindersUsecase: GetWishListRemindersUsecase,
    private val getAllRemindersUsecase: GetAllRemindersUsecase,
    private val insertReminderUsecase: InsertReminderUsecase,
    private val deleteReminderUsecase: DeleteReminderUsecase,
    private val deleteAllRemindersUsecase: DeleteAllRemindersUsecase,
    private val getReminderByIdUsecase: GetReminderByIdUsecase
) : ViewModel() {

    private val _plannedReminders = MutableStateFlow<List<Reminder>>(emptyList())
    val plannedReminders: StateFlow<List<Reminder>> get() = _plannedReminders

    private val _wishListReminders = MutableStateFlow<List<Reminder>>(emptyList())
    val wishListReminders: StateFlow<List<Reminder>> get() = _wishListReminders

    init {
        fetchPlannedReminders(1) // Example userId
        fetchWishListReminders(1) // Example userId
    }

    fun fetchPlannedReminders(userId: Int) {
        viewModelScope.launch {
            _plannedReminders.value = getPlannedRemindersUsecase(userId)
        }
    }

    fun fetchWishListReminders(userId: Int) {
        viewModelScope.launch {
            _wishListReminders.value = getWishListRemindersUsecase(userId)
        }
    }

    fun fetchAllReminders() {
        viewModelScope.launch {
            val allReminders = getAllRemindersUsecase()
            _plannedReminders.value = allReminders.filter { it.reminderDate != null }
            _wishListReminders.value = allReminders.filter { it.reminderDate == null }
        }
    }

    fun addReminder(reminder: Reminder) {
        viewModelScope.launch {
            insertReminderUsecase(reminder)
            fetchAllReminders()
        }
    }

    fun deleteReminder(reminder: Reminder) {
        viewModelScope.launch {
            deleteReminderUsecase(reminder)
            fetchAllReminders()
        }
    }

    fun deleteAllReminders() {
        viewModelScope.launch {
            deleteAllRemindersUsecase()
            _plannedReminders.value = emptyList()
            _wishListReminders.value = emptyList()
        }
    }

    fun getReminderById(reminderId: Int, onResult: (Reminder?) -> Unit) {
        viewModelScope.launch {
            val reminder = getReminderByIdUsecase(reminderId)
            onResult(reminder)
        }
    }
}

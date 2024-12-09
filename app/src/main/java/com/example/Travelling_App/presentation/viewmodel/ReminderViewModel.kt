package com.example.Travelling_App.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.Travelling_App.domain.models.Reminder
import kotlinx.coroutines.launch
import com.example.Travelling_App.domain.usecase.ReminderUsecase

class ReminderViewModel(private val reminderUsecase: ReminderUsecase) : ViewModel() {

    fun getAllReminders(onResult: (List<Reminder>) -> Unit) {
        viewModelScope.launch {
            val reminders = reminderUsecase.getAllReminders()
            onResult(reminders)
        }
    }

    fun getReminderById(reminderId: Int, onResult: (Reminder?) -> Unit) {
        viewModelScope.launch {
            val reminder = reminderUsecase.getReminderById(reminderId)
            onResult(reminder)
        }
    }

    fun insertReminder(reminder: Reminder, onComplete: () -> Unit) {
        viewModelScope.launch {
            reminderUsecase.insertReminder(reminder)
            onComplete()
        }
    }

    fun updateReminder(reminder: Reminder, onComplete: () -> Unit) {
        viewModelScope.launch {
            reminderUsecase.updateReminder(reminder)
            onComplete()
        }
    }

    fun deleteReminderById(reminderId: Int, onComplete: () -> Unit) {
        viewModelScope.launch {
            reminderUsecase.deleteReminderById(reminderId)
            onComplete()
        }
    }
    fun deleteAllReminders(onComplete: () -> Unit) {
        viewModelScope.launch {
            reminderUsecase.deleteAllReminders()
            onComplete()
        }
    }
    fun getRemindersByUserId(userId: Int, onResult: (List<Reminder>) -> Unit) {
        viewModelScope.launch {
            val reminders = reminderUsecase.getRemindersByUserId(userId)
            onResult(reminders)
        }
    }
    fun getRemindersByReminderDate(reminderDate: String, onResult: (List<Reminder>) -> Unit) {
        viewModelScope.launch {
            val reminders = reminderUsecase.getRemindersByReminderDate(reminderDate)
            onResult(reminders)
        }
    }

    fun getRemindersByReminderNote(reminderNote: String, onResult: (List<Reminder>) -> Unit) {
        viewModelScope.launch {
            val reminders = reminderUsecase.getRemindersByReminderNote(reminderNote)
            onResult(reminders)
        }
    }

    fun getRemindersByUserIdAndReminderDate(userId: Int, reminderDate: String, onResult: (List<Reminder>) -> Unit) {
        viewModelScope.launch {
            val reminders = reminderUsecase.getRemindersByUserIdAndReminderDate(userId, reminderDate)
            onResult(reminders)
        }
    }

    fun getRemindersByUserIdAndReminderNote(userId: Int, reminderNote: String, onResult: (List<Reminder>) -> Unit) {
        viewModelScope.launch {
            val reminders = reminderUsecase.getRemindersByUserIdAndReminderNote(userId, reminderNote)
            onResult(reminders)
        }
    }

    fun getRemindersByReminderDateAndReminderNote(reminderDate: String, reminderNote: String, onResult: (List<Reminder>) -> Unit) {
        viewModelScope.launch {
            val reminders = reminderUsecase.getRemindersByReminderDateAndReminderNote(reminderDate, reminderNote)
            onResult(reminders)
        }
    }
}
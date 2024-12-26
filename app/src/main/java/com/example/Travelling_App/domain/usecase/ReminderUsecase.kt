package com.example.Travelling_App.domain.usecase

import com.example.Travelling_App.data.repositories.ReminderRepository
import com.example.Travelling_App.domain.models.Reminder

class ReminderUsecase(private val reminderRepository: ReminderRepository) {
    suspend fun getAllReminders(): List<Reminder> {
        return reminderRepository.getAllReminders()
    }

    suspend fun getReminderById(reminderId: Int): Reminder? {
        return reminderRepository.getReminderById(reminderId)
    }

    suspend fun insertReminder(reminder: Reminder) {
        reminderRepository.insertReminder(reminder)
    }

    suspend fun updateReminder(reminder: Reminder) {
        reminderRepository.updateReminder(reminder)
    }

    suspend fun deleteAllReminders() {
        reminderRepository.deleteAllReminders()
    }

    suspend fun getRemindersByReminderDate(reminderDate: String): List<Reminder> {
        return reminderRepository.getRemindersByReminderDate(reminderDate)
    }

    suspend fun getRemindersByUserIdAndReminderDate(userId: Int, reminderDate: String): List<Reminder> {
        return reminderRepository.getRemindersByUserIdAndReminderDate(userId, reminderDate)
    }

    suspend fun deleteReminderById(reminderId: Int) {
        val reminder = reminderRepository.getReminderById(reminderId)
        reminder?.let {
            reminderRepository.deleteReminder(it)
        }
    }

    suspend fun GetWishlistRemindersUsecase(userId: Int): List<Reminder> {
        return reminderRepository.getWishListReminders(userId)
    }

    suspend fun GetPlannedRemindersUsecase(userId: Int): List<Reminder> {
        return reminderRepository.getPlannedReminders(userId)
    }
}
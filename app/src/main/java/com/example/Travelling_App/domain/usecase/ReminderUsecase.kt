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

    suspend fun deleteReminderById(reminderId: Int) {
        reminderRepository.deleteReminderById(reminderId)
    }
    suspend fun deleteAllReminders() {
        reminderRepository.deleteAllReminders()
    }
    suspend fun getRemindersByUserId(userId: Int): List<Reminder> {
        return reminderRepository.getRemindersByUserId(userId)
    }
    suspend fun getRemindersByReminderDate(reminderDate: String): List<Reminder> {
        return reminderRepository.getRemindersByReminderDate(reminderDate)
    }

    suspend fun getRemindersByReminderNote(reminderNote: String): List<Reminder> {
        return reminderRepository.getRemindersByReminderNote(reminderNote)
    }
    suspend fun getRemindersByUserIdAndReminderDate(userId: Int, reminderDate: String): List<Reminder> {
        return reminderRepository.getRemindersByUserIdAndReminderDate(userId, reminderDate)
    }

    suspend fun getRemindersByUserIdAndReminderNote(userId: Int, reminderNote: String): List<Reminder> {
        return reminderRepository.getRemindersByUserIdAndReminderNote(userId, reminderNote)
    }

    fun getRemindersByReminderDateAndReminderNote(reminderDate: String, reminderNote: String): List<Reminder> {
        return reminderRepository.getRemindersByReminderDateAndReminderNote(reminderDate, reminderNote)
    }
}
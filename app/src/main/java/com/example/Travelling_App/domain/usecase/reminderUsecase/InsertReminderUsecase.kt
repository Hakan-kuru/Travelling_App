package com.example.Travelling_App.domain.usecase.reminderUsecase

import com.example.Travelling_App.data.repositories.ReminderRepository
import com.example.Travelling_App.domain.models.Reminder

class InsertReminderUsecase(
    private val reminderRepository: ReminderRepository
) {
    suspend operator fun invoke(reminder: Reminder) {
        reminderRepository.insertReminder(reminder)
    }
}

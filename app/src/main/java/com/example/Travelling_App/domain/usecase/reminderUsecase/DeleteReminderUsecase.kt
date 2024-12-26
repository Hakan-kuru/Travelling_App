package com.example.Travelling_App.domain.usecase.reminderUsecase

import com.example.Travelling_App.data.repositories.ReminderRepository
import com.example.Travelling_App.domain.models.Reminder

class DeleteReminderUsecase(private val reminderRepository: ReminderRepository) {
    suspend operator fun invoke(reminder: Reminder) {
        reminderRepository.deleteReminder(reminder)
    }
}

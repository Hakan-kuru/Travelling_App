package com.example.Travelling_App.domain.usecase.reminderUsecase

import com.example.Travelling_App.data.repositories.ReminderRepository

class DeleteAllRemindersUsecase(private val reminderRepository: ReminderRepository) {
    suspend operator fun invoke() {
        reminderRepository.deleteAllReminders()
    }
}

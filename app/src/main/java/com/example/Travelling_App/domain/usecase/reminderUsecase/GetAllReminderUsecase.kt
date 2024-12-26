package com.example.Travelling_App.domain.usecase.reminderUsecase

import com.example.Travelling_App.data.repositories.ReminderRepository
import com.example.Travelling_App.domain.models.Reminder

class GetAllRemindersUsecase(
    private val reminderRepository: ReminderRepository
) {
    suspend operator fun invoke(): List<Reminder> {
        return reminderRepository.getAllReminders()
    }
}

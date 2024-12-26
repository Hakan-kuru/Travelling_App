package com.example.Travelling_App.domain.usecase.reminderUsecase

import com.example.Travelling_App.data.repositories.ReminderRepository
import com.example.Travelling_App.domain.models.Reminder

class GetWishListRemindersUsecase(private val reminderRepository: ReminderRepository) {
    suspend operator fun invoke(userId: Int): List<Reminder> {
        return reminderRepository.getWishListReminders(userId)
    }
}

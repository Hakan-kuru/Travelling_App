package com.example.Travelling_App.data.repositories

import com.example.Travelling_App.data.database.local.daos.ReminderDao
import com.example.Travelling_App.data.database.local.entity.ReminderEntity
import com.example.Travelling_App.domain.models.Reminder

class ReminderRepository(private val reminderDao: ReminderDao) {

    // Planlanmış hatırlatıcıları getir
    suspend fun getPlannedReminders(userId: Int): List<Reminder> {
        return reminderDao.getPlannedReminders(userId).map { it.toDomainModel() }
    }

    // İstek listesi hatırlatıcılarını getir
    suspend fun getWishListReminders(userId: Int): List<Reminder> {
        return reminderDao.getWishListReminders(userId).map { it.toDomainModel() }
    }

    // Hatırlatıcı sil
    suspend fun deleteReminder(reminder: Reminder){
        reminderDao.deleteReminder(reminder)
    }

    suspend fun getAllReminders(): List<Reminder> {
        return reminderDao.getAllReminders().map { it.toDomainModel() }
    }

    suspend fun getReminderById(reminderId: Int): Reminder? {
        return reminderDao.getReminderById(reminderId)?.toDomainModel()
    }

    suspend fun insertReminder(reminder: Reminder) {
        reminderDao.insertReminder(reminder)
    }

    suspend fun updateReminder(reminder: Reminder) {
        reminderDao.insertReminder(reminder)
    }

    suspend fun deleteAllReminders() {
        reminderDao.deleteAllReminders()
    }

    suspend fun getRemindersByReminderDate(reminderDate: String): List<Reminder> {
        return reminderDao.getRemindersByReminderDate(reminderDate).map { it.toDomainModel() }
    }

    suspend fun getRemindersByUserIdAndReminderDate(userId: Int, reminderDate: String): List<Reminder> {
        return reminderDao.getRemindersByUserIdAndReminderDate(userId, reminderDate).map { it.toDomainModel() }
    }
}
fun Reminder.toEntity() = ReminderEntity(reminderId, userId, destinationId, reminderDate, reminderNote)
fun ReminderEntity.toDomainModel() = Reminder(reminderId, userId, destinationId,  reminderDate, reminderNote)
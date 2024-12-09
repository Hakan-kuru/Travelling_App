package com.example.Travelling_App.data.database.repositories

import com.example.Travelling_App.data.database.local.daos.ReminderDao
import com.example.Travelling_App.data.database.local.entity.ReminderEntity
import com.example.Travelling_App.domain.models.Reminder

class ReminderRepository(private val reminderDao: ReminderDao) {

    suspend fun getAllReminders(): List<Reminder> {
        return reminderDao.getAllReminders().map { it.toDomainModel() }
    }

    suspend fun getReminderById(reminderId: Int): Reminder? {
        return reminderDao.getReminderById(reminderId)?.toDomainModel()
    }

    suspend fun insertReminder(reminder: Reminder) {
        reminderDao.insertReminder(reminder.toEntity())
    }

    suspend fun updateReminder(reminder: Reminder) {
        reminderDao.insertReminder(reminder.toEntity())
    }

    suspend fun deleteReminderById(reminderId: Int ) {
         reminderDao.deleteReminderById(reminderId)
    }

    suspend fun deleteAllReminders() {
        reminderDao.deleteAllReminders()
    }

    suspend fun getRemindersByUserId(userId: Int): List<Reminder> {
        return reminderDao.getRemindersByUserId(userId).map { it.toDomainModel() }
    }

    suspend fun getRemindersByReminderDate(reminderDate: String): List<Reminder> {
        return reminderDao.getRemindersByReminderDate(reminderDate).map { it.toDomainModel() }
    }

    suspend fun getRemindersByReminderNote(reminderNote: String): List<Reminder> {
        return reminderDao.getRemindersByReminderNote(reminderNote).map { it.toDomainModel() }
    }

    suspend fun getRemindersByUserIdAndReminderDate(userId: Int, reminderDate: String): List<Reminder> {
        return reminderDao.getRemindersByUserIdAndReminderDate(userId, reminderDate).map { it.toDomainModel() }
    }

    suspend fun getRemindersByUserIdAndReminderNote(userId: Int, reminderNote: String): List<Reminder> {
        return reminderDao.getRemindersByUserIdAndReminderNote(userId, reminderNote).map { it.toDomainModel() }
    }

    fun getRemindersByReminderDateAndReminderNote(reminderDate: String, reminderNote: String): List<Reminder> {
        return reminderDao.getRemindersByReminderDateAndReminderNote(reminderDate, reminderNote).map { it.toDomainModel() }
    }
}
fun Reminder.toEntity() = ReminderEntity(reminderId, userId, destinationId, reminderDate, reminderNote)
fun ReminderEntity.toDomainModel() = Reminder(reminderId, userId, destinationId,  reminderDate, reminderNote)
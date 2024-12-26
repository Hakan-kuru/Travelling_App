package com.example.Travelling_App.data.database.local.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.Travelling_App.data.database.local.entity.ReminderEntity
import com.example.Travelling_App.domain.models.Reminder

@Dao
interface ReminderDao {

    // Planlanmış hatırlatıcıları getir (Tarih null değil ve kullanıcıya ait olanlar)
    @Query("SELECT * FROM reminder_table WHERE userId = :userId AND reminderDate IS NOT NULL ORDER BY reminderDate ASC")
    fun getPlannedReminders(userId: Int): List<ReminderEntity>

    // İstek listesi hatırlatıcılarını getir (Tarih null ve kullanıcıya ait olanlar)
    @Query("SELECT * FROM reminder_table WHERE userId = :userId AND reminderDate IS NULL")
    fun getWishListReminders(userId: Int): List<ReminderEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertReminder(reminder: Reminder) // Yeni bir hatırlatıcı ekler.

    @Delete
    suspend fun deleteReminder(reminder: Reminder) // Var olan bir hatırlatıcıyı siler.

    @Query("SELECT * FROM reminder_table")
    suspend fun getAllReminders(): List<ReminderEntity>

    @Query("SELECT * FROM reminder_table WHERE reminderId = :reminderId")
    suspend fun getReminderById(reminderId: Int): ReminderEntity?

    @Query("DELETE FROM reminder_table")
    suspend fun deleteAllReminders()

    @Query("SELECT * FROM reminder_table WHERE reminderDate = :reminderDate")
    suspend fun getRemindersByReminderDate(reminderDate: String): List<ReminderEntity>

    @Query("SELECT * FROM reminder_table WHERE userId = :userId AND reminderDate = :reminderDate")
    suspend fun getRemindersByUserIdAndReminderDate(userId: Int, reminderDate: String): List<ReminderEntity>
}
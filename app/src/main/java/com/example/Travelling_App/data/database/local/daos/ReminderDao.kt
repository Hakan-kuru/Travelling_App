package com.example.Travelling_App.data.database.local.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.Travelling_App.data.database.local.entity.ReminderEntity

@Dao( )
interface ReminderDao {
    @Query("SELECT * FROM reminder_table")
    suspend fun getAllReminders(): List<ReminderEntity>

    @Query("SELECT * FROM reminder_table WHERE reminderId = :reminderId")
    suspend fun getReminderById(reminderId: Int): ReminderEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertReminder(reminder: ReminderEntity)

    @Query("DELETE FROM reminder_table WHERE reminderId = :reminderId")
    suspend fun deleteReminderById(reminderId: Int)

    @Query("DELETE FROM reminder_table")
    suspend fun deleteAllReminders()

    @Query("SELECT * FROM reminder_table WHERE userId = :userId")
    suspend fun getRemindersByUserId(userId: Int): List<ReminderEntity>


    @Query("SELECT * FROM reminder_table WHERE reminderDate = :reminderDate")
    suspend fun getRemindersByReminderDate(reminderDate: String): List<ReminderEntity>

    @Query("SELECT * FROM reminder_table WHERE reminderNote = :reminderNote")
    suspend fun getRemindersByReminderNote(reminderNote: String): List<ReminderEntity>

    @Query("SELECT * FROM reminder_table WHERE userId = :userId AND reminderDate = :reminderDate")
    suspend fun getRemindersByUserIdAndReminderDate(userId: Int, reminderDate: String): List<ReminderEntity>

    @Query("SELECT * FROM reminder_table WHERE userId = :userId AND reminderNote = :reminderNote")
    suspend fun getRemindersByUserIdAndReminderNote(userId: Int, reminderNote: String): List<ReminderEntity>

    @Query("SELECT * FROM reminder_table WHERE reminderDate = :reminderDate AND reminderNote = :reminderNote")
    fun getRemindersByReminderDateAndReminderNote(reminderDate: String, reminderNote: String): List<ReminderEntity>
}
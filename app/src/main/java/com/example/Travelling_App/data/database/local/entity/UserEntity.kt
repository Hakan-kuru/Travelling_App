package com.example.Travelling_App.data.database.local.entity

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import androidx.room.Entity

@Entity(tableName = "user_table")
//@Entity içinde (tableName = "user_table" ) kullanılmasaydı tablo ismi otomatik olarak clas ismi-User- olurdu
data class UserEntity(
    //@PrimaryKey(autoGenerate) benzersiz bir id oluşturur
    @PrimaryKey(autoGenerate = true) val userId: Int,
    //ColumnInfo(name = "name") burada kolon ismi belirtilir,
    // eğer kullanılmasaydı column ismi otomatik olarak değişken ismi-username- olurdu
    @ColumnInfo(name = "name") val username: String,
    @ColumnInfo(name = "email") val email: String,
    @ColumnInfo(name = "budget") val budget: Double?,
    @ColumnInfo(name = "preferences") val preferences: String?,
    @ColumnInfo(name = "password") val password: String
)